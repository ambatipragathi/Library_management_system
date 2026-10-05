package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookCRUD {

    static Scanner sc = new Scanner(System.in);

    // ADD BOOK
    public static void addBook() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Category: ");
            String category = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            String sql = "INSERT INTO books "
                    + "(title, author, category, quantity, available_quantity) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, category);
            ps.setInt(4, quantity);
            ps.setInt(5, quantity);

            ps.executeUpdate();

            System.out.println("Book added successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL BOOKS
    public static void viewBooks() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM books";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== ALL BOOKS ==========");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("------------------------------");
                System.out.println("Book ID   : " + rs.getInt("book_id"));
                System.out.println("Title     : " + rs.getString("title"));
                System.out.println("Author    : " + rs.getString("author"));
                System.out.println("Category  : " + rs.getString("category"));
                System.out.println("Quantity  : " + rs.getInt("quantity"));
                System.out.println("Available : " + rs.getInt("available_quantity"));
            }

            if (!found) {
                System.out.println("No books available!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SEARCH BOOK
    public static void searchBook() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter book title to search: ");
            String title = sc.nextLine();

            String sql = "SELECT * FROM books WHERE title LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("------------------------------");
                System.out.println("Book ID   : " + rs.getInt("book_id"));
                System.out.println("Title     : " + rs.getString("title"));
                System.out.println("Author    : " + rs.getString("author"));
                System.out.println("Category  : " + rs.getString("category"));
                System.out.println("Quantity  : " + rs.getInt("quantity"));
                System.out.println("Available : " + rs.getInt("available_quantity"));
            }

            if (!found) {
                System.out.println("Book not found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE BOOK
    public static void updateBook() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new title: ");
            String title = sc.nextLine();

            System.out.print("Enter new author: ");
            String author = sc.nextLine();

            System.out.print("Enter new category: ");
            String category = sc.nextLine();

            String sql = "UPDATE books SET title=?, author=?, category=? "
                    + "WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, category);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book ID not found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE BOOK
    public static void deleteBook() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "DELETE FROM books WHERE book_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book ID not found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}