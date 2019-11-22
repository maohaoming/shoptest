package com.zzb.test.admin.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class UmsPermission implements Serializable {
    /**
     * 权限表id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 父id
     *
     * @mbggenerated
     */
    private Long pid;

    /**
     * 名称
     *
     * @mbggenerated
     */
    private String perName;

    /**
     * 值
     *
     * @mbggenerated
     */
    private String preValue;

    /**
     * 图标
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 类型  0->目录 1->菜单 2->按钮
     *
     * @mbggenerated
     */
    private Integer perType;

    /**
     * 资源路由
     *
     * @mbggenerated
     */
    private String perPath;

    /**
     * 状态 0->禁用 1->启用
     *
     * @mbggenerated
     */
    private Boolean status;

    private Date createTime;

    private Long creatorId;

    private Date modifyTime;

    private Long modifierId;

    private String delStatus;

    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPerType() {
        return perType;
    }

    public void setPerType(Integer perType) {
        this.perType = perType;
    }

    public String getPerPath() {
        return perPath;
    }

    public void setPerPath(String perPath) {
        this.perPath = perPath;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", perName=").append(perName);
        sb.append(", preValue=").append(preValue);
        sb.append(", icon=").append(icon);
        sb.append(", perType=").append(perType);
        sb.append(", perPath=").append(perPath);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifierId=").append(modifierId);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}