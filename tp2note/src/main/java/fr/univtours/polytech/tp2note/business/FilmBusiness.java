package fr.univtours.polytech.tp2note.business;

import java.util.List;

import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.ejb.Stateless;



public interface FilmBusiness {
public List<FilmBean> getFilms();

public void addFilm(FilmBean filmBean);

public FilmBean getFilm(Integer id);

public void updateFilm(FilmBean filmBean);

public void deleteFilm(Integer id);
}
    

