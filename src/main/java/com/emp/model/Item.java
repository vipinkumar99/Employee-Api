package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Item.Columns.TABLE)
public class Item {

	interface Columns {
		String TABLE = "item";
		String ID = "id";
		String NAME = "name";
		String IMAGE = "image";
		String CATEGORYID = "categoryid";
		String QUNTITY = "quntity";
		String PRICE = "price";
		String META = "metainfo";
		String Total = "total_price";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Columns.ID)
	private int id;
	@Column(name = Columns.NAME, length = 80, nullable = false)
	private String name;
	@Column(name = Columns.IMAGE, nullable = false)
	private String image;
	@Column(name = Columns.CATEGORYID)
	private int categoryId;
	@Column(name = Columns.QUNTITY)
	private int quntity;
	@Column(name = Columns.PRICE)
	private double price;
	@Column(name = Columns.META, length = 500, nullable = false)
	private String metaInfo;
	@Column(name = Columns.Total)
	private double totalPrice;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public String getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(String metaInfo) {
		this.metaInfo = metaInfo;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
