package com.deepsingh44.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deepsingh44.model.Book;
import com.deepsingh44.utility.Constant;
import com.google.gson.Gson;

@Service
public class RestTemplateService {

	public String addBook(Book book) {
		// return (bookService.addBook(book) > 0) ? "Successfully Book Added" : "Book
		// Added Failed";
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(new Gson().toJson(book), headers);
		String s = rest.postForObject(Constant.ADD_BOOK, entity, String.class);
		System.out.println(s);
		return s;
	}

	public void updateBook(Book book) {
		// return (bookService.addBook(book) > 0) ? "Successfully Book Added" : "Book
		// Added Failed";
		System.out.println("second " + book.getId());
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		System.out.println(book.getId());
		HttpEntity<String> entity = new HttpEntity<String>(new Gson().toJson(book), headers);
		rest.put(Constant.UPDATE_BOOK, entity);
		/*ResponseEntity<String> response = rest.exchange(Constant.UPDATE_BOOK, HttpMethod.PUT, entity, String.class);
		System.out.println(response);
		return response.getBody();*/
	}

	public List<Book> getAllBooks() {
		RestTemplate rest = new RestTemplate();
		
		String books = rest.getForObject(Constant.FETCH_ALL_BOOKS, String.class);
		System.out.println(books);
		List<Book> bb = new ArrayList<>();
		try {
			JSONArray jo = new JSONArray(books);
			for (int i = 0; i < jo.length(); i++) {
				bb.add(new Gson().fromJson(jo.getJSONObject(i).toString(), Book.class));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(bb.size());
		return bb;
	}

	public String deleteBook(int id) {
		RestTemplate rest = new RestTemplate();
		//rest.delete(Constant.DELETE_BOOK + "/" + id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = rest.exchange(Constant.DELETE_BOOK+"/"+id, HttpMethod.DELETE,entity, String.class);
		System.out.println(response);
		return response.getBody();
	}

	public List<Book> getAllBooksPerPage(int start,int perpage) {
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> books=rest.exchange(Constant.FETCH_ALL_BOOKS_PAGE+"?start={start}&perpage={perpage}",
			    HttpMethod.GET,
			    entity,
			    String.class,
			    start,
			    perpage
			);
		
		System.out.println(books);
		List<Book> bb = new ArrayList<>();
		try {
			JSONArray jo = new JSONArray(books.getBody());
			for (int i = 0; i < jo.length(); i++) {
				bb.add(new Gson().fromJson(jo.getJSONObject(i).toString(), Book.class));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(bb.size());
		return bb;
	}
	
}
