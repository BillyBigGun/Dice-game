package JeuConcret;

import Strategies.StrategieBuncoPlus;
import framework.*;

import java.util.Iterator;

public class BuncoPlus extends Jeu {

    private final int nbDes = 3;
    private final int nbFaces = 6;
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

    @Override
    public int calculerScoreTour(int[] des, Joueur joueur) {
        int score = strategieScore.calculerScoreTour(des, tourActuel);
        joueur.ajouterScore(score);
        return score;
    }

    /*public void calculerScoreTour(int[] des) {

    }

    public Joueur calculerVainqueur() {
        return null;
    }*/

    public BuncoPlus(CollectionJoueurs joueurs) {
        super(joueurs);
        this.nbTours = nbFaces;

    }

    @Override
    protected void creerCollectionDes() {
        Fabrique fb = new Fabrique();
        this.des = fb.creerCollectionDes(nbDes, nbFaces);
    }

    @Override
    protected void setStrategieScore() {
        this.strategieScore = new StrategieBuncoPlus();
    }


}
