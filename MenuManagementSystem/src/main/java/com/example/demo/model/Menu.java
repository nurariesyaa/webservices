package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "menuitems")
	public class Menu {
		
		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "Name")
		private String name;
		
		@Column(name = "price")
		private double price;

		@Column(name = "category")
		private String category;
		
		@Column(name = "status")
		private String status;
		
		@Column(name = "rate")
		private int rate;
		
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

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getRate() {
			return rate;
		}

		public void setRate(int rate) {
			this.rate = rate;
		}
	}
