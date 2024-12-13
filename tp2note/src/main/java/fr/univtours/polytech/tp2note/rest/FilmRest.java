package fr.univtours.polytech.tp2note.rest;

import java.util.List;

import fr.univtours.polytech.tp2note.business.FilmBusiness;
import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
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
    public FilmBean getLocation(@PathParam("id") Integer idFilm) {
        FilmBean filmBean = this.filmBusiness.getFilm(idFilm);
        return filmBean;
    }

   

    
}
