package org.mklinkj.sbpbp.ch01.item001.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mklinkj.sbpbp.ch01.item001.entity.Author;
import org.mklinkj.sbpbp.ch01.item001.entity.Book;
import org.mklinkj.sbpbp.ch01.item001.repository.AuthorRepository;
import org.mklinkj.sbpbp.ch01.item001.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookstoreService {
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  @Transactional
  public void insertNewBook() {
    Author author = authorRepository.getReferenceById(4L);
    // getOne() 메서드는 Deprecated 되고, getReferenceById()를 사용
    // or, less efficient since a SELECT is triggered
    // Author author = authorRepository.findByName("Joana Nimar");

    Book book = new Book();
    book.setIsbn("003-JN");
    book.setTitle("History Of Present");
    book.setAuthor(author);

    bookRepository.save(book);

    // book.setIsbn("not available");
  }

  @Transactional
  public void insertNewBookUseFindById() {
    Optional<Author> optionalAuthor = authorRepository.findById(4L);

    Book book = new Book();
    book.setIsbn("003-JN");
    book.setTitle("History Of Present");
    book.setAuthor(optionalAuthor.orElseThrow(IllegalArgumentException::new));

    bookRepository.save(book);
  }

  public void fetchBooksOfAuthorById() {
    List<Book> books = bookRepository.fetchBooksOfAuthorById(4L);

    System.out.println(books);
  }

  public void fetchPageBooksOfAuthorById() {
    Page<Book> books =
        bookRepository.fetchPageBooksOfAuthorById(
            4L, PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "title")));

    // 정렬 순서 설정 부분은 Sort.by(Order.asc("title")) 이렇게 써도 된다.

    books.get().forEach(System.out::println);
  }

  @Transactional
  public void fetchBooksOfAuthorByIdAndAddNewBook() {
    List<Book> books = bookRepository.fetchBooksOfAuthorById(4L);

    Book book = new Book();
    book.setIsbn("004-JN");
    book.setTitle("History Facts");
    book.setAuthor(books.get(0).getAuthor());

    books.add(bookRepository.save(book));

    System.out.println(books);
  }

  @Transactional
  public void fetchBooksOfAuthorByIdAndDeleteFirstBook() {
    List<Book> books = bookRepository.fetchBooksOfAuthorById(4L);

    bookRepository.delete(books.remove(0));

    System.out.println(books);
  }
}
