package com.utils;


import java.util.List;

import com.entity.ShopPermissionRoute;



public class Permissions {
private List<ShopPermissionRoute> children;
private String path;
private String component;
private String name;
private String meta;

public List<ShopPermissionRoute> getChildren() {
	return children;
}
public void setChildren(List<ShopPermissionRoute> children) {
	this.children = children;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getComponent() {
	return component;
}
public void setComponent(String component) {
	this.component = component;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMeta() {
	return meta;
}
public void setMeta(String meta) {
	this.meta = meta;
}

}
