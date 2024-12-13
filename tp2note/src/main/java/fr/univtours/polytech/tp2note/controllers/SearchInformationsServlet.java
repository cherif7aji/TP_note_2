package fr.univtours.polytech.tp2note.controllers;

import java.io.IOException;
import java.util.ArrayList;

import fr.univtours.polytech.tp2note.business.InformationsBusiness;
import fr.univtours.polytech.tp2note.models.films.Description;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("searchAddress")
public class SearchInformationsServlet extends HttpServlet {

    @Inject
    private InformationsBusiness informationsBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // On place une liste vide dans la requête.
        request.setAttribute("ADDRESSES", new ArrayList<Description>());
        // On redirige vers la JSP.
        request.getRequestDispatcher("filmsinformtions.jsp").forward(request, response);
    }
}
