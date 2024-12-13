package fr.univtours.polytech.tp2note.controllers;

import java.util.List;

import fr.univtours.polytech.tp2note.business.FilmBusiness;
import fr.univtours.polytech.tp2note.models.FilmBean;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("films")
public class FilmServlet extends HttpServlet{
    @EJB
    FilmBusiness filmBusiness ;
    protected void doGet(HttpServletRequest request , HttpServletResponse response)
        {
            List<FilmBean> filmBeans = filmBusiness.getFilms();
            request.setAttribute("FILMS", filmBeans);
            request.getRequestDispatcher("films.jsp");
    
        }
}
