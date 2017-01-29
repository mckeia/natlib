package com.ianmck.natlib.controller;
import com.ianmck.natlib.model.Book;
import com.ianmck.natlib.dao.bookDAO;
import com.ianmck.natlib.dao.bookImplDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Controller
public class natlibController {
	   private JdbcTemplate jdbcTemplate;

	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }	

    @RequestMapping(value = "/ajaxtest",  method = RequestMethod.POST)
    @ResponseBody
	public String ajaxTest() {
    	System.out.println("In ajax test");
		return "Ajax test works";
	}
			
    @Autowired
   private bookImplDAO bk;
    
    @RequestMapping(value = "/getAllBooks",  method = RequestMethod.POST)
    @ResponseBody
    public List<Book> getAllBooks() {

		List<Book> books = new ArrayList<Book>();
		books = bk.getAll();
        //System.out.println(books); 
		return books;

	}    
    
    @RequestMapping(value = "/saveBook",  method = RequestMethod.POST)
    @ResponseBody
    public String saveBook(@RequestParam("author") String author,
    		@RequestParam("title") String title,
    		@RequestParam("isbn") String isbn) {

		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(title);
		book.setIsbn(isbn);
		bk.saveBook(book);
		return "done";

	}  
    
    @RequestMapping(value = "/deleteBook",  method = RequestMethod.POST)
    @ResponseBody
    public String deleteBook(@RequestParam("bookID") int bookID ) {
    	bk.deleteBook(bookID);
		return "done";
    }
}