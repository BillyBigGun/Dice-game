package JeuConcret;

import Strategies.StrategieBuncoPlus;
import framework.*;

import java.util.Iterator;

public class BuncoPlus extends Jeu {

    public boolean finTourJoueur() {
        Iterator<De> it = des.creerIterator();
        if(it.hasNext()){
            int valeur = it.next().getFaceActuelle();
            //Si la face est pareil que le tour, le tour du joueur nest pas termine
            if(valeur == tourActuel)
                return true;
        }
        return false;
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
