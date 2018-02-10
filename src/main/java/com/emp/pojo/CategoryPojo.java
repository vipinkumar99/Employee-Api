package com.emp.pojo;

import java.util.List;

public class CategoryPojo {

	private String name;
	private String image;
	private List<String> additionalUrl;
	private int parentId;
	private Object metaInfo;

	public Object getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(Object metaInfo) {
		this.metaInfo = metaInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getAdditionalUrl() {
		return additionalUrl;
	}

	public void setAdditionalUrl(List<String> additionalUrl) {
		this.additionalUrl = additionalUrl;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	// public String getMetaInfo() {
	// return metaInfo;
	// }
	//
	// public void setMetaInfo(String metaInfo) {
	// this.metaInfo = metaInfo;
	// }
	//
}
