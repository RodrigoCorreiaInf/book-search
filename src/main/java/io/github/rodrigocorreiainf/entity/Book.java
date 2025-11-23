package io.github.rodrigocorreiainf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "books")
@Getter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;

    private BigDecimal rating;

    private String description;

    private String language;

    private String isbn;

    private String bookFormat;

    private String edition;

    private Integer pages;

    private String publisher;

    private Date publishDate;

    private Date firstPublishDate;

    private BigDecimal likedPercent;

    private BigDecimal price;

    @Column(name = "search_vector", columnDefinition = "tsvector")
    @ToString.Exclude
    private String searchVector;

}
