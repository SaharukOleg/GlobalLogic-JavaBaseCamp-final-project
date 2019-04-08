package com.got2.task.entity;

import javax.persistence.*;
import java.util.List;


@Table(name = "House")
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String url;
    private String name;
    private String region;
    private String coatOfArms;
    private String words;
    private List<String> titles;
    private List<String> seats;
    private String currentLord;
    private String heir;
    private String overlord;
    private String founded;
    private String diedOut;
    private List<String> ancestralWeapons;
    private List<String> cadetBranches;
    private List<String> swornMembers;


    public House() {
    }

    public House(String url, String name, String region, String coatOfArms, String words, List<String> titles, List<String> seats, String currentLord, String heir, String overlord, String founded, String diedOut, List<String> ancestralWeapons, List<String> cadetBranches, List<String> swornMembers) {
        this.url = url;
        this.name = name;
        this.region = region;
        this.coatOfArms = coatOfArms;
        this.words = words;
        this.titles = titles;
        this.seats = seats;
        this.currentLord = currentLord;
        this.heir = heir;
        this.overlord = overlord;
        this.founded = founded;
        this.diedOut = diedOut;
        this.ancestralWeapons = ancestralWeapons;
        this.cadetBranches = cadetBranches;
        this.swornMembers = swornMembers;
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

    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Column(name = "coat_of_arms")
    public String getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    @Column(name = "words")
    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Column(name = "titles")
    @ElementCollection(targetClass = String.class)
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Column(name = "seats")
    @ElementCollection(targetClass = String.class)
    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    @Column(name = "current_lord")
    public String getCurrentLord() {
        return currentLord;
    }

    public void setCurrentLord(String currentLord) {
        this.currentLord = currentLord;
    }

    @Column(name = "heir")
    public String getHeir() {
        return heir;
    }

    public void setHeir(String heir) {
        this.heir = heir;
    }

    @Column(name = "overlord")
    public String getOverlord() {
        return overlord;
    }

    public void setOverlord(String overlord) {
        this.overlord = overlord;
    }

    @Column(name = "founded")
    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    @Column(name = "died_out")
    public String getDiedOut() {
        return diedOut;
    }

    public void setDiedOut(String diedOut) {
        this.diedOut = diedOut;
    }

    @Column(name = "ancestral_weapons")
    @ElementCollection(targetClass = String.class)
    public List<String> getAncestralWeapons() {
        return ancestralWeapons;
    }

    public void setAncestralWeapons(List<String> ancestralWeapons) {
        this.ancestralWeapons = ancestralWeapons;
    }

    @Column(name = "cadet_branches")
    @ElementCollection(targetClass = String.class)
    public List<String> getCadetBranches() {
        return cadetBranches;
    }

    public void setCadetBranches(List<String> cadetBranches) {
        this.cadetBranches = cadetBranches;
    }

    @Column(name = "sworn_members")
    @ElementCollection(targetClass = String.class)
    public List<String> getSwornMembers() {
        return swornMembers;
    }

    public void setSwornMembers(List<String> swornMembers) {
        this.swornMembers = swornMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;

        House house = (House) o;

        if (getId() != null ? !getId().equals(house.getId()) : house.getId() != null) return false;
        if (getUrl() != null ? !getUrl().equals(house.getUrl()) : house.getUrl() != null) return false;
        if (getName() != null ? !getName().equals(house.getName()) : house.getName() != null) return false;
        if (getRegion() != null ? !getRegion().equals(house.getRegion()) : house.getRegion() != null) return false;
        if (getCoatOfArms() != null ? !getCoatOfArms().equals(house.getCoatOfArms()) : house.getCoatOfArms() != null)
            return false;
        if (getWords() != null ? !getWords().equals(house.getWords()) : house.getWords() != null) return false;
        if (getTitles() != null ? !getTitles().equals(house.getTitles()) : house.getTitles() != null) return false;
        if (getSeats() != null ? !getSeats().equals(house.getSeats()) : house.getSeats() != null) return false;
        if (getCurrentLord() != null ? !getCurrentLord().equals(house.getCurrentLord()) : house.getCurrentLord() != null)
            return false;
        if (getHeir() != null ? !getHeir().equals(house.getHeir()) : house.getHeir() != null) return false;
        if (getOverlord() != null ? !getOverlord().equals(house.getOverlord()) : house.getOverlord() != null)
            return false;
        if (getFounded() != null ? !getFounded().equals(house.getFounded()) : house.getFounded() != null) return false;
        if (getDiedOut() != null ? !getDiedOut().equals(house.getDiedOut()) : house.getDiedOut() != null) return false;
        if (getAncestralWeapons() != null ? !getAncestralWeapons().equals(house.getAncestralWeapons()) : house.getAncestralWeapons() != null)
            return false;
        if (getCadetBranches() != null ? !getCadetBranches().equals(house.getCadetBranches()) : house.getCadetBranches() != null)
            return false;
        return getSwornMembers() != null ? getSwornMembers().equals(house.getSwornMembers()) : house.getSwornMembers() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getRegion() != null ? getRegion().hashCode() : 0);
        result = 31 * result + (getCoatOfArms() != null ? getCoatOfArms().hashCode() : 0);
        result = 31 * result + (getWords() != null ? getWords().hashCode() : 0);
        result = 31 * result + (getTitles() != null ? getTitles().hashCode() : 0);
        result = 31 * result + (getSeats() != null ? getSeats().hashCode() : 0);
        result = 31 * result + (getCurrentLord() != null ? getCurrentLord().hashCode() : 0);
        result = 31 * result + (getHeir() != null ? getHeir().hashCode() : 0);
        result = 31 * result + (getOverlord() != null ? getOverlord().hashCode() : 0);
        result = 31 * result + (getFounded() != null ? getFounded().hashCode() : 0);
        result = 31 * result + (getDiedOut() != null ? getDiedOut().hashCode() : 0);
        result = 31 * result + (getAncestralWeapons() != null ? getAncestralWeapons().hashCode() : 0);
        result = 31 * result + (getCadetBranches() != null ? getCadetBranches().hashCode() : 0);
        result = 31 * result + (getSwornMembers() != null ? getSwornMembers().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", coatOfArms='" + coatOfArms + '\'' +
                ", words='" + words + '\'' +
                ", titles=" + titles +
                ", seats=" + seats +
                ", currentLord='" + currentLord + '\'' +
                ", heir='" + heir + '\'' +
                ", overlord='" + overlord + '\'' +
                ", founded='" + founded + '\'' +
                ", diedOut='" + diedOut + '\'' +
                ", ancestralWeapons=" + ancestralWeapons +
                ", cadetBranches=" + cadetBranches +
                ", swornMembers=" + swornMembers +
                '}';
    }
}
