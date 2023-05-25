package com.example.springbootex20book.Controller;

import com.example.springbootex20book.Model.Book;
import com.example.springbootex20book.Model.Librarian;
import com.example.springbootex20book.Service.ServiceLibrarian;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/librarian")
@RequiredArgsConstructor
public class ControllerLibrarian {

    private final ServiceLibrarian serviceLibrarian;

    @GetMapping("/get")

    public ResponseEntity getLibrarian(){
    List<Librarian>librarians=serviceLibrarian.getLibrarian();
        return ResponseEntity.status(200).body(librarians);
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian){
        serviceLibrarian.addLibrarian(librarian);
        return ResponseEntity.status(200).body("librarian added");

    }

    @PutMapping("update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id ,@Valid @RequestBody Librarian librarian){
        serviceLibrarian.updateLibrarian(id,librarian);
        return ResponseEntity.status(200).body("librarian updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
      serviceLibrarian.deleteLibrarian(id);
        return ResponseEntity.status(200).body("librarian deleted");
    }

    @GetMapping("/get-id/{id}")

    public ResponseEntity getbyid(@PathVariable Integer id){
        Librarian l=serviceLibrarian.getbyid(id);
        return ResponseEntity.status(200).body(l);
    }

    @GetMapping("/getema/{email}")

    public ResponseEntity getLibrarian(@PathVariable String email){
        Librarian n =serviceLibrarian.getemail(email);
        return ResponseEntity.status(200).body(n);
    }

    @GetMapping("/getb/{username}/{password}")
    public ResponseEntity getuserpassword(@PathVariable String username , @PathVariable String password){
        Librarian b  =serviceLibrarian.getlibuserandPass(username , password);
        return ResponseEntity.status(200).body(b);
    }
}
