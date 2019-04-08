package com.got2.task.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Table(name = "Book")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String url;
    private String name;
    private String isbn;
    private List<String> authors;
    private int numberOfPages;
    private String publisher;
    private String country;
    private String mediaType;
    private Date released;
    private List<String> characters;
    private List<String> povCharecters;
//    @ManyToMany(mappedBy = "books")
//    private List<Characterrr> characterrr;

    public Book() {
    }

    public Book(String url, String name, String isbn, List<String> authors, int numberOfPages, String publisher, String country, String mediaType, Date released, List<String> characters, List<String> povCharecters) {
        this.url = url;
        this.name = name;
        this.isbn = isbn;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.country = country;
        this.mediaType = mediaType;
        this.released = released;
        this.characters = characters;
        this.povCharecters = povCharecters;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "authors")
    @ElementCollection(targetClass = String.class)
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Column(name = "number_of_pages")
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "media_type")
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Column(name = "released")
    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    @Column(name = "characters")
    @ElementCollection(targetClass = String.class)
    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    @Column(name = "pov_characters")
    @ElementCollection(targetClass = String.class)
    public List<String> getPovCharecters() {
        return povCharecters;
    }

    public void setPovCharecters(List<String> povCharecters) {
        this.povCharecters = povCharecters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getNumberOfPages() != book.getNumberOfPages()) return false;
        if (getId() != null ? !getId().equals(book.getId()) : book.getId() != null) return false;
        if (getUrl() != null ? !getUrl().equals(book.getUrl()) : book.getUrl() != null) return false;
        if (getName() != null ? !getName().equals(book.getName()) : book.getName() != null) return false;
        if (getIsbn() != null ? !getIsbn().equals(book.getIsbn()) : book.getIsbn() != null) return false;
        if (getAuthors() != null ? !getAuthors().equals(book.getAuthors()) : book.getAuthors() != null) return false;
        if (getPublisher() != null ? !getPublisher().equals(book.getPublisher()) : book.getPublisher() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(book.getCountry()) : book.getCountry() != null) return false;
        if (getMediaType() != null ? !getMediaType().equals(book.getMediaType()) : book.getMediaType() != null)
            return false;
        if (getReleased() != null ? !getReleased().equals(book.getReleased()) : book.getReleased() != null)
            return false;
        if (getCharacters() != null ? !getCharacters().equals(book.getCharacters()) : book.getCharacters() != null)
            return false;
        return getPovCharecters() != null ? getPovCharecters().equals(book.getPovCharecters()) : book.getPovCharecters() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getIsbn() != null ? getIsbn().hashCode() : 0);
        result = 31 * result + (getAuthors() != null ? getAuthors().hashCode() : 0);
        result = 31 * result + getNumberOfPages();
        result = 31 * result + (getPublisher() != null ? getPublisher().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getMediaType() != null ? getMediaType().hashCode() : 0);
        result = 31 * result + (getReleased() != null ? getReleased().hashCode() : 0);
        result = 31 * result + (getCharacters() != null ? getCharacters().hashCode() : 0);
        result = 31 * result + (getPovCharecters() != null ? getPovCharecters().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + numberOfPages +
                ", publisher='" + publisher + '\'' +
                ", country='" + country + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", released=" + released +
                ", characters=" + characters +
                ", povCharecters=" + povCharecters +
                '}';
    }
}