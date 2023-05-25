package com.example.springbootex20book.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "titel should not be empty")
    @Column(columnDefinition = "varchar(20) not null ")
   private String title;


    @NotEmpty(message = "Author should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @Pattern(regexp = "\\b(?:Academic|Mystery|Novel)\\b", message = "category must be Academic or Mystery or Novel")
    @Column(columnDefinition = "varchar(15) check( category='Academic' or category='Mystery' or category='Novel') ")
    private String category ;


    @NotNull(message = "ISBN should not be empty")
    @Column(columnDefinition = "int not null")
    private  int isbn;

    @NotNull(message = "number of Pages should not be empty")
    @Min(value = 50,message =" min 50 pages" )
    @Column(columnDefinition = "int not null")
    private int numberOfPages;
}
