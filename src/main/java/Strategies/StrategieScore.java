package Strategies;

import framework.CollectionJoueurs;
import framework.Joueur;

public interface StrategieScore {

    /**
     * Permet de calculer le vainqueur parmis les joueurs pour déterminer qui est le vainqueur
     * @param joueurs
     * @return
     */
    CollectionJoueurs calculerVainqueur(CollectionJoueurs joueurs);

    /**
     * Permet de calculer le score d'un joueur selon le tour ou il joue et les des quil a lance
     * @param des
     * @param tour
     * @return
     */
    int calculerScoreTour(int[] des, int tour);
}
