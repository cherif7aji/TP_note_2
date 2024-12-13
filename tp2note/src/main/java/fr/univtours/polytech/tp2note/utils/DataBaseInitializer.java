package fr.univtours.polytech.tp2note.utils;

import java.io.IOException;
import java.io.InputStream;

import fr.univtours.polytech.tp2note.business.FilmBusiness;
import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DataBaseInitializer {

    @Inject
    private FilmBusiness filmBusiness;

    @PostConstruct
    public void init() {
        FilmBean bean3 = insertBeanInDB("The Godfather");
        filmBusiness.addFilm(bean3);
        FilmBean bean2 = insertBeanInDB("The Godfather2", 2);
        filmBusiness.addFilm(bean2);

        FilmBean bean1 = insertBeanInDB("The Godfather1", 1);
        filmBusiness.addFilm(bean1);

    }

    /**
     * Permet d'insérer un enregistrement en BDD.
     * 
     * @param note
     * @param title
     */
    private FilmBean insertBeanInDB(String title, int note) {
        FilmBean bean = new FilmBean();

        bean.setNote(note);
        bean.setTitle(title);

        return bean;
    }
    private FilmBean insertBeanInDB(String title) {
        FilmBean bean = new FilmBean();

        
        bean.setTitle(title);

        return bean;
    }
}
