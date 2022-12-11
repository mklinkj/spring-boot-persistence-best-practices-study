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
public class Book implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter private String title;

  @Setter private String isbn;

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null) {
      return false;
    }

    if (getClass() != obj.getClass()) {
      return false;
    }

    return id != null && id.equals(((Book) obj).id);
  }

  /*
   저자님이 처음에 hashCode 잘못만든줄 알았는데... AutoIncrement 컬럼을 ID로 쓰는 엔티티의
   hash 코드는 그냥 상수값을 반환하라고 하시는데... Item 68에서 자세히 설명해주신다고 한다.
   ...
   기억해야 할 가장 중요한 측면은 자동 생성된 데이터베이스 식별자의 경우 equals() 메서드는
   동등성 검사를 수행하기 전에 식별자의 null 검사를 수행해야 하며
   hashCode() 메서드는 상수 값을 반환해야 한다는 것입니다.

   [책의 4쪽 참고할 것]
  */
  @Override
  public int hashCode() {
    return 2021;
  }

  @Override
  public String toString() {
    return "Book{" + "id=" + id + ", title=" + title + ", isbn=" + isbn + '}';
  }
}
