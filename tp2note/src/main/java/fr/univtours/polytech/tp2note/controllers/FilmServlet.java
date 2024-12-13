package fr.univtours.polytech.tp2note.controllers;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tp2note.business.FilmBusiness;
import fr.univtours.polytech.tp2note.business.InformationsBusiness;
import fr.univtours.polytech.tp2note.models.FilmBean;
import fr.univtours.polytech.tp2note.models.films.Description;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("films")
public class FilmServlet extends HttpServlet {
    @EJB
    FilmBusiness filmBusiness;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<FilmBean> filmBeans = filmBusiness.getFilms();
        System.out.println("les films");
        for (FilmBean filmBean : filmBeans) {
            System.out.println(filmBean.getTitle() + " " + filmBean.getId());
    
        }

        request.setAttribute("FILMS", filmBeans);
        request.getRequestDispatcher("films.jsp").forward(request, response);
        ;

    }
}
