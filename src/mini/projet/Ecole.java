
package mini.projet;

import java.util.ArrayList;

public class Ecole {
     
    ArrayList <Eleve> ls = new ArrayList <Eleve>();
    
    public int index(int num){
        int index = -1;
        for (int i=0 ; i<ls.size() ; i++) {
            if (ls.get(i).getNum()==num) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public void Ajouter ( String nom , String sec , float moy )
    {
        Eleve e = new Eleve( nom , sec , moy );
        ls.add(e);
    }
    
    public void ModifierMoy(int index, float moy) {
        ls.get(index).setMoy(moy);
    }
    
    public void ModifierSec(int index, String sec) {
        ls.get(index).setSec(sec);
    }
    
    public void ModifierNom(int index, String nom) {
        ls.get(index).setNom(nom);
    }
    
    public void Supprimer(int index) {
        ls.remove(index);
    }
    
    public void listAdmis()
    {
        boolean bool = false ,bool2 = true;
        for (int i=0;i<ls.size();i++)
        {
            if(ls.get(i).getMoy()>=10)
            {
                bool=true;
                if(bool2)
                     System.out.println("              ++++ la liste des admis ++++              ");
                ls.get(i).afficher();
                bool2 = false; 
            }
        }
        if (bool==false)
        System.out.println("--> Il n'y a pas d'elève admis");
    }
    
    public void listSection(String s)
    {
        boolean bool = false ;
        float somme = 0 ;
        int n = 0 ;
        for (int i=0;i<ls.size();i++)
        {
            if(ls.get(i).getSec().equalsIgnoreCase(s))
            {
                bool=true;
                ls.get(i).afficher();
                somme = somme + ls.get(i).getMoy();
                n++;
            }
        }
        if (bool){
            System.out.println("                    le moyenne du section   :"+somme/(float)n);
        }    
        else     
        System.out.println("--> Il n'y a pas d'elève dans cet section");
    }
    
    public void afficher()
    {
        for (int i=0 ; i < ls.size() ; i++)
            ls.get(i).afficher();
    }
    
    
    public void classement (){
        float max = 0 , plafond = (float) 20.1 ;
        int n=0;
        while(n!=ls.size()){
            for (int i=0 ; i<ls.size() ; i++) {
                if(ls.get(i).getMoy()<plafond && ls.get(i).getMoy()>max)
                    max=ls.get(i).getMoy();
            }
            for (int i=0 ; i<ls.size() ; i++) {
                if(ls.get(i).getMoy()==max){
                    ls.get(i).afficher();
                    n++;
                }     
            }
            plafond=max;
            max=0;
        }
        
    }
}
