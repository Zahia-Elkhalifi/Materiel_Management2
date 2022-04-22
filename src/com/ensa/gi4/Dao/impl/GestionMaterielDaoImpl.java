package com.ensa.gi4.Dao.impl;

import com.ensa.gi4.Dao.api.GestionMaterielDao;
import com.ensa.gi4.datatabase.Db;
import com.ensa.gi4.modele.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Repository
public class GestionMaterielDaoImpl implements GestionMaterielDao {

    @Autowired
    private Db db;

    @Override
    public void listerMateriel() {
        int livre = 0;
        int chaise = 0;
        for (Materiel materiel : db.materiels) {
            if (materiel.getClass().getName().equals("com.ensa.gi4.modele.Livre")) {
                livre++;
                System.out.println("Livre (" + materiel.getId() + "," + materiel.getName() + ")");
            }
            if (materiel.getClass().getName().equals("com.ensa.gi4.modele.Chaise")) {
                chaise++;
                System.out.println("Chaise (" + materiel.getId() + "," + materiel.getName() + ")");
            }
        }
        System.out.println("list of materiels : \n" + livre + " Livres \n" + chaise + " Chaises");
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        db.materiels.add(materiel);
    }

    @Override
    public void delete(int id) {
        int delete = 0;
        if (db.materiels.isEmpty()) {
            System.out.println("there is no materiels to delete");
        }
        for (Materiel materiel : db.materiels) {
            if (materiel.getId() == id) {
                delete = 1;
                db.materiels.remove(materiel);
                System.out.println("materiel with id : " + id + " deleted");
                break;
            }
        }
        if (delete == 0) {
            System.out.println("id : " + id + " doesn't exist");
        }
    }

    @Override
    public void update(int id) {
        int update = 0;
        if (db.materiels.isEmpty()) {
            System.out.println("there is no materiels to update");
        } else {
            for (Materiel materiel : db.materiels) {
                if (materiel.getId() == id) {
                    update = 1;
                    System.out.println("Entrez le nouveau nom du materiel");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.next();
                    materiel.setName(name);
                    System.out.println("materiel with id : " + id + " modified");
                    break;
                }
            }
            if (update == 0) {
                System.out.println("Materiel does'nt exists with id " + id);
            }
        }
    }

    @Override
    public void serach(int id) {
        int search = 0;
        if (db.materiels.isEmpty()) {
            System.out.println("there is no materiels to search");
        } else {
            for (Materiel materiel : db.materiels) {
                if (materiel.getId() == id) {
                    search = 1;
                    System.out.println("Materiel exists with id " + id);
                    break;
                }
            }
            if (search == 0) {
                System.out.println("Materiel does'nt exists with id " + id);
            }
        }
    }

    @Override
    public void allocation(int id)  {
        int allouer = 0;
        if (db.materiels.isEmpty()) {
            System.out.println("there is no materiels to allocate");
        }
        else {
            for (Materiel materiel : db.materiels) {
                if (materiel.getId() == id) {
                    allouer=1;
                    db.materiels.remove(materiel);
                    System.out.println("Combien du temps voulez vous allouer ce materiel  ");
                    Scanner scanner = new Scanner(System.in);
                    String time = scanner.next();
                    System.out.println("the Materiel with id " + id + " allocate with success");
                    new Thread(() -> {
                        try {
                            TimeUnit.SECONDS.sleep(Long.parseLong(time));
                            System.out.println("the Materiel with id " + id + " is in the table of materials ");
                            db.materiels.add(materiel);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    break;
                }
            }
            if (allouer == 0) {
                System.out.println("Materiel does'nt exists with id " + id);
            }
        }
}
}