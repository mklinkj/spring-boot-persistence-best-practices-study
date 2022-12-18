package org.mklinkj.sbpbp.ch01.item001.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
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

  @Override
  public String toString() {
    return "Author{" + "id=" + id + ", name=" + name + ", genre=" + genre + ", age=" + age + '}';
  }
}
