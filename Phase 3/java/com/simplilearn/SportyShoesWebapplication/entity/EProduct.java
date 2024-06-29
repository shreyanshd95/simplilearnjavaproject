package com.simplilearn.SportyShoesWebapplication.entity;

import java.math.BigDecimal;
import java.util.Date;

public class EProduct {
	// properties
		private long id;
		private String name;
		private BigDecimal price;
		private Date dateAdded;
		public EProduct(long id, String name, BigDecimal price, Date dateAdded) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.dateAdded = dateAdded;
		}
		public EProduct() {
			super();
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public Date getDateAdded() {
			return dateAdded;
		}
		public void setDateAdded(Date dateAdded) {
			this.dateAdded = dateAdded;
		}
		@Override
		public String toString() {
			return "EProduct [id=" + id + ", name=" + name + ", price=" + price + ", dateAdded=" + dateAdded + "]";
		}

}
