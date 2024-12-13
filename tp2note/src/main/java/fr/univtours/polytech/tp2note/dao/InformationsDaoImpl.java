package fr.univtours.polytech.tp2note.dao;

import java.util.List;

import fr.univtours.polytech.tp2note.models.films.Description;
import fr.univtours.polytech.tp2note.models.films.WsFilmsResult;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;


@Stateless
public class InformationsDaoImpl implements InformationsDao{

    private static String URL = "https://imdb.iamidiotareyoutoo.com/";

    @Override
    public List<Description> getInformations(String search) {
     Client client = ClientBuilder.newClient();

        // On indique l'URL du Web Service.
        WebTarget target = client.target(URL);

        // On indique le "end point" (on aurait aussi pu directement le mettre dans
        // l'URL).
        // C'est également avec cette méthode qu'on pourrait ajouter des "path
        // parameters" si besoin.
        target = target.path("search");
        // On précise (lorsqu'il y en a) les "query parameters".
        target = target.queryParam("q", search);
        target = target.queryParam("limit", 15);

        // On appelle le WS en précisant le type de l'objet renvoyé, ici un
        // WsAddressResult.
        System.out.println(target.getUri());
        WsFilmsResult wsResult = target.request(MediaType.APPLICATION_JSON).get(WsFilmsResult.class);
        return wsResult.getDescription();
    }
    
}
