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
	/**
	 * 영화의 평점 목록
	 */
	private List<RatingsVO> ratings;


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


	public List<CastsVO> getCasts() {
		return casts;
	}


	public void setCasts(List<CastsVO> casts) {
		this.casts = casts;
	}


	public List<RatingsVO> getRatings() {
		return ratings;
	}


	public void setRatings(List<RatingsVO> ratings) {
		this.ratings = ratings;
	}
	
	public void printSimpleDescription() {
		StringBuffer result = new StringBuffer();
		result.append("영화ID: "+this.movieId);
		result.append("제목: "+this.title);
		result.append("개봉연도: "+this.openYear);
		
		System.out.println(result.toString());
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("영화ID: " + this.movieId);
		result.append("제목: " + this.title);
		result.append("개봉연도: " + this.openYear);
		result.append("관람등급: " + this.minimumAge + "세 이상 관람가");
		result.append("장르: " + this.genre);
		result.append("분위기: " + this.atmosphere);
		result.append("상영시간: " + this.runningTime + "분");
		result.append("촬영국가: " + this.location);
		result.append("줄거리: " + this.summary);
		result.append("포스터 url: " + this.poster);
		
		return result.toString();
	}
	
}
