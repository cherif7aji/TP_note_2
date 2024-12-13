package fr.univtours.polytech.tp2note.business;

import java.util.List;

import fr.univtours.polytech.tp2note.dao.InformationsDao;
import fr.univtours.polytech.tp2note.models.films.Description;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class InformationsBusinessImpl implements InformationsBusiness{

    @Inject
    private InformationsDao informationsDAO;

    @Override
    public List<Description> searchTitles(String search) {
        return this.informationsDAO.getInformations(search);
    }
    
}
