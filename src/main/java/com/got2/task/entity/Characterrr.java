package com.got2.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.List;


@Table(name = "Characterrr")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Characterrr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String url;
    private String name;
    private String gender;
    private String culture;
    private String born;
    private String died;
    private List<String> titles;
    private List<String> aliases;
    private String father;
    private String mother;
    private String spouse;
    private List<String> allegiances;
    //    @ManyToMany
//    @JoinTable(name = "character_has_books",
//            joinColumns = @JoinColumn(name = "characterrr_id", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false))
    private List<String> books;
    private List<String> povBooks;
    private List<String> tvSeries;
    private List<String> playedBy;

    public Characterrr() {
    }

    public Characterrr(String url, String name, String gender, String culture, String born, String died, List<String> titles, List<String> aliases, String father, String mother, String spouse, List<String> allegiances, List<String> books, List<String> povBooks, List<String> tvSeries, List<String> playedBy) {
        this.url = url;
        this.name = name;
        this.gender = gender;
        this.culture = culture;
        this.born = born;
        this.died = died;
        this.titles = titles;
        this.aliases = aliases;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
        this.allegiances = allegiances;
        this.books = books;
        this.povBooks = povBooks;
        this.tvSeries = tvSeries;
        this.playedBy = playedBy;
    }

    public Characterrr(String alex) {
        this.name = alex;
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

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "culture")
    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    @Column(name = "born")
    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    @Column(name = "died")
    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    @Column(name = "titles")
    @ElementCollection(targetClass = String.class)
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Column(name = "aliases")
    @ElementCollection(targetClass = String.class)
    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    @Column(name = "father")
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Column(name = "mother")
    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Column(name = "spouse")
    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    @Column(name = "allegiances")
    @ElementCollection(targetClass = String.class)
    public List<String> getAllegiances() {
        return allegiances;
    }

    public void setAllegiances(List<String> allegiances) {
        this.allegiances = allegiances;
    }

    @Column(name = "books")
    @ElementCollection(targetClass = String.class)
    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Column(name = "pov_books")
    @ElementCollection(targetClass = String.class)
    public List<String> getPovBooks() {
        return povBooks;
    }

    public void setPovBooks(List<String> povBooks) {
        this.povBooks = povBooks;
    }

    @Column(name = "tv_series")
    @ElementCollection(targetClass = String.class)
    public List<String> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<String> tvSeries) {
        this.tvSeries = tvSeries;
    }

    @Column(name = "played_by")
    @ElementCollection(targetClass = String.class)
    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characterrr)) return false;

        Characterrr that = (Characterrr) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getUrl() != null ? !getUrl().equals(that.getUrl()) : that.getUrl() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getGender() != null ? !getGender().equals(that.getGender()) : that.getGender() != null) return false;
        if (getCulture() != null ? !getCulture().equals(that.getCulture()) : that.getCulture() != null) return false;
        if (getBorn() != null ? !getBorn().equals(that.getBorn()) : that.getBorn() != null) return false;
        if (getDied() != null ? !getDied().equals(that.getDied()) : that.getDied() != null) return false;
        if (getTitles() != null ? !getTitles().equals(that.getTitles()) : that.getTitles() != null) return false;
        if (getAliases() != null ? !getAliases().equals(that.getAliases()) : that.getAliases() != null) return false;
        if (getFather() != null ? !getFather().equals(that.getFather()) : that.getFather() != null) return false;
        if (getMother() != null ? !getMother().equals(that.getMother()) : that.getMother() != null) return false;
        if (getSpouse() != null ? !getSpouse().equals(that.getSpouse()) : that.getSpouse() != null) return false;
        if (getAllegiances() != null ? !getAllegiances().equals(that.getAllegiances()) : that.getAllegiances() != null)
            return false;
        if (getBooks() != null ? !getBooks().equals(that.getBooks()) : that.getBooks() != null) return false;
        if (getPovBooks() != null ? !getPovBooks().equals(that.getPovBooks()) : that.getPovBooks() != null)
            return false;
        if (getTvSeries() != null ? !getTvSeries().equals(that.getTvSeries()) : that.getTvSeries() != null)
            return false;
        return getPlayedBy() != null ? getPlayedBy().equals(that.getPlayedBy()) : that.getPlayedBy() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getCulture() != null ? getCulture().hashCode() : 0);
        result = 31 * result + (getBorn() != null ? getBorn().hashCode() : 0);
        result = 31 * result + (getDied() != null ? getDied().hashCode() : 0);
        result = 31 * result + (getTitles() != null ? getTitles().hashCode() : 0);
        result = 31 * result + (getAliases() != null ? getAliases().hashCode() : 0);
        result = 31 * result + (getFather() != null ? getFather().hashCode() : 0);
        result = 31 * result + (getMother() != null ? getMother().hashCode() : 0);
        result = 31 * result + (getSpouse() != null ? getSpouse().hashCode() : 0);
        result = 31 * result + (getAllegiances() != null ? getAllegiances().hashCode() : 0);
        result = 31 * result + (getBooks() != null ? getBooks().hashCode() : 0);
        result = 31 * result + (getPovBooks() != null ? getPovBooks().hashCode() : 0);
        result = 31 * result + (getTvSeries() != null ? getTvSeries().hashCode() : 0);
        result = 31 * result + (getPlayedBy() != null ? getPlayedBy().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Characterrr{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", culture='" + culture + '\'' +
                ", born='" + born + '\'' +
                ", died='" + died + '\'' +
                ", titles=" + titles +
                ", aliases=" + aliases +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", spouse='" + spouse + '\'' +
                ", allegiances=" + allegiances +
                ", books=" + books +
                ", povBooks=" + povBooks +
                ", tvSeries=" + tvSeries +
                ", playedBy=" + playedBy +
                '}';
    }
}
