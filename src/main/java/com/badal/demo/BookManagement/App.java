package com.badal.demo.BookManagement;

import java.sql.SQLException;

import com.badal.demo.BookManagement.dao.BookDao;
import com.badal.demo.BookManagement.entities.Book;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Book book1 = new Book(1, "The Great Gatsby", "F. Scott");
		System.out.print(book1);
		BookDao dao = new BookDao();

		// dao.saveBook(book1);

		System.out.println("the title of book with id=1 is " + dao.getBook(1));

	}
}
