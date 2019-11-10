package Strategies;

import framework.CollectionJoueurs;
import framework.Joueur;

import java.util.Arrays;
import java.util.Collections;

public class StrategieBuncoPlus implements StrategieScore{

    static final int valeurBunco = 21;
    final int valeurTousPareil = 5;

    /**
     * Calcule le vainqueur d'une partie selon le compare to des joueurs, soit leurs score
     * Le score le plus haut est le vainqueur
     * @param joueurs
     * @return les joueurs dans leur ordre de classement
     */
    public CollectionJoueurs calculerVainqueur(CollectionJoueurs joueurs) {
        Arrays.sort(joueurs.getJoueurs(), Collections.reverseOrder());
        return joueurs;
    }

    /**
     * Calcule le score d'un tour d'un joueur selon ses des et le tour actuel
     * Valeur de est egal au tour: 1 point
     * Si tous les des sont egal au tour: 21 points
     * Si tous les des sont pareil mais pas egal au tour : 5 points
     * Sinon 0 points
     * @param des
     * @param tour
     * @return
     */
    public int calculerScoreTour(int[] des, int tour) {
        int score = 0;
        if(des != null) {
            boolean tousPareil = true;

            //Ajoute 1 point a chaque des == au tour
            for(int i =0; i < des.length; ++i){
                if(des[i] == tour)
                    score++;
                //verifie sil sont tous pareil
                if(i != 0){
                    //Verifie avec le de precedent
                    if(des[i] != des[i-1])
                        tousPareil = false;
                }
            }
            //si tous les des tombe sur le meme chiffre que le tour
            if(score == des.length )
                score = valeurBunco;
                //S'ils sont tous pareil mais != tour
            else if(tousPareil)
                score = valeurTousPareil;
        }
        return score;
    }

}
