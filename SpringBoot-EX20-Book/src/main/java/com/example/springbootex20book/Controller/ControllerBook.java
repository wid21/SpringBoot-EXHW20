package com.example.springbootex20book.Controller;


import com.example.springbootex20book.Model.Book;
import com.example.springbootex20book.Model.Librarian;
import com.example.springbootex20book.Service.ServiceBook;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class ControllerBook {
    private final ServiceBook serviceBook;

    @GetMapping("/get")

    public ResponseEntity getbook(){
        List<Book> bookList=serviceBook.getbooks();
        return ResponseEntity.status(200).body(bookList);
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        serviceBook.addBooks(book);
        return ResponseEntity.status(200).body("book added");

    }

    @PutMapping("update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id ,@Valid @RequestBody Book book){
        serviceBook.updateBook(id,book);
        return ResponseEntity.status(200).body("book updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        serviceBook.deleteBook(id);
        return ResponseEntity.status(200).body("book deleted");
    }

    @GetMapping("/getpage/{page}")

    public ResponseEntity getpage(@PathVariable int page){
        List<Book> bookList=serviceBook.getbypage(page);
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/getcat/{category}")
    public ResponseEntity getBookcat(@PathVariable String category){
        List<Book>bookList=serviceBook.getcategory(category);
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/getaut/{authore}")
    public ResponseEntity getBookaut(@PathVariable String authore){
        List<Book>bookList=serviceBook.getbyauthor(authore);
        return ResponseEntity.status(200).body(bookList);
    }

    @GetMapping("/gett/{titel}")
    public ResponseEntity getbytit(@PathVariable String titel){
        Book b= serviceBook.getBlogtit(titel);
        return ResponseEntity .status(200).body(b);
    }
}

