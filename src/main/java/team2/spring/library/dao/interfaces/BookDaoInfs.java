package team2.spring.library.dao.interfaces;

import team2.spring.library.entities.Author;
import team2.spring.library.entities.Book;
import team2.spring.library.entities.Copy;
import team2.spring.library.entities.Reader;

import java.util.List;

public interface BookDaoInfs extends Dao<Book> {

  Book findByTitle(String title);

  List<Book> findBooksByAuthor(Author author);

  long isBookAvailable(String title);

  List<Copy> getCopiesInfo(String title);

  List<Reader> getReaderAvg(String title);
}
