package com.ianmck.natlib.dao;
 
import com.ianmck.natlib.model.Book;
import java.util.List;

public interface bookDAO {
	public void saveBook(Book book);
	public List<Book> getAll();
	public void deleteBook(int bookID);
}


