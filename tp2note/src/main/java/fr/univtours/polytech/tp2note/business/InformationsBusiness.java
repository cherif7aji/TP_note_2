package fr.univtours.polytech.tp2note.business;

import java.util.List;

import fr.univtours.polytech.tp2note.models.films.Description;

public interface InformationsBusiness {
     public List<Description> searchTitles(String search);
}
