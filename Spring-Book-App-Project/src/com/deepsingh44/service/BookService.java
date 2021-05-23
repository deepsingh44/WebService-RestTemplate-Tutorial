package com.deepsingh44.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deepsingh44.dao.BookDao;
import com.deepsingh44.model.Book;

//@Service
public class BookService {
	@Autowired
	private BookDao bookDao;

	@Transactional
	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Transactional
	public List<Book> fetchAllBooks() {
		return bookDao.fetchAllBooks();
	}
	
	@Transactional
	public Book findBookById(int id) {
		return bookDao.findBookById(id);
	}
}
