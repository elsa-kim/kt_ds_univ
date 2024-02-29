package com.ktdsuniversity.watcha.vo;

public class CastsVO {
	
	private String castId;
	private String actorId;
	private String movieId;
	private String characterName;
	private String mainActorYn;
	
	// actors 관점
	private MoviesVO movies;
	private ActorsVO actors;
	
	public MoviesVO getMovies() {
		return movies;
	}
	public void setMovies(MoviesVO movies) {
		this.movies = movies;
	}
	public String getCastId() {
		return castId;
	}
	public void setCastId(String castId) {
		this.castId = castId;
	}
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getCharacterName() {
		return characterName;
	}
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public String getMainActorYn() {
		return mainActorYn;
	}
	public void setMainActorYn(String mainActorYn) {
		this.mainActorYn = mainActorYn;
	}
	
	

}
