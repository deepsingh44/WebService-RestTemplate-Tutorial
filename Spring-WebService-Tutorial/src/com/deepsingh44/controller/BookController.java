package com.deepsingh44.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deepsingh44.dao.BookDao;
import com.deepsingh44.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookDao bookDao;

	@PostMapping("/add")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		int i=bookDao.addBook(book);
		return (i>0)?new ResponseEntity<String>("Successfully Book Added", HttpStatus.OK):new ResponseEntity<String>("Book Added Failed", HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id) {
		int i=bookDao.delete(id);
		return (i>0)?new ResponseEntity<String>("Successfully Book Deleted", HttpStatus.OK):new ResponseEntity<String>("Book Deleted Failed", HttpStatus.FORBIDDEN);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		int i=bookDao.update(book);
		return (i>0)?new ResponseEntity<String>("Successfully Book Updated", HttpStatus.OK):new ResponseEntity<String>("Book Updated Failed", HttpStatus.FORBIDDEN);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Book> findBook(@PathVariable("id") int bid) {
		Book book=bookDao.findBookById(bid);
		return (book!=null)?new ResponseEntity<Book>(book, HttpStatus.OK):new ResponseEntity<Book>(new Book(), HttpStatus.FORBIDDEN);
	}

	@GetMapping("/page")
	public ResponseEntity<List<Book>> getAllBooksPerPage(@RequestParam int start,@RequestParam int perpage) {
		//System.out.println(sortbycolumn);
		System.out.println("Server "+ start+"\t"+perpage);
		List<Book>books=bookDao.fetchAllBooksPerPage(start,perpage);
		return (books!=null)?new ResponseEntity<List<Book>>(books, HttpStatus.OK):new ResponseEntity<List<Book>>(new ArrayList<Book>(), HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(/*@RequestParam("column") String sortbycolumn*/) {
		//System.out.println(sortbycolumn);
		List<Book>books=bookDao.fetchAllBooks(/*sortbycolumn*/);
		return (books!=null)?new ResponseEntity<List<Book>>(books, HttpStatus.OK):new ResponseEntity<List<Book>>(new ArrayList<Book>(), HttpStatus.FORBIDDEN);
	}
	
	@PostMapping("/bookimage")
	public ResponseEntity<String> bookImage(@RequestPart("bookimage") MultipartFile file, HttpServletRequest req) {
		boolean status = false;
		try {
			String root = req.getServletContext().getRealPath("/");
			File folder = new File(root, "books");
			if(!folder.exists())folder.mkdir();
			File location = File.createTempFile("book", ".jpg", folder);
			file.transferTo(location);
			System.out.println(location.getAbsolutePath()+"");
			status = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return (status) ? new ResponseEntity<String>("Successfully Upload", HttpStatus.OK)
				: new ResponseEntity<String>("Upload Failed", HttpStatus.NOT_ACCEPTABLE);
	}
}
