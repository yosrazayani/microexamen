package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "formation")
public class Formation {
	@Id
	  private String id;

	    private String name;

	    private Double prix;
	    
	   public Formation() {
		   
	   }

	public Formation(String id, String name, Double prix) {
		super();
		this.id = id;
		this.name = name;
		this.prix = prix;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
	   
}
