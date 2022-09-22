package com.example.JaniBookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.JaniBookstore.domain.Book;
import com.example.JaniBookstore.domain.BookRepository;

@Controller
public class BookstoreController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping("/add") 
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/edit/{book_id}")
	public String editBook(@PathVariable("book_id") Long book_id, Model model) {
		model.addAttribute("book", repository.findById(book_id));
		return "editbook";
	}
	
	@RequestMapping(value = "/delete/{book_id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("book_id") Long book_id, Model model) {
		repository.deleteById(book_id);
		return "redirect:../booklist";
	}

}