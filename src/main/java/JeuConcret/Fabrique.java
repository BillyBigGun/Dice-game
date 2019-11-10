package JeuConcret;

import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.De;
import framework.Joueur;

public class Fabrique {

    /**
     * cree un joueur selon son nom
     * @param nom
     * @return
     */
    public Joueur creerJoueur(String nom){
        return new Joueur(nom);
    }

    /**
     * cree un de selon le nombre de face
     * @param nbFace
     * @return
     */
    public De creerDe(int nbFace){
        return new De(nbFace);
    }

    /**
     * Cree une collection de des a partir du nombre de des et de leur nombre de faces
     * @param nbDes
     * @param nbFaces
     * @return
     */
    public CollectionDes creerCollectionDes(int nbDes, int nbFaces){
        De[] des = new De[nbDes];
        for(int i = 0; i < nbDes; ++i){
            des[i] = new De(nbFaces);
        }
        CollectionDes colDes = new CollectionDes(des);
        return colDes;
    }

    /**
     * Cree une nouvelle collection de joueur
     * @return
     */
    public CollectionJoueurs creerCollectionJoueur() {
        CollectionJoueurs joueurs = new CollectionJoueurs();
        return joueurs;
    }
}
