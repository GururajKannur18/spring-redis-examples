package com.concretepage.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String description;
	private String image;
	private int shares;
	private Author author;
}
