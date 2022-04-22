package com.ensa.gi4.service.impl;

import com.ensa.gi4.Dao.api.GestionMaterielDao;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Component("materielService")
public class GestionMaterielServiceImpl implements GestionMaterielService {

    @Autowired
    private GestionMaterielDao gestionMaterielDao;

    // bd goes here
    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void listerMateriel() {
    gestionMaterielDao.listerMateriel();
    }

    @Override
    public void ajouterNouveauMateriel() {
        System.out.println("1- ajouter un livre");
        System.out.println(("2- ajouter une chaise"));
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("1".equals(next)) {
            System.out.println("Entrez le nom du livre : ");
            String nom = scanner.next();
            Livre livre = new Livre();
            livre.setName(nom);
            livre.setId();
            gestionMaterielDao.ajouterNouveauMateriel(livre);
        }
        else if ("2".equals(next)){
            System.out.println("Entrez le nom de la chaise : ");
            String nom = scanner.next();
            Chaise chaise = new Chaise();
            chaise.setName(nom);
            chaise.setId();
            gestionMaterielDao.ajouterNouveauMateriel(chaise);
        } else {
            System.out.println("choix invalide");
        }
    }

    @Override
    public void delete() {
        System.out.println("Entrez l'id du matériel que vou voulez supprimer");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.next());
        gestionMaterielDao.delete(id);
    }

    @Override
    public void update() {
        System.out.println("Entrez l'id du matériel que vou voulez modifierr");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.next());
        gestionMaterielDao.update(id);
    }

    @Override
    public void search() {
        System.out.println("Entrez l'id du matériel que vous cherchez");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.next());
        gestionMaterielDao.serach(id);
    }

    @Override
    public void allocation()  {
            System.out.println("Entrez l'id du materiel que vous voulez allouer : ");
            Scanner scanner = new Scanner(System.in);
            int id = Integer.parseInt(scanner.next());
            gestionMaterielDao.allocation(id);
        }
}
