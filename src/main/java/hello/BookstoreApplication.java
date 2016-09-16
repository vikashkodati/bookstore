package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class BookstoreApplication {

  @RequestMapping(value = "/bookstore/recommended")
  public String readingList(){
    return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
  }
  
  @RequestMapping("/create")
  @ResponseBody
  public String create(String bookname, String author) {
    Book book = null;
    try {
      book = new Book(bookname, author);
      bookDao.save(book);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Book succesfully created! (id = " + book.getId() + ")";
  }
  
 
  
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Book book = new Book(id);
      bookDao.delete(book);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "Book succesfully deleted!";
  }
  
 
  @RequestMapping("/getByBookname")
  @ResponseBody
  public String getByBookName(String bookname) {
    try {
      Book book = bookDao.findByBookname(bookname);
      String json = new Gson().toJson(book);
	    return json;

      //bookId = String.valueOf(book.getId());
    }
    catch (Exception ex) {
      return "Book not found";
    }
  }
  
  
  @RequestMapping("/update")
  @ResponseBody
  public String updateBook(long id, String bookname, String author) {
    try {
      Book book = bookDao.findOne(id);
      book.setBookname(bookname);
      book.setAuthor(author);
      bookDao.save(book);
    }
    catch (Exception ex) {
      return "Error updating the book: " + ex.toString();
    }
    return "Book succesfully updated!";
  }
  
  @RequestMapping("/allBooks")
  @ResponseBody
  public String allBook() {
    try {
      List<Book> book =  (List<Book>) bookDao.findAll();
      String json = new Gson().toJson(book);

      return json;
    }
    catch (Exception ex) {
      return "Error updating the book: " + ex.toString();
    }
  }

  @Autowired
  private BookDao bookDao;
  
  
  public static void main(String[] args) {
    SpringApplication.run(BookstoreApplication.class, args);
  }
}
