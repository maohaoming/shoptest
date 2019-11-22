package com.zzb.test.admin.service.impl;

import cn.hutool.core.lang.Assert;
import com.zzb.test.admin.dao.UmsAdminRoleRelationDao;
import com.zzb.test.admin.mbg.mapper.UmsAdminMapper;
import com.zzb.test.admin.mbg.model.UmsAdmin;
import com.zzb.test.admin.mbg.model.UmsAdminExample;
import com.zzb.test.admin.mbg.model.UmsPermission;
import com.zzb.test.admin.service.UmsAdminService;
import com.zzb.test.admin.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * 用户管理Service的impl
 * Created by zzb on 2019/11/21 17:41
 */
@Service
@Transactional
public class UmsAdminServiceImpl implements UmsAdminService {

    private static final Logger logger = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample uae = new UmsAdminExample();
        uae.createCriteria().andUsernameEqualTo(username)
                .andDelStatusEqualTo("0")
                .andStatusEqualTo(true);
        List<UmsAdmin> admins = umsAdminMapper.selectByExample(uae);
        Assert.notNull(admins,"用户名不存在");
        return admins.get(0);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminRoleRelationDao.getPermissionList(adminId);
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        //是否有相同用户名
        UmsAdminExample uae = new UmsAdminExample();
        uae.createCriteria().andUsernameEqualTo(umsAdminParam.getUsername())
                .andDelStatusEqualTo("0");
        List list = umsAdminMapper.selectByExample(uae);
        if (!CollectionUtils.isEmpty(list)) {
            return null;
        }

        umsAdminParam.setStatus(true);
        umsAdminParam.setDelStatus("0");
        umsAdminParam.setCreateTime(new Date());
        umsAdminParam.setModifyTime(new Date());
        //将密码进行加密
        String encodePassword = passwordEncoder.encode(umsAdminParam.getPassword());
        umsAdminParam.setPassword(encodePassword);
        if (umsAdminMapper.insert(umsAdminParam)<1) {
            return null;
        };
        return umsAdminParam;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            //校验用户名，封装用户实体
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //检验密码
            if (!passwordEncoder.matches(password,userDetails.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }
            //根据正确的用户名密码生成token
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            logger.warn("登录异常{}",e.getMessage());
        }

        return token;
    }
}
