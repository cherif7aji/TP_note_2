package fr.univtours.polytech.tp2note.models;

import java.io.Serializable;
import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class FilmBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer note = null;
    private String title;
    private String actors;
    private Integer year;
    @Lob
    @Column(columnDefinition = "BLOB")
    private String picture;

    // Getter et Setter pour id
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    // Getter et Setter pour note
    public void setNote(Integer note) {
        this.note = note;
    }

    public Integer getNote() {
        return this.note;
    }

    // Getter et Setter pour title
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    // Getter et Setter pour actors
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    // Getter et Setter pour year
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    // Getter et Setter pour picture
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
