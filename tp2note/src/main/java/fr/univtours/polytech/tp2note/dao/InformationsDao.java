package fr.univtours.polytech.tp2note.dao;

import java.util.List;

import fr.univtours.polytech.tp2note.models.films.Description;

public interface InformationsDao {

    public List<Description> getInformations(String search);
}
