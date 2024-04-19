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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patron", schema = "books")
public class Patron {
    @Id
    @Column(name = "id", nullable = false)
    private java.lang.Integer id;

    @Column(name = "name", length = 45)
    private java.lang.String name;

    @Column(name = "contact", length = 45)
    private java.lang.String contact;

//    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<BrowingBook> browingBooks = new HashSet<>();

}