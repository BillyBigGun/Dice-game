package framework;
import java.util.Random;

public class De {

    private int nombreFaces;
    private Random randomNumber;

    public int getNbFaces(){
        return nombreFaces;
    }

    /**
     * Duplique le de et retourne sa copie
     * @return
     */
    public De dupliquer(){
        return new De(getNbFaces());
    }

    public int lancer(){
        return randomNumber.nextInt(nombreFaces+1);
    }

    public De(int nbFaces){
        nombreFaces = nbFaces;
        randomNumber = new Random();
    }
}
