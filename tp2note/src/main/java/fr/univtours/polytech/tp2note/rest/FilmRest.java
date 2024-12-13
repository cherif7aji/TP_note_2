package fr.univtours.polytech.tp2note.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.univtours.polytech.tp2note.business.FilmBusiness;
import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("v1")
public class FilmRest {

    @EJB
    private FilmBusiness filmBusiness;

    @Path("films")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<FilmBean> getFilms() {
        List<FilmBean> films = this.filmBusiness.getFilms();
        return films;
    }

    @GET
    @Path("films/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public FilmBean getFilm(@PathParam("id") Integer idFilm) {
        FilmBean filmBean = this.filmBusiness.getFilm(idFilm);
        return filmBean;
    }

    @Path("films/filter")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<FilmBean> getFilms(@QueryParam("note") String filtreNote, @QueryParam("title") String filtreTitle) {
        List<FilmBean> films = this.filmBusiness.getFilms();
        System.err.println("title filter "+filtreTitle+" notefilter "+filtreNote+" nombre des films "+films.size());
        
        if (null != filtreTitle && !"".equals(filtreTitle)) {
            // Un filtre est indiqué. On l'applique sur le champ "title".
            films.removeIf(filmBean -> !filtreTitle.toLowerCase().equals(filmBean.getTitle().toLowerCase()));
        } else if (null != filtreNote && !"".equals(filtreNote)) {
            // Un filtre est indiqué. On l'applique sur le champ "note".
            films.removeIf(filmBean -> !filtreNote.toLowerCase().equals(filmBean.getNote().toString().toLowerCase()));
        }
    
        return films;

}
}


