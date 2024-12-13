package fr.univtours.polytech.tp2note.controllers;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tp2note.business.FilmBusiness;
import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("baisser")
public class BaisserServlet extends HttpServlet {
    @EJB
    FilmBusiness filmBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int id = Integer.parseInt(req.getParameter("id"));

        FilmBean filmBean = filmBusiness.getFilm(id);
        if ( filmBean.getNote() == null)
            filmBean.setNote(6);
        if (filmBean.getNote() > 1)
            filmBean.setNote(filmBean.getNote() - 1);
        filmBusiness.updateFilm(filmBean);

        List<FilmBean> filmBeans = filmBusiness.getFilms();
        System.out.println("les films");
        for (FilmBean film : filmBeans) {
            System.out.println(film.getTitle());
        }
        req.setAttribute("FILMS", filmBeans);
        req.getRequestDispatcher("films.jsp").forward(req, resp);
        ;

    }
}
