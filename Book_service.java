package com.bms.service;

import java.util.List;

import com.bms.entity.Book_entity;

public interface Book_service {

	Book_entity createbook(Book_entity book_entity);
	
	List<Book_entity> fetchall(Book_entity book_entity);
	
	Book_entity fetchbyid(int id, Book_entity book_entity);
	
	String deletebyid(int id);
	
	Book_entity updatebyid(int id,Book_entity book_entity);
	

}
