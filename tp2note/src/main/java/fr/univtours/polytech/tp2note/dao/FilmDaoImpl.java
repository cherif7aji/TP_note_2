package fr.univtours.polytech.tp2note.dao;

import java.util.List;

import fr.univtours.polytech.tp2note.business.InformationsBusiness;
import fr.univtours.polytech.tp2note.models.FilmBean;
import fr.univtours.polytech.tp2note.models.films.Description;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FilmDaoImpl implements FilmDao {

    @PersistenceContext(unitName = "TpNote2")
    private EntityManager em;
    @Inject
    InformationsBusiness informationsBusiness;

    @Override
    public void createFilm(FilmBean bean) {
        em.persist(bean);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FilmBean> getFilms() {
        Query request = em.createQuery("select l from FilmBean l");


          List<FilmBean> filmBeans = request.getResultList();
        System.out.println("les films");
        for (FilmBean filmBean : filmBeans) {
            System.out.println(filmBean.getTitle() + " " + filmBean.getId());
            List<Description> descriptions = informationsBusiness.searchTitles(filmBean.getTitle());
            if (null != descriptions && descriptions.size() != 0) {
                filmBean.setActors(descriptions.get(0).getActors());
                filmBean.setYear(descriptions.get(0).getYear());
                filmBean.setPicture(descriptions.get(0).getImgPoster());
            }
        }
        return filmBeans;
    }

    @Override
    public FilmBean getFilm(Integer id) {
        return em.find(FilmBean.class, id);
    }

    @Override
    public void updateFilm(FilmBean filmBean) {
        em.merge(filmBean);
    }

    @Override
    public void deleteFilm(FilmBean filmBean) {
        em.remove(filmBean);
    }

}
