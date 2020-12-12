package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookWithAuthorName;
import entity.Book;
import helper.DatabaseUtil;

public class BookRepository {
	DatabaseUtil db = new DatabaseUtil();

	public List<BookWithAuthorName> getAllBookWithAuthorName() throws SQLException {
		String sql = "SELECT book.bookId, book.bookName, author.authorId, author.authorName FROM book INNER JOIN author ON book.authorId=author.authorId;";
		List<BookWithAuthorName> listBookWithAuthorName = new ArrayList<BookWithAuthorName>();
		ResultSet rs = db.executeQuery(sql);
		while (rs.next()) {
			BookWithAuthorName bookWithAuthorName = new BookWithAuthorName();
			bookWithAuthorName.setBookId(rs.getInt("bookId"));
			bookWithAuthorName.setAuthorId(rs.getInt("authorId"));
			bookWithAuthorName.setBookName(rs.getString("bookName"));
			bookWithAuthorName.setAuthorName(rs.getString("authorName"));
			listBookWithAuthorName.add(bookWithAuthorName);
		}
		return listBookWithAuthorName;
	}

	public boolean checkAuthorExistById(int authorId) throws SQLException {
		String sql = "SELECT authorName FROM author WHERE EXISTS authorId = '" + authorId + "';";
		ResultSet rs = db.executeQuery(sql);
			if (rs.next()) {
				return true;
			}else {
				return false;
			}
	}

	public boolean checkBookExistByName(String bookName) throws SQLException {
		String sql = "SELECT bookName FROM book WHERE EXISTS bookName = '" + bookName + "'";
		ResultSet rs = db.executeQuery(sql);
			if (rs.next()) {
				return true;
			}else {
				return false;
			}
	}

	public boolean addBook(Book book) {
		String sql = "INSERT INTO book(bookName, authorId) VALUES ('" + book.getBookName() + "','" + book.getAuthorId()
				+ "';";
		try {
			return db.updateQuery(sql);
		} catch (Exception e) {
		}
		return false;
	}

	public boolean updateBookByName(String nameOldBook, Book book) {
		String sql = "UPDATE book SET bookName = '" + book.getBookName() + "', authorId = '" + book.getAuthorId()
				+ "' WHERE bookName = '" + nameOldBook + "';";
		try {
			return db.updateQuery(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean deleteBookByName(String bookName) {
		String sql = "DELETE FROM Book WHERE bookName = '" + bookName + "';";
		try {
			return db.updateQuery(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}
