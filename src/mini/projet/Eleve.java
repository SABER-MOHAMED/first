
package mini.projet;

public class Eleve {
    
    static int compteur=1;
    private int num;
    private String nom;
    private String sec;
    private float moy;
    
    public Eleve() {
    }
    
    public Eleve(String nom, String sec, float moy) {
        num=compteur++;
        this.nom = nom;
        this.sec = sec;
        this.moy = moy;
    }
    
    void afficher(){
        System.out.println("****************************************");
        System.out.println("    num         :    "+num);
        System.out.println("    nom         :    "+nom);
        System.out.println("    section     :    "+sec);
        System.out.println("    moyenne     :    "+moy);
        System.out.println("****************************************");
    }
    
    public int getNum() {
        return num;
    }

    public String getNom() {
        return nom;
    }

    public String getSec() {
        return sec;
    }

    public float getMoy() {
        return moy;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public void setMoy(float moy) {
        this.moy = moy;
    }
    
}
