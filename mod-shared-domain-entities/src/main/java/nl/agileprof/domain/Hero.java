package nl.agileprof.domain;

import javax.persistence.Id;

public class Hero {
	@Id
	private long id;
	
	private String name;
	
	public Hero(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
