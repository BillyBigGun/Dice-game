package Strategies;

import framework.CollectionJoueurs;
import framework.Joueur;

import java.util.Arrays;
import java.util.Collections;

public class StrategieBuncoPlus implements StrategieScore{

    static final int valeurBunco = 21;
    final int valeurTousPareil = 5;

    public CollectionJoueurs calculerVainqueur(CollectionJoueurs joueurs) {
        Arrays.sort(joueurs.getJoueurs(), Collections.reverseOrder());
        return joueurs;
    }

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
