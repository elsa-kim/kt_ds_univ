package com.ktdsuniversity.watcha.vo;

import java.util.List;

public class ActorsVO {
	
	private String actorId;
	private String profile;
	private String name;
	
	private List<CastsVO> casts;
	
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
		this.actorId = actorId;
	}
	public List<CastsVO> getCasts() {
		return casts;
	}
	public void setCasts(List<CastsVO> casts) {
		this.casts = casts;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
