package team2.spring.library.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.spring.library.dao.interfaces.BookDaoInfs;
import team2.spring.library.dto.BookDto;

@Service
public class BookServiceImpl implements BookService {
  @Autowired
  private BookDaoInfs bookDao;

  @Override
  public BookDto isBookAvailable(BookDto bookDto) {
    bookDto.setAvailable(bookDao.isBookAvailable(bookDto.getTitle()));
    return bookDto;
  }
}
