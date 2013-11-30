package com.ornilabs.common;

public class Action {

	private String id;
	private Integer duree;
	private Integer profondeur;
	private String start;
	private String ressource;

	public Action(String id, Integer duree, Integer profondeur, String start, String ressource) {
		this.id = id;
		this.duree = duree;
		this.profondeur = profondeur;
		this.start = start;
		this.ressource = ressource;
	}

	public String getId() {
		return id;
	}

	public Integer getDuree() {
		return duree;
	}

	public Integer getProfondeur() {
		return profondeur;
	}
	
	public String getStart() {
		return start;
	}
	
	public String getRessource() {
		return ressource;
	}

}
