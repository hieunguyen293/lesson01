package sever;

import java.sql.SQLException;
import java.util.List;

import dto.BookWithAuthorName;
import entity.Book;
import helper.DatabaseUtil;
import repository.BookRepository;

public class BookService {
	DatabaseUtil db = new DatabaseUtil();
	BookRepository bookRepository = new BookRepository();

	public List<BookWithAuthorName> getAllBookWithAuthorName() throws SQLException {
		return bookRepository.getAllBookWithAuthorName();
	}

	public boolean addBook(Book book) throws SQLException {
		try {
			if (bookRepository.checkAuthorExistById(book.getAuthorId())) {
				if (bookRepository.checkBookExistByName(book.getBookName())) {
					return false;
				} else {
					return bookRepository.addBook(book);
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean updateBookByName(String nameOldBook, Book book) {
		try {
			if (bookRepository.checkAuthorExistById(book.getAuthorId())) {
				return bookRepository.updateBookByName(nameOldBook, book);
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean deleteBookByName(String bookName) {
		try {
			if (bookRepository.checkBookExistByName(bookName)) {
				return bookRepository.deleteBookByName(bookName);
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
