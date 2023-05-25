package com.example.springbootex20book.Service;

import com.example.springbootex20book.ApiException.ApiException;
import com.example.springbootex20book.Model.Book;
import com.example.springbootex20book.Model.Librarian;
import com.example.springbootex20book.Repository.RepositoryBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceBook {

    private final RepositoryBook repositoryBook ;

    public List<Book> getbooks(){
        List<Book>bookList=repositoryBook.findAll();
        return bookList;
    }

    public void addBooks(Book book){
        repositoryBook.save(book);
    }

    public void updateBook(Integer id , Book book){
        Book b = repositoryBook.findBookById(id);
        if(b==null){
            throw new ApiException("not found");
        }
        b.setTitle(book.getTitle());
        b.setCategory(book.getCategory());
        b.setAuthor(book.getAuthor());
        b.setIsbn(book.getIsbn());
        b.setNumberOfPages(book.getNumberOfPages());
       repositoryBook.save(b);
    }

    public void deleteBook(Integer id){
        Book b = repositoryBook.findBookById(id);
        if(b==null){
            throw new ApiException("not found");
        }
        repositoryBook.delete(b);
    }

    public List<Book> getbypage(int numberOfPages){
        List<Book> bookList=repositoryBook.getpage(numberOfPages);
        return bookList;
    }
    public List<Book> getcategory(String category){
        List<Book>bookList=repositoryBook.findBookByCategory(category);
        return bookList;
    }

    public List<Book> getbyauthor(String author){
        List<Book> bookList=repositoryBook.getbookaut(author);
        return bookList;
    }

    public Book getBlogtit(String title){
        Book b= repositoryBook.findBookByTitle(title);
        if(b==null){
            throw new ApiException("not found");
        }
        return b;
    }
}
