package fr.univtours.polytech.tp2note.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class FilmBean implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    private int note;
    private String title;

    public void setNote(int note){
        this.note=note;
    }
    
    public int getNote(){
        return this.note;
    }

    public void setTitle(String title){
        this.title=title;
    }
    
    public String getTitle(){
        return this.title;
    }
}
