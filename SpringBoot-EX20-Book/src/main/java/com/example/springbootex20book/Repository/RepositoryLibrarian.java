package com.example.springbootex20book.Repository;

import com.example.springbootex20book.Model.Book;
import com.example.springbootex20book.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryLibrarian extends JpaRepository<Librarian,Integer> {
    Librarian findLibrarianById(Integer id);


    @Query("select l from Librarian l where l.id =?1")
    Librarian getlibrarianbyId(Integer id);

    Librarian getLibrarianByEmail(String email);

   Librarian findLibrarianByUsernameAndPassword(String username , String password);

}