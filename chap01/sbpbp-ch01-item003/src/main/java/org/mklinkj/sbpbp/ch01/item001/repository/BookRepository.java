package org.mklinkj.sbpbp.ch01.item001.repository;

import java.util.List;
import org.mklinkj.sbpbp.ch01.item001.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true) // TODO: 사용자 정의 쿼리를 추가한 리포지토리에 대해서는 이걸 붙여두셨던데 이유가 무엇일까?
public interface BookRepository extends JpaRepository<Book, Long> {
  @Query("""
      SELECT b
        FROM Book b
       WHERE b.author.id = :id
      """)
  List<Book> fetchBooksOfAuthorById(Long id);

  @Query("""
      SELECT b
        FROM Book b
       WHERE b.author.id = :id
      """)
  Page<Book> fetchPageBooksOfAuthorById(Long id, Pageable pageable);
}
