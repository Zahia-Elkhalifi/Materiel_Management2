package com.ensa.gi4.controller;

import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Component("controllerPricipal")
public class GestionMaterielController {

    @Autowired
    @Qualifier("materielService")
    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }

    public void afficherMenu() {
        System.out.println("0- pour sortir de l'application, entrer 0");
        System.out.println("1- pour lister les matériels, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un matériel, entrer 3");
        System.out.println("4- pour modifier un matériel, entrer 4");
        System.out.println("5- pour chercher un matériel, entrer 5");
        System.out.println("6- pour allouer un matériel, entrer 6");

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            ajouterNouveauMateriel();
        } else if("3".equals(next)){
            delete();
        } else if("4".equals(next)){
            update();
        } else if("5".equals(next)){
            search();
        } else if("6".equals(next)){
            allocation();
        }else {
            System.out.println("choix invalide");
        }
    }

    private void allocation() { gestionMaterielService.allocation();}
    private void search() {gestionMaterielService.search();}
    private void update() {
        gestionMaterielService.update();
    }
    private void sortirDeLApplication() {System.exit(0);}
    public void ajouterNouveauMateriel(){gestionMaterielService.ajouterNouveauMateriel();}
    public void delete(){
        gestionMaterielService.delete();
    }
}
