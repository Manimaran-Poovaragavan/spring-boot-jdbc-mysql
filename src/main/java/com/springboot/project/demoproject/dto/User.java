package com.springboot.project.demoproject.dto;

public class User {
	
   private Integer bookingId;
   private String movie;
   private String actor;
   private String ticket;
   private String timing;

	
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer string) {
		this.bookingId = string;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	
}
