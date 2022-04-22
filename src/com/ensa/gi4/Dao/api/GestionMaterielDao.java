package com.ensa.gi4.Dao.api;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielDao {
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void delete(int id);
    void update(int id);
    void serach(int id);
    void allocation(int id);
}
