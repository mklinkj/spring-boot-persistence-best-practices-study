package org.mklinkj.sbpbp.ch01.item001.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Author implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter private String name;

  @Setter private String genre;

  @Setter private int age;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
  private List<Book> books = new ArrayList<>();

  public void addBook(Book book) {
    this.books.add(book);
    book.setAuthor(this);
  }

  public void removeBook(Book book) {
    book.setAuthor(null);
    this.books.remove(book);
  }

  public void removeBooks() {
    Iterator<Book> iterator = this.books.iterator();

    while (iterator.hasNext()) {
      Book book = iterator.next();

      book.setAuthor(null);
      iterator.remove();
    }
  }

  @Override
  public String toString() {
    return "Author{" + "id=" + id + ", name=" + name + ", genre=" + genre + ", age=" + age + '}';
  }
}
