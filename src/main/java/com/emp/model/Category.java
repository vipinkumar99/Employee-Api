package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Category.Columns.TABLE)
// @Table(name="Category")
public class Category {

	
	
	interface Columns {

		String TABLE = "category";
		String NAME = "name";
		String ID = "id";
		String URL = "url";
		String META = "metainfo";
		String PARENTID = "parentid";
		String IMAGE = "image";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Columns.ID)
	private int id;
	@Column(name = Columns.NAME, length = 80, nullable = false)
	private String name;
	@Column(name = Columns.IMAGE, nullable = false)
	private String image;
	@Column(name = Columns.URL, length = 100, nullable = false)
	private String additionalUrl;
	@Column(name = Columns.PARENTID)
	private int parentId;
	@Column(name = Columns.META, length = 500, nullable = false)
	private String metaInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAdditionalUrl() {
		return additionalUrl;
	}

	public void setAdditionalUrl(String additionalUrl) {
		this.additionalUrl = additionalUrl;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
	}

}
