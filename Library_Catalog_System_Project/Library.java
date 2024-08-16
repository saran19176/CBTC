
import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books = new ArrayList<>();
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added Successfully");
	}
	
	public List<Book> searchByTitle(String title){
		List<Book> result = new ArrayList<>();
		for(Book book : books) {
			if(book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				result.add(book);
			}
		}
		return result;
	}
	
	public List<Book> searchByAuthor(String author){
		List<Book> result = new ArrayList<>();
		for(Book book : books) {
			if(book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				result.add(book);
			}
		}
		
		return result;
	}
	
	public List<Book> listAllBooks(){
		return books;
	}

}
