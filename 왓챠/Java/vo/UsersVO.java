package com.ktdsuniversity.watcha.vo;

import java.util.List;

public class UsersVO {

	private String userId;
	private String name;
	private String background;
	private String profile;
	
	//Has A
	//한명의 회원은 여러개의 평점을 남길 수 있다
	/**
	 * 회원이 남긴 평점 목록
	 */
	private List<RatingsVO> ratings;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public List<RatingsVO> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingsVO> ratings) {
		this.ratings = ratings;
	}
	
	
	
}
