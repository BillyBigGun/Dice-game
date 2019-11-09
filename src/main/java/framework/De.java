package framework;
import java.util.*;

public class De implements Comparable<De> {

    private int nombreFaces;
    private Random randomNumber;
    private int faceActuelle;

    public int getNbFaces(){
        return nombreFaces;
    }

    public int getFaceActuelle(){
        return faceActuelle;
    }
    public void setFaceActuelle(int face){
        if(face > 0 && face <= nombreFaces)
            this.faceActuelle = face;
    }

    /**
     * Duplique le de et retourne sa copie
     * @return
     */
    public De dupliquer(){
        return new De(getNbFaces());
    }

    /**
     * permet de simuler un lancer de de retournant une valeur aleatoire entre 1 et son nombre de faces
     * @return
     */
    public int lancer(){
        faceActuelle = randomNumber.nextInt(nombreFaces) + 1;
        return faceActuelle;
    }

    /**
     * Cree un de avec seulement un nombre de face positif
     * @param nbFaces
     */
    public De(int nbFaces){
        nombreFaces = Math.abs(nbFaces);
        randomNumber = new Random();
        faceActuelle = 1;
    }

    public int compareTo(De de) {
        int face = de.getFaceActuelle();

        if(face < this.faceActuelle)
            return 1;
        else if(face > this.faceActuelle)
            return -1;
        return 0;
    }
}
