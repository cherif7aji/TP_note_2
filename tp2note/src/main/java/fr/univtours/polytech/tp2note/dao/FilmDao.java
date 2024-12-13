package fr.univtours.polytech.tp2note.dao;

import java.util.List;

import fr.univtours.polytech.tp2note.models.FilmBean;

public interface FilmDao {

    public void createFilm(FilmBean bean);

    public List<FilmBean> getFilms();

    public FilmBean getFilm(Integer id);

    public void updateFilm(FilmBean filmBean);

    public void deleteFilm(FilmBean filBean);
}
