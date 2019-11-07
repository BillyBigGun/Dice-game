package JeuConcret;

import Strategies.StrategieBuncoPlus;
import framework.*;

import java.util.Iterator;

public class BuncoPlus extends Jeu {

    /**
     * Verifie si le joueur peut jouer un autre tour en fonction des des lancees
     * @return
     */
    public boolean finTourJoueur() {
        Iterator<De> it = des.creerIterator();
        int nbChiffreEgalTour = 0;
        while(it.hasNext()){
            int valeur = it.next().getFaceActuelle();

            //Si la face est pareil que le tour, le tour du joueur nest pas termine
            if(valeur == tourActuel)
                nbChiffreEgalTour++;
        }
        //Cest un bunco!
        if(nbChiffreEgalTour == des.getNbDe())
            return true;

        //Au moins un de == tour
        else if(nbChiffreEgalTour > 0) {
            System.out.println("Le joueur peut continuer a jouer!");
            return false;
        }

        return true;
    }

    /*public void calculerScoreTour(int[] des) {

    }

    public Joueur calculerVainqueur() {
        return null;
    }*/

    public BuncoPlus(CollectionJoueurs joueurs, CollectionDes des) {
        super(joueurs, des);
        strategieScore = new StrategieBuncoPlus();
    }

    public BuncoPlus(CollectionJoueurs joueurs) {
        super(joueurs);
        strategieScore = new StrategieBuncoPlus();
    }
}
