package com.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.entity.Book_entity;
import com.bms.service.Book_service;

@RestController
@RequestMapping("/api")
public class Book_controller {

	@Autowired
	Book_service book_service;

	@PostMapping("/createbook")
	ResponseEntity<Book_entity> createnewbook(@RequestBody Book_entity book_entity) {
		return new ResponseEntity<Book_entity>(book_service.createbook(book_entity), HttpStatus.CREATED);

	}

	@GetMapping("/getallbooks")
	List<Book_entity> fetchalldata(Book_entity book_entity) {
		return book_service.fetchall(book_entity);

	}

	@GetMapping("/getbyid/{b_id}")
	Book_entity fetch_byid(@PathVariable("b_id") int id, Book_entity book_entity) {

		Book_entity bookEnt = book_service.fetchbyid(id, book_entity);
		return bookEnt;

	}

	@DeleteMapping("/deletebyid/{b_id}")
	String delete_byid(@PathVariable("b_id") int id) {
		return book_service.deletebyid(id);

	}

	@PutMapping("/updatebyid/{b_id}")
	Book_entity update_byid(@PathVariable("b_id") int id, @RequestBody Book_entity book_entity) {
		return book_service.updatebyid(id, book_entity);

	}
}
