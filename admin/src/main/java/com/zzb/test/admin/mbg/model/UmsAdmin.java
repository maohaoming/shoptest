package com.zzb.test.admin.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class UmsAdmin implements Serializable {
    /**
     * 用户表id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户名
     *
     * @mbggenerated
     */
    private String username;

    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 头像
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 邮箱
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 状态  0->禁用  1->启用
     *
     * @mbggenerated
     */
    private Boolean status;

    private Integer sort;

    /**
     * 最后一次登陆时间
     *
     * @mbggenerated
     */
    private Date loginTime;

    private Date createTime;

    private Long creatorId;

    private Date modifyTime;

    private Long modifierId;

    private String delStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", icon=").append(icon);
        sb.append(", email=").append(email);
        sb.append(", nickName=").append(nickName);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", sort=").append(sort);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifierId=").append(modifierId);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}