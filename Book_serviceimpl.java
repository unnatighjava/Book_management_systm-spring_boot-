package com.bms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.entity.Book_entity;
import com.bms.repository.Book_repository;
import com.bms.service.Book_service;

@Service
public class Book_serviceimpl implements Book_service {

	@Autowired
	Book_repository book_repository;

	@Override
	public Book_entity createbook(Book_entity book_entity) {

		return book_repository.save(book_entity);
	}

	@Override
	public List<Book_entity> fetchall(Book_entity book_entity) {
		// TODO Auto-generated method stub
		return book_repository.findAll();
	}

	@Override
	public Book_entity fetchbyid(int id, Book_entity book_entity) {
		return book_repository.findById(id).get();
	}

	@Override
	public String deletebyid(int id) {
		book_repository.deleteById(id);
		return "delete successfully";
	}

	@Override
	public Book_entity updatebyid(int id, Book_entity book_entity) {
		Book_entity bookEnt= book_repository.findById(id).get();
		bookEnt.setB_name(book_entity.getB_name());
		bookEnt.setB_price(book_entity.getB_price());
		bookEnt.setB_author(book_entity.getB_author());
		
		Book_entity bookEnt2=book_repository.save(bookEnt);
		
		return bookEnt2;
	}

}
