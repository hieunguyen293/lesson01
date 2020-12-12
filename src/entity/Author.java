package entity;

public class Author {
    public int authorId;
    public String authorName;

    public int getId() {
        return authorId;
    }

    public String getName() {
        return authorName;
    }

    public void setAuthorId(int id) {
        this.authorId = id;
    }

    public void setAuthorName(String name) {
        this.authorName = name;
    }

    public Author() {
    }

    public Author(int id, String name) {
        this.authorId = id;
        this.authorName = name;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + authorId + ", name=" + authorName + '}';
    }
    
    
}
