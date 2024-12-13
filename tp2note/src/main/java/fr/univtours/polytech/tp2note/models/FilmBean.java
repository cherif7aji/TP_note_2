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

    
    private Integer note= null;
    private String title;

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

    public void setNote(int note){
        this.note=note;
    }
    
    public Integer getNote(){
        return this.note;
    }

    public void setTitle(String title){
        this.title=title;
    }
    
    public String getTitle(){
        return this.title;
    }
}