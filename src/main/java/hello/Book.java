package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */
@Entity
@Table(name = "bookstore")
public class Book {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An autogenerated id (unique for each user in the db)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  // The user's email
  @NotNull
  private String bookname;
  
  // The user's name
  @NotNull
  private String author;
  public Book(long id) { 
	    this.id = id;
	  }

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getBookname() {
	return bookname;
}

public void setBookname(String bookname) {
	this.bookname = bookname;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

@Override
public String toString() {
	return "Book [id=" + id + ", bookname=" + bookname + ", author=" + author + "]";
}

public Book(long id, String bookname, String author) {
	super();
	this.id = id;
	this.bookname = bookname;
	this.author = author;
}

public Book(String bookname, String author) {
	super();
	this.bookname = bookname;
	this.author = author;
}

public Book(){
	
}



 
  
} // class User