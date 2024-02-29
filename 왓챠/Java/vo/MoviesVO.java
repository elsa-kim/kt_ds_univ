package com.ktdsuniversity.watcha.vo;

import java.util.List;

public class MoviesVO {
	private String movieId;
	private String title;
	private int minimumAge;
	private String openYear;
	private int runningTime;
	private String genre;
	private String atmosphere;
	private String location;
	private String summary;
	private String poster;
	
	
	// Has a
	private List<DirectorsVO> directors;
	private List<CastsVO> casts;


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getMinimumAge() {
		return minimumAge;
	}


	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}


	public String getOpenYear() {
		return openYear;
	}


	public void setOpenYear(String openYear) {
		this.openYear = openYear;
	}


	public int getRunningTime() {
		return runningTime;
	}


	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getAtmosphere() {
		return atmosphere;
	}


	public void setAtmosphere(String atmosphere) {
		this.atmosphere = atmosphere;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public List<DirectorsVO> getDirectors() {
		return directors;
	}


	public void setDirectors(List<DirectorsVO> directors) {
		this.directors = directors;
	}
	
	
	
}
