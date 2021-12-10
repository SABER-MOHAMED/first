
package mini.projet;

import java.util.*;

public class MiniProjet {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String test , nom , sec , c;
        float moy = 0;
        boolean bool;
        Ecole e = new Ecole();
        do{
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+                     Gestion Elève                     +");
            System.out.println("+       1:  Ajouter                                     +");
            System.out.println("+       2:  Afficher                                    +");
            System.out.println("+       3:  Modifier                                    +");
            System.out.println("+       4:  Supprimer                                   +");
            System.out.println("+       5:  List des admis                              +");
            System.out.println("+       6:  List d'une section                          +");
            System.out.println("+       7:  Classement des eleves par moyenne           +");
            System.out.println("+       0:  Quitter                                     +");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.print("      Tapez votre choix      :       ");
            c=input.nextLine().replaceAll("\\s", "");
            switch (c){
                case "1":
                    System.out.println("num       :     "+Eleve.compteur);
                    System.out.print("nom       :     ");
                    nom=input.nextLine().toUpperCase();
                    System.out.print("section   :     ");
                    sec=input.nextLine().replaceAll("\\s","").toUpperCase();
                    do {
                        bool=false;
                        System.out.print("moyenne   :     ");
                        test=input.nextLine().replaceAll("\\s","").replaceAll(",",".");
                        if(Verifie.isFloat(test)){
                            moy=Float.parseFloat(test);
                            if (moy>=0 && moy<=20)
                                bool=true;
                        }
                        if (!bool)
                            System.out.println("--> La condition suivante doit être remplie : 0<=moyenne<=20");
                    }while(!bool);
                    e.Ajouter(nom, sec, moy);
                    break;
                case "2":
                    if(e.ls.isEmpty()) System.out.println("--> La liste est vide");
                    else e.afficher();
                    break;
                case "3":
                    if(e.ls.isEmpty()) System.out.println("--> La liste est vide");
                    else {
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("+        qu'est-ce que tu veux modifier?            +");
                        System.out.println("+   1:  nom                                         +");
                        System.out.println("+   2:  section                                     +");
                        System.out.println("+   3:  moyenne                                     +");
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.print("      Tapez votre choix      :       ");
                        String choix=input.nextLine().replaceAll("\\s", "");
                        switch (choix) {
                            case "1":
                                System.out.println("Donner le num :");
                                test = input.nextLine().replaceAll("\\s","");
                                if(Verifie.isInteger(test)){
                                    int n = Integer.parseInt(test);
                                    if(e.index(n)!=-1){
                                        System.out.println("Donner le nouveau Nom :");
                                        nom = input.nextLine().toUpperCase();
                                        e.ModifierNom(e.index(n), nom);
                                    }
                                    else System.out.println("--> Ce numéro n'existe pas");
                                }
                                else System.out.println("--> Ce numéro n'existe pas");
                                break;
                            case "2":
                                System.out.println("Donner le num :");
                                test = input.nextLine().replaceAll("\\s","");
                                if(Verifie.isInteger(test)){
                                    int n = Integer.parseInt(test);
                                    if(e.index(n)!=-1){
                                        System.out.println("Donner le nouveau Section :");
                                        sec = input.nextLine().replaceAll("\\s", "").toUpperCase();
                                        e.ModifierSec(e.index(n), sec);
                                    }
                                    else System.out.println("--> Ce numéro n'existe pas");  
                                }
                                else System.out.println("--> Ce numéro n'existe pas");
                                break;
                            case "3":
                                System.out.println("Donner le num :");
                                test = input.nextLine().replaceAll("\\s","");
                                if(Verifie.isInteger(test)){
                                    int n = Integer.parseInt(test);
                                    if(e.index(n)!=-1){
                                        do {
                                            bool=false;
                                            System.out.print("Donner le nouveau moyenne :");
                                            test=input.nextLine().replaceAll("\\s","").replaceAll(",",".");
                                            if(Verifie.isFloat(test)){
                                                moy=Float.parseFloat(test);
                                                if (moy>=0 && moy<=20)
                                                    bool=true;
                                                else System.out.println("--> La condition suivante doit être remplie : 0<=moyenne<=20");
                                            }
                                        }while(!bool);
                                        e.ModifierMoy(e.index(n), moy);
                                    }
                                    else System.out.println("--> Ce numéro n'existe pas"); 
                                }
                                else System.out.println("--> Ce numéro n'existe pas");
                                break;
                        }
                    }
                    break;
                case "4":
                    if(e.ls.isEmpty()) System.out.println("--> La liste est vide");
                    else {
                        System.out.println("Donner le num :");
                        test = input.nextLine().replaceAll("\\s","");
                        if(Verifie.isInteger(test)){
                            int n = Integer.parseInt(test);
                            if(e.index(n)!=-1) e.Supprimer(e.index(n));
                            else System.out.println("--> Ce numéro n'existe pas");
                        }
                        else System.out.println("--> Ce numéro n'existe pas");
                    }
                    break;
                case "5":
                    if(e.ls.isEmpty()) System.out.println("--> La liste est vide");
                    else {
                        e.listAdmis();
                    }
                    break;
                case "6":
                    if(e.ls.isEmpty()) System.out.println("--> La liste est vide");
                    else {
                        System.out.print("    le nom du section   :   ");
                        sec=input.nextLine().replaceAll("\\s", "");
                        System.out.println("              ++++ la liste des élèves du cette  section ++++              ");
                        e.listSection(sec);
                    }
                    break;
                case "7":
                    if(e.ls.isEmpty()) System.out.println("--> La liste est vide");
                    else {
                        e.classement();
                    }
                    break;
                case "0":
                    System.out.println("Merci d'utiliser notre logiciel ❤️");
                    break;
                default :System.out.println("--> Le choix est incorrect");
            }   
        }while(!c.equals("0"));
        
    }
    
}
