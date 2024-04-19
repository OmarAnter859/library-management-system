package com.project.maids.cc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book", schema = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private java.lang.Integer id;

    @Column(name = "title", length = 45)
    private java.lang.String title;

    @Column(name = "author", length = 45)
    private java.lang.String author;

    @Column(name = "` publication year`", length = 45)
    private java.lang.String publicationYear;

    @Column(name = "` ISBN`", length = 45)
    private java.lang.String isbn;

//    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<BrowingBook> borrowingRecords = new HashSet<>();

}