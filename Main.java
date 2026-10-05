package library;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    BookCRUD.addBook();
                    break;

                case 2:
                    BookCRUD.viewBooks();
                    break;

                case 3:
                    BookCRUD.searchBook();
                    break;

                case 4:
                    BookCRUD.updateBook();
                    break;

                case 5:
                    BookCRUD.deleteBook();
                    break;

                case 6:
                    System.out.println("Thank you for using Library Management System!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}