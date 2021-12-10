
package mini.projet;

public class Verifie {
    
    public static boolean isInteger (String s) {
        int n;
        boolean bool;
        try {
            n=Integer.parseInt(s);
            bool=true;
        }catch (Exception e) {
            bool=false;
        }
        return bool;
    }
    
    public static boolean isFloat (String s) {
        float f;
        boolean bool;
        try {
            f=Float.parseFloat(s);
            bool=true;
        }catch (Exception e) {
            bool=false;
        }
        return bool;
    }
    
}
