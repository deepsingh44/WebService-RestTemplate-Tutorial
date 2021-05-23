package com.deepsingh44.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.web.bind.annotation.RestController;
import com.deepsingh44.model.Book;

@RestController
public class BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int addBook(Book book) {
		int i = 0;
		sessionFactory.getCurrentSession().save(book);
		return i = 1;
	}

	@Transactional
	public int delete(int id) {
		int i = 0;
		Book book = findBookById(id);
		if (book != null) {
			sessionFactory.getCurrentSession().delete(book);
			i = 1;
		}

		return i;
	}

	@Transactional
	public int update(Book book) {
		System.out.println(book.getId());
		Book book1 = findBookById(book.getId());
		int i = 0;
		book1 = book;
		sessionFactory.getCurrentSession().update(book1);
		return i = 1;
	}

	@Transactional
	public Book findBookById(int bookid) {
		return sessionFactory.getCurrentSession().get(Book.class, bookid);
	}

	@Transactional
	public List<Book> fetchAllBooks(/* String sortbycolumn */) {
		/*
		 * sortbycolumn=(sortbycolumn==null||sortbycolumn.isEmpty())?"name":
		 * sortbycolumn; System.out.println(sortbycolumn);
		 */
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.select(root);
		/* .orderBy(builder.asc(root.get(sortbycolumn))) */;
		return sessionFactory.getCurrentSession().createQuery(query).getResultList();
	}

	@Transactional
	public List<Book> fetchAllBooksPerPage(int start, int perpage) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Book.class);
		cr.setFirstResult(start);
		cr.setMaxResults(perpage);
		return cr.list();
	}

}
