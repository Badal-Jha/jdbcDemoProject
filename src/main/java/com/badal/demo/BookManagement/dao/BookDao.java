package com.badal.demo.BookManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.badal.demo.BookManagement.entities.Book;

public class BookDao {

	String url = "jdbc:mysql://localhost:3306/books";
	String username = "root";
	String password = "root";

	// create jdbc connection
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		// Load the driver

		Class.forName("com.mysql.cj.jdbc.Driver");

		// get the connection

		Connection connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

	public void saveBook(Book book) throws SQLException, ClassNotFoundException {
		Connection connection = this.getConnection();

		// create the statement
		Statement st = connection.createStatement();

		// run the query
		String sql = "INSERT INTO mybooks (id,title, author) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2, book.getTitle());
		preparedStatement.setString(3, book.getAuthor());

		System.out.println(preparedStatement.executeUpdate());

	}

	public String getBook(int id) throws ClassNotFoundException, SQLException {
		Connection connection = this.getConnection();

		// create the statement
		Statement st = connection.createStatement();

		String query = "select title from mybooks where id=" + id;

		ResultSet rs = st.executeQuery(query);

		rs.next();

		return rs.getString(1);
	}

}
