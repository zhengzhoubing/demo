package com.bin.demo.entity;

import java.util.List;

/**
 * package: com.chinasoftinc.ppm.imp.tariff.tariffTemplate.entity
 * class: TemplateType
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/4/3.
 **/
public class TemplateType {

    private Long templateTypeId;

    private Long upTemplateTypeId;

    private String typeName;

    private String upTypeName;

    private String typeDesc;

    private String statusCd;

    private String statusName;

    private String createDate;

    private Long createStaff;

    private String updateDate;

    private Long updateStaff;

    private Long priority;

    private List<TemplateType> children;

    public TemplateType() {

    }

    public TemplateType(Long templateTypeId, String typeName) {
        this.templateTypeId = templateTypeId;
        this.typeName = typeName;
    }

    public Long getTemplateTypeId() {
        return templateTypeId;
    }

    public void setTemplateTypeId(Long templateTypeId) {
        this.templateTypeId = templateTypeId;
    }

    public Long getUpTemplateTypeId() {
        return upTemplateTypeId;
    }

    public void setUpTemplateTypeId(Long upTemplateTypeId) {
        this.upTemplateTypeId = upTemplateTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUpTypeName() {
        return upTypeName;
    }

    public void setUpTypeName(String upTypeName) {
        this.upTypeName = upTypeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public List<TemplateType> getChildren() {
        return children;
    }

    public void setChildren(List<TemplateType> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TemplateType{" +
                "templateTypeId=" + templateTypeId +
                ", upTemplateTypeId=" + upTemplateTypeId +
                ", typeName='" + typeName + '\'' +
                ", upTypeName='" + upTypeName + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                ", statusCd='" + statusCd + '\'' +
                ", statusName='" + statusName + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createStaff=" + createStaff +
                ", updateDate='" + updateDate + '\'' +
                ", updateStaff=" + updateStaff +
                ", priority=" + priority +
                ", children=" + children +
                '}';
    }
}
