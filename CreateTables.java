package library;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();

            // 1. Books table
            String booksTable = "CREATE TABLE IF NOT EXISTS books ("
                    + "book_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "title VARCHAR(100) NOT NULL, "
                    + "author VARCHAR(100) NOT NULL, "
                    + "category VARCHAR(50), "
                    + "quantity INT NOT NULL, "
                    + "available_quantity INT NOT NULL"
                    + ")";

            stmt.executeUpdate(booksTable);
            System.out.println("Books table created!");

            // 2. Members table
            String membersTable = "CREATE TABLE IF NOT EXISTS members ("
                    + "member_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "email VARCHAR(100), "
                    + "phone VARCHAR(15)"
                    + ")";

            stmt.executeUpdate(membersTable);
            System.out.println("Members table created!");

            // 3. Book Issues table
            String issuesTable = "CREATE TABLE IF NOT EXISTS book_issues ("
                    + "issue_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "book_id INT NOT NULL, "
                    + "member_id INT NOT NULL, "
                    + "issue_date DATE NOT NULL, "
                    + "return_date DATE, "
                    + "status VARCHAR(20) DEFAULT 'ISSUED', "
                    + "FOREIGN KEY (book_id) REFERENCES books(book_id), "
                    + "FOREIGN KEY (member_id) REFERENCES members(member_id)"
                    + ")";

            stmt.executeUpdate(issuesTable);
            System.out.println("Book Issues table created!");

            con.close();

            System.out.println("All tables created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}