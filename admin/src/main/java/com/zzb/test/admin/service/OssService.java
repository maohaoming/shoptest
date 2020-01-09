package com.zzb.test.admin.service;

import com.zzb.test.admin.dto.OssCallbackResult;
import com.zzb.test.admin.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传文件Service
 * Created by zzb on 2019/12/24 15:24
 */
public interface OssService {

    /**
     * 文件上传所需参数的生成
     * @return
     */
    OssPolicyResult policy();

    /**
     * oss上传成功后的回调
     * @param request
     * @return
     */
    OssCallbackResult callback(HttpServletRequest request);
}
