package service;

import models.Departement;
import models.Enseignant;

import java.util.ArrayList;

public class EnseignantServices {

    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept){
        return  new Enseignant();
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept){
        return  new Enseignant();
    }
    public static ArrayList<Enseignant> deleteEnsById(int id){
        return  BD.enseignants;
    }

    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant : BD.enseignants) {
            if (enseignant.getId() == id) return  enseignant;



        }
        return  new Enseignant();
    }

    public static ArrayList<Enseignant> getAllEns(){
        return  BD.enseignants;
    }
}

