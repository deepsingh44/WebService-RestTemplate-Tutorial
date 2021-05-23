package com.deepsingh44.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepsingh44.model.Book;

@Repository
public class BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	public int addBook(Book book) {
		int i = 0;
		sessionFactory.getCurrentSession().save(book);
		return i = 1;
	}

	public List<Book> fetchAllBooks() {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		Root<Book> root = criteria.from(Book.class);
		CriteriaQuery<Book> query = criteria.select(root);
		Query q = sessionFactory.getCurrentSession().createQuery(query);
		List<Book> books = q.getResultList();
		return books;
	}
	
	public Book findBookById(int id) {
		Book book=sessionFactory.getCurrentSession().get(Book.class, id);
		return book;
	}
}
