package JeuConcret;

import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.De;
import framework.Joueur;

public class Fabrique {

    public Joueur creerJoueur(String nom){
        return new Joueur(nom);
    }

    public De creerDe(int nbFace){
        return new De(nbFace);
    }

    public CollectionDes creerCollectionDes(int nbDes, int nbFaces){
        De[] des = new De[nbDes];
        for(int i = 0; i < nbDes; ++i){
            des[i] = new De(nbFaces);
        }
        CollectionDes colDes = new CollectionDes(des);
        return colDes;
    }

    public CollectionJoueurs creerCollectionJoueur() {
        CollectionJoueurs joueurs = new CollectionJoueurs();
        return joueurs;
    }
}
