package controllers;

import models.Departement;
import service.BD;
import service.DepartementServices;
import service.EnseignantServices;
import controllers.EnseignantsController;

public class DepartementsController {


    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
               main.showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        for (Departement departement : BD.departements) {
            System.out.print("Id : " + departement.getId());
            System.out.print(" | Intitulé : " + departement.getIntitule());
            if (! main.isNull(departement.getChef())) {
                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
            }
            System.out.println("");
        }

    }
    public static void createDepartement(){
        String intitule = main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id = main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));

        showDepartements();
        showMenu();


    }
    public static void editDepartement(){
        showDepartements();
        int id = main.getIntInput("Sélecionnez un departement par id :");
        String intitule = main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = main.getIntInput("Sélecionnez un enseignant par id :");

        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = main. getIntInput("Sélecionnez un departement par id :");
        DepartementServices.deleteDeptById(id);
        showDepartements();

    }
}
