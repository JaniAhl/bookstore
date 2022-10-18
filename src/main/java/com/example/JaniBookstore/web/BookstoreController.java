package com.example.JaniBookstore.web;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.JaniBookstore.domain.Book;
import com.example.JaniBookstore.domain.BookRepository;
import com.example.JaniBookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value={"/", "/booklist"})
	public String bookList(Model model) {
		
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping("/add") 
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
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
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{book_id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("book_id") Long book_id, Model model) {
		repository.deleteById(book_id);
		return "redirect:../booklist";
	}
	
	// REST all books 
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	// REST book by ID 
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long book_id) {
		return repository.findById(book_id);
	}

}
