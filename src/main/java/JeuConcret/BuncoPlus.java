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
    public boolean finTourJoueur(CollectionDes des) {
        Iterator<De> it = des.creerIterator();
        int nbChiffreEgalTour = 0;
        boolean tousPareil = true;
        int indice = 0;
        De dePrecedent = null;

        while(it.hasNext()){
            De deActuel = it.next();
            int valeur = deActuel.getFaceActuelle();

            //Si la face est pareil que le tour, le tour du joueur nest pas termine
            if(valeur == tourActuel)
                nbChiffreEgalTour++;

            //Si un de est different des autre, mettre a false
            if(indice++ != 0){
                //Si ils ne sont pas egal
                if(dePrecedent.compareTo(deActuel) != 0){
                    tousPareil = false;
                }
            }
            dePrecedent = deActuel;
        }
        //Cest un bunco!
        if(nbChiffreEgalTour == des.getNbDe())
            return true;

        //Au moins un de == tour
        else if(nbChiffreEgalTour > 0) {
            System.out.println("Le joueur peut continuer a jouer!");
            return false;
        }

        //Tous les des sont pareil
        else if(tousPareil){
            System.out.println("Le joueur peut continuer a jouer!");
            return false;
        }
        //Tous different et non == au tour
        return true;
    }

    @Override
    public int calculerScoreTour(int[] des, Joueur joueur) {
        int score = strategieScore.calculerScoreTour(des, tourActuel);
        joueur.ajouterScore(score);
        return score;
    }

    /**
     * Cree une instance du Bunco+ en determinant le nombre de tours pour le jeu
     * @param joueurs
     */
    public BuncoPlus(CollectionJoueurs joueurs) {
        super(joueurs);
    }

    @Override
    protected void assignerNombreTour() {
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
