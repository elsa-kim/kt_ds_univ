package com.ktdsuniversity.watcha.vo;

public class RatingsVO {
	
	private String ratingId;
	private String userId;
	private double rating;
	private String description;
	private String movieId;
	
	// Has A
	// 한 평점은 한명의 회원이 작성한다.
	/**
	 * 평점을 남긴 사용자
	 */
	private UsersVO usersVO;
	// 한 평점은 하나의 영화에 작성한다.
	/**
	 * 평점을 남긴 영화
	 */
	private MoviesVO moviesVO;
	
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public UsersVO getUsersVO() {
		return usersVO;
	}
	public void setUsersVO(UsersVO usersVO) {
		this.usersVO = usersVO;
	}
	public MoviesVO getMoviesVO() {
		return moviesVO;
	}
	public void setMoviesVO(MoviesVO moviesVO) {
		this.moviesVO = moviesVO;
	}
	
}
