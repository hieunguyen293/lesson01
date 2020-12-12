package dto;

	import entity.Book;

	public class BookWithAuthorName extends Book {
	    public String authorName;
 
	    public BookWithAuthorName() {
			
		}

		public BookWithAuthorName(int id, String name, int authorId, String authorName) {
	    	super(id, name, authorId);
	    	authorName = this.authorName;
	    }

	    public String getAuthorName() {
	        return authorName;
	    }

	    public void setAuthorName(String authorName) {
	        this.authorName = authorName;
	    }

	    @Override
	    public String toString() {
	        return "BookWithAuthorName{" +
	        		"authorId=" + authorId +
	                ", authorName='" + authorName + '\'' +
	                ", bookId=" + bookId +
	                ", bookName='" + bookName + '\'' +
	                
	                '}';
	    }
	}
	 

