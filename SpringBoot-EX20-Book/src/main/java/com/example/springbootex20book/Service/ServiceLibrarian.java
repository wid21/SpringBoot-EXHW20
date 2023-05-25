package com.example.springbootex20book.Service;

import com.example.springbootex20book.ApiException.ApiException;
import com.example.springbootex20book.Model.Book;
import com.example.springbootex20book.Model.Librarian;
import com.example.springbootex20book.Repository.RepositoryLibrarian;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLibrarian {

    private final RepositoryLibrarian repositoryLibrarian;
    public List<Librarian> getLibrarian(){
        List<Librarian>librarians=repositoryLibrarian.findAll();
        return librarians;
    }

    public void addLibrarian(Librarian librarian ){
        repositoryLibrarian.save(librarian);
    }

    public void updateLibrarian(Integer id , Librarian librarian){
        Librarian l = repositoryLibrarian.findLibrarianById(id);
        if(l==null){
            throw new ApiException("not found");
        }
        l.setName(librarian.getName());
        l.setUsername(librarian.getUsername());
        l.setEmail(librarian.getEmail());
        l.setPassword(librarian.getPassword());
       repositoryLibrarian.save(l);
    }

    public void deleteLibrarian(Integer id){
        Librarian l = repositoryLibrarian.findLibrarianById(id);
        if(l==null){
            throw new ApiException("not found");
        }
      repositoryLibrarian.delete(l);
    }

    public Librarian getbyid(Integer id){
        Librarian l = repositoryLibrarian.getlibrarianbyId(id);
        if(l==null){
            throw new ApiException("not found");
        }
        return l;
    }

   public Librarian getemail(String email){
       Librarian l = repositoryLibrarian.getLibrarianByEmail(email);
       if(l==null){
           throw new ApiException("not found");
       }
       return l;
   }

    public Librarian getlibuserandPass(String username , String password){
        Librarian b = repositoryLibrarian.findLibrarianByUsernameAndPassword(username,password);
        if(b==null){
            throw new ApiException("not found");
        }
        return b;
    }
   }


