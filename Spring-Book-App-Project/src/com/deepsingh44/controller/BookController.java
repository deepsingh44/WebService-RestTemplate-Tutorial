package com.deepsingh44.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.deepsingh44.model.Book;
import com.deepsingh44.service.BookService;
import com.deepsingh44.service.RestTemplateService;

@Controller
public class BookController {

	// @Autowired
	// private BookService bookService;

	@Autowired
	private RestTemplateService restTemplateService;

	@PostMapping("/add")
	@ResponseBody
	public String addBook(Book book) {
		// return (bookService.addBook(book) > 0) ? "Successfully Book Added" : "Book
		// Added Failed";
		return restTemplateService.addBook(book);
	}

	@PostMapping("/deletebook")
	@ResponseBody
	public String deleteBook(int id) {
		return restTemplateService.deleteBook(id);
	}

	@PostMapping("/updatebook")
	@ResponseBody
	public void updateBook(Book book) {
		System.out.println("firsrt " + book.getId());
		// restTemplateService.updateBook(book);
	}

	@GetMapping("/books")
	public ModelAndView getAllBooks() {
		List<Book> books = restTemplateService.getAllBooks();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("books");
		mv.addObject("books", books);
		return mv;
	}

	@GetMapping("/page")
	public ModelAndView page(int pagenum) {
		System.out.println(pagenum);
		int perpage = 5;
		List<Book> books = restTemplateService.getAllBooksPerPage(((pagenum - 1 )* perpage), perpage);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("books");
		mv.addObject("books", books);
		return mv;
	}

	/*
	 * @GetMapping("/books") public ModelAndView getBooks() { ModelAndView mv = new
	 * ModelAndView(); List<Book> books = bookService.fetchAllBooks();
	 * mv.addObject("books", books); mv.setViewName("booklist"); return mv; }
	 * 
	 * @GetMapping("/detail") public ModelAndView detailPage(int id) { Book book =
	 * bookService.findBookById(id); ModelAndView mv = new ModelAndView();
	 * mv.addObject("book", book); mv.setViewName("detail"); return mv; }
	 */

}
