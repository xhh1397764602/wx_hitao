package com.hzit.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 后台菜单表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
public class ShopMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * url路径
     */
    private String url;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 菜单等级(一到四级菜单)
     */
    private Integer level;
    /**
     * 菜单ID路径
     */
    private String path;
    /**
     * 描述
     */
    private String description;
    /**
     * 录入人
     */
    private Integer createdBy;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private Integer updatedBy;
    /**
     * 修改时间
     */
    private Date updatedTime;
    /**
     * 重定向
     */
    private String redirect;
    /**
     * 是否展示,0:false 1:true
     */
    private Integer alwaysShow;
    /**
     * 组件
     */
    private String component;
    /**
     * 元数据 json格式存储
     */
    private String meta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
 
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
 
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
 
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
 
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
 
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
 
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
 
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
 
    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
 
    public Integer getAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(Integer alwaysShow) {
        this.alwaysShow = alwaysShow;
    }
 
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
 
    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }
 


    @Override
    public String toString() {
        return "ShopMenu{" +
        "id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", parentId=" + parentId +
        ", sort=" + sort +
        ", level=" + level +
        ", path=" + path +
        ", description=" + description +
        ", createdBy=" + createdBy +
        ", createdTime=" + createdTime +
        ", updatedBy=" + updatedBy +
        ", updatedTime=" + updatedTime +
        ", redirect=" + redirect +
        ", alwaysShow=" + alwaysShow +
        ", component=" + component +
        ", meta=" + meta +
        "}";
    }
}