package entity;


public class Book {
    public int bookId;
    public String bookName;
    public int authorId;

    public Book() {
    }

	public Book(String name, int authorId) {
        this.bookName = name;
        this.authorId = authorId;
    }

    public Book(int id, String name, int authorId) {
        this.bookId = id;
        this.bookName = name;
        this.authorId = authorId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    public void setBookName(String name) {
        this.bookName = name;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

	@Override
	public String toString() {
		return "Book [id=" + bookId + ", name=" + bookName + ", authorId=" + authorId + "]";
	}
    
    
    
}