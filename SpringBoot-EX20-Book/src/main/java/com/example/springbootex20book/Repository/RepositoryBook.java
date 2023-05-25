package com.example.springbootex20book.Repository;

import com.example.springbootex20book.Model.Book;
import com.example.springbootex20book.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryBook extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);

    List<Book> findBookByCategory(String category);
    @Query("select p from Book p where p.numberOfPages > ?1")
    List<Book> getpage(int numberOfPages);

    @Query("select a from Book a where a.author = ?1")
    List<Book> getbookaut(String author);

    Book findBookByTitle(String titel);
}
