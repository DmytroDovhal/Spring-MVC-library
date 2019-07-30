package team2.spring.library.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import team2.spring.library.dao.interfaces.AuthorDaoInfs;
import team2.spring.library.entities.Author;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AuthorDao implements AuthorDaoInfs {

  private static final String TAG = AuthorDao.class.getName();
  private SessionFactory sessionFactory;

  @Autowired
  public AuthorDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public int insert(Author author) {
    int id = -1;
    try (Session session = sessionFactory.getCurrentSession()) {
      id = (int) session.save(author);
    }
    return id;
  }

  @Override
  public Author findById(int id) {
    Author author = null;
    try (Session session = sessionFactory.getCurrentSession()) {
      author = session.find(Author.class, id);
    }
    return author;
  }

  @Override
  public List<Author> findAll() throws NoResultException {
    List<Author> authors = null;
    try (Session session = sessionFactory.getCurrentSession()) {
      authors = session.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }
    return authors;
  }

  @Override
  public Author update(Author author) {
    Author updated = null;
    try (Session session = sessionFactory.getCurrentSession()) {
      session.update(author);
      updated = session.find(Author.class, author.getId());
    }
    return updated;
  }

  @Override
  public boolean delete(int id) {
    boolean isDeleted = false;
    try (Session session = sessionFactory.getCurrentSession()) {
      Author author = session.find(Author.class, id);
      session.delete(author);
      if (null == session.find(Author.class, id)) {
        isDeleted = true;
      }
    }
    return isDeleted;
  }

  @Override
  public List<Author> findByName(String name) throws NoResultException {
    List<Author> authors = null;
    try (Session session = sessionFactory.getCurrentSession()) {
      authors = session.createQuery("SELECT a FROM author a WHERE a.name = ?1")
              .setParameter(1, name)
              .getResultList();
      return authors;
    }
  }
}
