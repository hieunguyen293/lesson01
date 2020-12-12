package controller;

import java.sql.SQLException;
import java.util.List;

import dto.BookWithAuthorName;
import entity.Book;
import sever.BookService;

public class BookController {
	
	private static BookController instance;

	BookService bookService = new BookService();

	public static BookController getInstance() {
		if (instance == null) {
			instance = new BookController();
		}
		return instance;
	}

	private BookController() {
    }
	
	public List<BookWithAuthorName> getAllBookWithAuthorName() throws SQLException{
		return bookService.getAllBookWithAuthorName();
	}
	
	public boolean addBook(Book book) throws SQLException {
		return bookService.addBook(book);
	}
	
	public boolean updateBookByName(String nameOldBook, Book book) {
		return bookService.updateBookByName(nameOldBook, book); 
	}
	
	public boolean deleteBookByName(String bookName) {
		return bookService.deleteBookByName(bookName);
	}
	
}
