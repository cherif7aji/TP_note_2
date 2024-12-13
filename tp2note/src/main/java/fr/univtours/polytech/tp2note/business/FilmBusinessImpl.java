package fr.univtours.polytech.tp2note.business;

import java.util.List;

import fr.univtours.polytech.tp2note.dao.FilmDao;
import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class FilmBusinessImpl implements FilmBusiness{
    
    @Inject
    private FilmDao filmDao;

    @Override
    public void addFilm(FilmBean bean) {
        filmDao.createFilm(bean);
    }

    @Override
    public List<FilmBean> getFilms() {
        return filmDao.getFilms();
    }

    @Override
    public FilmBean getFilm(Integer id) {
        return filmDao.getFilm(id);
    }

    @Override
    public void updateFilm(FilmBean filmBean) {
        filmDao.updateFilm(filmBean);
    }

    @Override
    public void deleteFilm(Integer id) {
        FilmBean filmBean = getFilm(id);
        filmDao.deleteFilm(filmBean);
    }
}
