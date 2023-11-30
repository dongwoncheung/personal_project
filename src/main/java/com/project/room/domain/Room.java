package com.project.room.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Room {
	
	private int id;
	private int userId;
	private String title;
	private String content;
	private String imageUrl;
	private String homeAddress;
	private String location;
	private String price;
	private Date createdAt;
	private Date updatedAt;

}
