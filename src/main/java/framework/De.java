package framework;
import java.util.*;

public class De implements Comparable<De> {

    private int nombreFaces;
    private Random randomNumber;
    private int faceActuelle;

    /**
     * @return le nombre de faces d'un de
     */
    public int getNbFaces(){
        return nombreFaces;
    }

    /**
     * @return la valeur du de (la face sur laquelle le de est tombe, la face superieure)
     */
    public int getFaceActuelle(){
        return faceActuelle;
    }

    /**
     * assigne la valeur du de (assigne sa face superieure)
     * @param face
     */
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
     * Cree un de avec seulement un nombre de face positif superieur a 0
     * @param nbFaces
     */
    public De(int nbFaces){
        nombreFaces = Math.abs(nbFaces);
        if(nombreFaces == 0)
            nombreFaces = 1;
        randomNumber = new Random();
        faceActuelle = 1;
    }

    /**
     * implemente de l'interface comparable
     * Compare la face actuelle de 2 des
     * @param de
     * @return 0 --> de egaux | 1 --> this > parametre | -1 --> this < parametre
     */
    public int compareTo(De de) {
        int face = de.getFaceActuelle();

        if(face < this.faceActuelle)
            return 1;
        else if(face > this.faceActuelle)
            return -1;
        return 0;
    }
}
