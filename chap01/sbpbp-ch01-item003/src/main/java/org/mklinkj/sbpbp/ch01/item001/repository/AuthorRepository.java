package org.mklinkj.sbpbp.ch01.item001.repository;

import org.mklinkj.sbpbp.ch01.item001.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {}
