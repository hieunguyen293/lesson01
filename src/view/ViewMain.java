package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.BookController;
import dto.BookWithAuthorName;
import entity.Book;

public class ViewMain {
	Scanner sc = new Scanner(System.in);
	BookController bookController = BookController.getInstance();
	
	public void execute() throws SQLException {
		while (true) {
	        System.out.println("1. Show all books");
	        System.out.println("2. Add book");
	        System.out.println("3. Update book");
	        System.out.println("4. Delete book");
	        System.out.println("0. Exit");
	        int input = sc.nextInt();
	        
	        switch(input){
	            case 1:
	                List<BookWithAuthorName> listBook = bookController.getAllBookWithAuthorName();
	                    for (int i = 0; i < listBook.size(); i++) {
	                        System.out.println(listBook.get(i).toString());
	                    }
	                    break;
	            case 2:
	            	System.out.print("Book name: ");
	            	String newBookName = sc.next();
	            	System.out.print("Author ID: ");
	            	int newAuthorId = sc.nextInt();
	            	sc.nextLine();
	            	Book newBook = new Book(newBookName, newAuthorId);
	            	if (bookController.addBook(newBook)) {
						System.out.println("Add success!");
					} else {
						System.out.println("Add fail!");
					}
	                break;
	            case 3:
	            	System.out.print("Book name: ");
	            	String newBookNameUpdate = sc.next();
	            	System.out.print("Author ID: ");
	            	int newAuthorIdUpdate = sc.nextInt();
	            	System.out.println("Book's name want to change: ");
	            	String nameOldBook = sc.next();
	            	sc.nextLine();
	            	Book newBookUpdate = new Book(newBookNameUpdate, newAuthorIdUpdate);
	            	if (bookController.updateBookByName(nameOldBook, newBookUpdate)) {
	            		System.out.println("Update success!");
					} else {
						System.out.println("Update fail!");
					}
	                break;
	            case 4:
	            	System.out.println("Book's name want to delete");
	            	String nameBookDelete = sc.next();
	            	sc.nextLine();
	            	if (bookController.deleteBookByName(nameBookDelete)) {
	            		System.out.println("Delete success!");
					} else {
						System.out.println("Delete fail!");
					}
	            	
	                break;
	            default:
	                return;
	        }
		}
	}
}
