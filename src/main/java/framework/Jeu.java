package framework;

import Strategies.StrategieScore;

import java.util.Iterator;

public abstract class Jeu {

    private int nbTours;
    private int tourActuel = 1;
    private boolean tourJoueurTermine = false;
    private boolean finJeu = false;
    protected StrategieScore strategieScore;
    protected Iterator joueurIterator;
    protected CollectionJoueurs joueurs;
    private CollectionDes des;

    /**
     * reinitialise le jeu
     */
    public void reinitialiserScore(){
        joueurs.reinitialiserScore();
        tourActuel = 1;
        tourJoueurTermine = false;
        finJeu = false;
        joueurIterator = joueurs.creerIterator();
    }

    /**
     * Lance les des un a un en fonction de l'iterator
     * @return
     */
    private int[] lancerDes(){
        Iterator<De> it = des.creerIterator();
        int[] valeurDes = new int[des.getNbDe()];
        int indiceDe = 0;

        while(it.hasNext()){
            valeurDes[indiceDe++] = it.next().lancer();
        }
        return valeurDes;
    }

    public abstract boolean determinerFinTourJoueur();

    public abstract void calculerScoreTour(int[] des);

    public abstract Joueur calculerVainqueur();

    public void jouer(){
        if(!finJeu){
            int[] valeursDes = lancerDes();
            calculerScoreTour(valeursDes);

            //Si le joueur a fini sont tour,
            // on verifie sil y a un autre joueur a joueur
            // ou si on incremente le tour ou si la partie est fini
            if(determinerFinTourJoueur()){
                //Passe au prochain joueur
                if(joueurIterator.hasNext())
                    joueurIterator.next();
                //Cree un nouvel iterator
                else if(tourActuel != nbTours)
                    joueurIterator = joueurs.creerIterator();
                //La partie est termine et on calcule le vainqueur
                else{
                    calculerVainqueur();
                    finJeu = true;
                }
            }
        }
    }

    //TODO les constructeur de jeu
    public Jeu(CollectionJoueurs joueurs, CollectionDes des){
        this.joueurs = joueurs;
        this.des = des;
        joueurIterator = joueurs.creerIterator();
    }

    public Jeu(CollectionJoueurs joueurs){
        this.joueurs = joueurs;
        joueurIterator = joueurs.creerIterator();
    }
}
