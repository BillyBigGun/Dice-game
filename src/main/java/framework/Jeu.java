package framework;

import Strategies.StrategieScore;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public abstract class Jeu {

    //TODO nbTours doit pt etre assige en parametre
    private final int nbTours = 10;
    protected int tourActuel = 1;
    private boolean finJeu = false;
    private Joueur joueurActuel;
    protected StrategieScore strategieScore;
    protected Iterator<Joueur> joueurIterator;
    protected CollectionJoueurs joueurs;
    protected CollectionDes des;

    /**
     * reinitialise le jeu
     */
    public void reinitialiserPartie(){
        joueurs.reinitialiserScore();
        tourActuel = 1;
        finJeu = false;
        joueurIterator = joueurs.creerIterator();
        joueurActuel = null;
        if(joueurIterator.hasNext())
            joueurActuel = joueurIterator.next();
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

    public abstract boolean finTourJoueur();

    public int calculerScoreTour(int[] des){
        int score = strategieScore.calculerScoreTour(des, tourActuel);
        joueurActuel.ajouterScore(score);
        return score;
    }

    public Joueur calculerVainqueur(){
        return strategieScore.calculerVainqueur(joueurs);
    }

    public void jouer(){
        if(!finJeu && joueurActuel != null){
            int[] valeursDes = lancerDes();
            //Display les des
            System.out.print("\nLes des sont: ");

            for(int i = 0; i < valeursDes.length; ++i){
                System.out.print(valeursDes[i] + ", ");
            }

            int score = calculerScoreTour(valeursDes);
            System.out.println("\nLe joueur " + joueurActuel.getNom() + " a fait: " + score + " points. Il a maintenant " + joueurActuel.getScore() + " points");

            //Si le joueur a fini sont tour,
            // on verifie sil y a un autre joueur a joueur
            // ou si on incremente le tour ou si la partie est fini
            if(finTourJoueur()){
                System.out.println("Le tour du joueur " + joueurActuel.getNom() + " est termine");

                //Passe au prochain joueur
                if(joueurIterator.hasNext()){
                    joueurActuel = joueurIterator.next();
                    System.out.println("Le nouveau joueur est: " + joueurActuel.getNom());
                }

                //Cree un nouvel iterator pour le prochain tour de jeu
                else if(tourActuel != nbTours){
                    joueurIterator = joueurs.creerIterator();
                    joueurActuel = joueurIterator.next();
                    tourActuel++;
                    System.out.println("Le tour de jeu est termine. Le prochain tour est le tour " + tourActuel + " sur un total de " + nbTours + " tours");
                    System.out.println("C'est au tour de " + joueurActuel.getNom() + " de jouer");
                    System.out.println("--------------------");
                }

                //La partie est termine et on calcule le vainqueur
                else{
                    Joueur vainqueur = calculerVainqueur();
                    System.out.println("Le vainqueur de la partie est " + vainqueur.getNom());
                    finJeu = true;
                    System.out.println("---FIN DE LA PARTIE---");
                }
            }
        }
        else{
            System.out.println("La partie est termine");
        }
    }

    //TODO les constructeur de jeu
    public Jeu(CollectionJoueurs joueurs, CollectionDes des){
        this.joueurs = joueurs;
        this.des = des;
        reinitialiserPartie();
    }

    public Jeu(CollectionJoueurs joueurs){
        this.joueurs = joueurs;
        reinitialiserPartie();

    }
}
