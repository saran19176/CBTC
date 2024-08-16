
import java.util.List;
import java.util.Scanner;

public class LibraryCatalogSystem {
	public static Library library = new Library();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean running = true;
		
		while(running) {
			System.out.println("\nLibrary Catalog System");
			System.out.println("1. Add Book");
			System.out.println("2. Search Book by Title");
			System.out.println("3. Search Book by Author");
			System.out.println("4. List All Book");
			System.out.println("5. Exit");
			System.out.println("Select an option: ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			  case 1:
				  addBook();
				  break;
			  case 2:
				  searchBookByTitle();
				  break;
			  case 3:
				  searchBookByAuthor();
				  break;
			  case 4:
				  listAllBooks();
				  break;
			  case 5:
				  running = false;
				  break;
			  default:
				  System.out.println("Invalid option. Please try again.");
			}	  
		}
		  sc.close();
		}

	   public static void addBook() {
		  System.out.println("Enter book title: ");
		  String title = sc.nextLine();
		  System.out.println("Enter book author: ");
		  String author = sc.nextLine();
		  
		  Book book = new Book(title, author);
		  library.addBook(book);
	   }
	   
	   public static void searchBookByTitle() {
		   System.out.println("Enter book title to search: ");
		   String title = sc.nextLine();
		   List<Book> results = library.searchByTitle(title);
		   if(results.isEmpty()) {
			   System.out.println("No Book found with the title: " +title);
		   }else {
			   results.forEach(System.out::println);
		   }
	   }
	   
	   public static void searchBookByAuthor() {
		   System.out.println("Enter author name to search: ");
		   String author = sc.nextLine();
		   List<Book> results = library.searchByAuthor(author);
		   if(results.isEmpty()) {
			   System.out.println("No Book found by the Author: " +author);
		   }else {
			   results.forEach(System.out::println);
		   }
	   }
	   
	   public static void listAllBooks() {
		   List<Book> books = library.listAllBooks();
		   if(books.isEmpty()) {
			   System.out.println("No books available in the library.");
		   } else {
			   books.forEach(System.out::println);
		   }
	   }

}
