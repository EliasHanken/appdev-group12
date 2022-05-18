package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Helmet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelmetService {

    /**
     * Creates two helmet objects for testing purposes.
     */
    private List<Helmet> helmets = new ArrayList<>(Arrays.asList(
            new Helmet("002001", "201", 200),
            new Helmet("002002", "202", 250)
    ));

    /**
     * @return all objects in helmets list.
     */
    public List<Helmet> getHelmets(){
        return helmets;
    }

    /**
     * Returns helmet with specific ID
     * @param id the ID of the helmet that should be returned.
     * @return The helmet with the corresponding ID.
     */
    public Helmet getHelmet(String id){
        return helmets.stream().filter(e -> e.getItemID().equals(id)).findFirst().orElse(null);
    }

    /**
     * Adds helmet to list of helmets.
     * @param helmet object to be added to helmets.
     */
    public void addHelmet(Helmet helmet){
        helmets.add(helmet);
    }

    /**
     * Updates helmets list.
     * @param id
     * @param helmet
     */
    public void updateHelmet(String id, Helmet helmet){
        for(int i = 0; i < helmets.size(); i++){
            Helmet h = helmets.get(i);
            if(h.getItemID().equals(id)){
                helmet.setItemID(h.getItemID());
                return;
            }
        }
    }

    /**
     * Deletes helmet with corresponding id from helmets.
     * @param id The ID of the helmet to be deleted.
     */
    public void deleteHelmet(String id){
        helmets.removeIf(h -> h.getItemID().equals(id));
    }

}
