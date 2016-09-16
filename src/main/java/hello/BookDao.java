package hello;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author bookstore
 */
@Transactional
public interface BookDao extends CrudRepository<Book, Long> {

  /**
   * Return the user having the passed bookname or null if no user is found.
   * 
   * @param bookname the user bookname.
   */
  public Book findByBookname(String bookname);

} // class UserDao
