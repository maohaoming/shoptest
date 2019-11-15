package com.zzb.test.admin.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class PmsBrand implements Serializable {
    /**
     * 品牌id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 品牌名称
     *
     * @mbggenerated
     */
    private String brandName;

    /**
     * 排序
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * 是否是品牌制造商 1->是 2->否
     *
     * @mbggenerated
     */
    private String brandFactoryStatus;

    /**
     * 是否显示 0->否 1->是
     *
     * @mbggenerated
     */
    private Boolean showStatus;

    /**
     * 是否删除  0->未删除  1->删除
     *
     * @mbggenerated
     */
    private String delStatus;

    /**
     * 品牌logo图片
     *
     * @mbggenerated
     */
    private String brandLogoPic;

    /**
     * 封面图片
     *
     * @mbggenerated
     */
    private String showPic;

    /**
     * 添加时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long creatorId;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date modifyTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private Long modifierId;

    /**
     * 品牌故事
     *
     * @mbggenerated
     */
    private String brandStory;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getBrandFactoryStatus() {
        return brandFactoryStatus;
    }

    public void setBrandFactoryStatus(String brandFactoryStatus) {
        this.brandFactoryStatus = brandFactoryStatus;
    }

    public Boolean getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Boolean showStatus) {
        this.showStatus = showStatus;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getBrandLogoPic() {
        return brandLogoPic;
    }

    public void setBrandLogoPic(String brandLogoPic) {
        this.brandLogoPic = brandLogoPic;
    }

    public String getShowPic() {
        return showPic;
    }

    public void setShowPic(String showPic) {
        this.showPic = showPic;
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

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", sort=").append(sort);
        sb.append(", brandFactoryStatus=").append(brandFactoryStatus);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", delStatus=").append(delStatus);
        sb.append(", brandLogoPic=").append(brandLogoPic);
        sb.append(", showPic=").append(showPic);
        sb.append(", createTime=").append(createTime);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifierId=").append(modifierId);
        sb.append(", brandStory=").append(brandStory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}