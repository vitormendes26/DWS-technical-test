package com.dws.isobar.fm.bands.domain.model;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Band implements Serializable {

	@EqualsAndHashCode.Include
	private UUID id;

	private String name;

	private String image;

	private String genre;

	private String biography;

	private Long numPlays;

	private List<String> albums;

	public Band() {
	}

	public Band(UUID id, String name, String image, String genre, String biography, Long numPlays, List<String> albums) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.genre = genre;
		this.biography = biography;
		this.numPlays = numPlays;
		this.albums = albums;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public String getGenre() {
		return genre;
	}

	public String getBiography() {
		return biography;
	}

	public Long getNumPlays() {
		return numPlays;
	}

	public List<String> getAlbums() {
		return albums;
	}

}
