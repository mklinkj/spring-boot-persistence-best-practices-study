package org.mklinkj.sbpbp.ch01.item001.service;

import org.mklinkj.sbpbp.ch01.item001.entity.Author;
import org.mklinkj.sbpbp.ch01.item001.entity.Book;
import org.mklinkj.sbpbp.ch01.item001.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

  private final AuthorRepository authorRepository;

  public BookstoreService(AuthorRepository authorRepository) {

    this.authorRepository = authorRepository;
  }

  public void insertAuthorWithBooks() {

    Author author = new Author();
    author.setName("Alicia Tom");
    author.setAge(38);
    author.setGenre("Anthology");

    Book book = new Book();
    book.setIsbn("001-AT");
    book.setTitle("The book of swords");

    author.addBook(book); // addBook() 도우미 메서드 사용

    authorRepository.save(author);
  }

  @Transactional
  public void deleteBookOfAuthor() {

    Author author = authorRepository.fetchByName("Alicia Tom");
    Book book = author.getBooks().get(0);

    author.removeBook(book); // removeBook() 도우미 메서드 사용
  }

  @Transactional
  public void deleteAllBooksOfAuthor() {
    Author author = authorRepository.fetchByName("Joana Nimar");
    author.removeBooks(); // removeBooks() 도우미 메서드 사용
  }
}
