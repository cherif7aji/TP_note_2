package fr.univtours.polytech.tp2note.dao;

import java.util.List;

import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FilmDaoImpl implements FilmDao{

    @PersistenceContext(unitName = "TpNote2")
    private EntityManager em;

    @Override
    public void createFilm(FilmBean bean) {
        em.persist(bean);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FilmBean> getFilms() {
        Query request = em.createQuery("select l from FilmBean l");
        return request.getResultList();
    }

    @Override
    public FilmBean getFilm(Integer id) {
        return em.find(FilmBean.class, id);
    }

    @Override
    public void updateFilm(FilmBean filmBean)  {
        em.merge(filmBean);
    }

    @Override
    public void deleteFilm(FilmBean filmBean) {
        em.remove(filmBean);
    }


}



