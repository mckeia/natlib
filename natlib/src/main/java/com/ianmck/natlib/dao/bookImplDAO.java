package com.ianmck.natlib.dao;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ianmck.natlib.model.Book;
import com.ianmck.natlib.dao.bookDAO;

//@Repository
public class bookImplDAO implements bookDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void saveBook(Book book) {
		String sql = "INSERT INTO books (AUTHOR, TITLE,ISBN) VALUES ( ?,?,? )";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] {
		book.getAuthor(), book.getTitle() , book.getIsbn() });

	}
	
	
	public List<Book> getAll() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM books";
		List<Book> books = new ArrayList<Book>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Book book = new Book();
			book.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			book.setAuthor((String)row.get("AUTHOR"));
			book.setTitle((String)row.get("TITLE"));
			book.setIsbn((String)row.get("ISBN"));
			books.add(book);
		}
		return books;
	}

	public void deleteBook(int bookID) {
		String sql = "delete from books where id = ? ";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] {	bookID });

	}
	
}


