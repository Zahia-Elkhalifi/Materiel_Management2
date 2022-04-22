package com.ensa.gi4.datatabase;

import com.ensa.gi4.modele.Materiel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class Db {
    public ArrayList<Materiel> materiels = new ArrayList<Materiel>();
}
