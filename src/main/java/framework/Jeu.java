package framework;

import Strategies.StrategieScore;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public abstract class Jeu {

    protected int nbTours;
    protected int tourActuel = 1;
    private boolean finJeu = false;
    private Joueur joueurActuel;
    protected StrategieScore strategieScore;
    protected Iterator<Joueur> joueurIterator;
    protected CollectionJoueurs joueurs;
    protected CollectionDes des;

    /**
     * Retourne la collection de des
     * @return
     */
    public CollectionDes getCollectionDe(){
        return des;
    }

    /**
     * retourne le boolean determinant la fin de la partie
     * @return
     */
    public boolean getFinJeu(){
        return finJeu;
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

    /**
     * Calcule les points d'un tour d'un joueur
     * @param des
     * @param joueur
     * @return
     */
    public abstract int calculerScoreTour(int[] des, Joueur joueur);

    /**
     * Determine si le joueur continu a joueur ou non
     * @param des
     * @return
     */
    public abstract boolean finTourJoueur(CollectionDes des);

    public CollectionJoueurs calculerVainqueur(){
        return strategieScore.calculerVainqueur(joueurs);
    }

    /**
     * Joue un tour de jeu en s'assurant de son bon deroulement
     */
    public void jouer(){
        //Jouer si le joueur actuel est determine et si ce nest pas la fin de la partie
        if(!finJeu && joueurActuel != null){
            int[] valeursDes = lancerDes();

            //Display le tour
            System.out.println("\n---TOUR #" + tourActuel + ": " + joueurActuel.getNom() + " joue---");

            //Display les des
            System.out.print("Les des sont: ");
            for(int i = 0; i < valeursDes.length; ++i){
                System.out.print(valeursDes[i] + "; ");
            }

            int score = calculerScoreTour(valeursDes, joueurActuel);
            System.out.println("\nLe joueur " + joueurActuel.getNom() + " a fait: " + score + " points. Il a maintenant " + joueurActuel.getScore() + " points");

            // Si le joueur a fini sont tour,
            // on verifie sil y a un autre joueur a joueur
            // ou si on incremente le tour ou si la partie est fini
            if(finTourJoueur(des)){
                System.out.println("Le tour du joueur " + joueurActuel.getNom() + " est termine");
                //Passe au prochain joueur
                if(joueurIterator.hasNext()){
                    prochainJoueur();
                }
                //Cree un nouvel iterator pour le prochain tour de jeu
                else if(tourActuel != nbTours){
                    prochainTour();
                }
                //La partie est termine et on calcule le vainqueur
                else{
                    finPartie();
                }
            }
        }
        //Si cest la fin de la partie
        else{
            System.out.println("La partie est termine");
        }
    }

    /**
     * Changer le joueur actuel pour le prochain joueur dans literateur
     */
    private void prochainJoueur(){
        joueurActuel = joueurIterator.next();
        System.out.println("Le nouveau joueur est: " + joueurActuel.getNom());
    }

    /**
     * Passer au prochain tour en reinitialisant literateur de joueur et le joueur actuel
     */
    private void prochainTour(){
        joueurIterator = joueurs.creerIterator();
        joueurActuel = joueurIterator.next();
        tourActuel++;
        System.out.println("Le tour de jeu est termine. Le prochain tour est le tour " + tourActuel + " sur un total de " + nbTours + " tours");
        System.out.println("C'est au tour de " + joueurActuel.getNom() + " de jouer");
        System.out.println("\n--------------------");
        System.out.println("PROCHAIN TOUR DE JEU");
        System.out.println("--------------------");
    }

    /**
     * Determiner le vainqueur de la partie
     */
    private void finPartie(){
        CollectionJoueurs classement = calculerVainqueur();
        Iterator<Joueur> it = classement.creerIterator();

        finJeu = true;
        System.out.println("\n---FIN DE LA PARTIE---");
        System.out.println("\n--Classement---");
        int indice = 1;
        //Classement
        while(it.hasNext()){
            Joueur j = it.next();
            System.out.println(indice++ + ". " + j.getNom() + " | " + j.getScore() + " points");
        }
        System.out.println("");
    }


    /**
     * Cree un jeu en assignant la collection de joueur, la collection de des,
     * la strategie et en initialisant les valeurs d'un jeu
     * @param joueurs
     */
    public Jeu(CollectionJoueurs joueurs){
        creerCollectionJoueur(joueurs);
        creerCollectionDes();
        assignerNombreTour();
        setStrategieScore();
        reinitialiserPartie();
    }

    //------ Dans la creation d'un jeu, il faut creer les joueur,
    // creer les des, choisir les des et initialiser le jeu --------------

    /**
     * Determine le nombre de tour d'une partie
     */
    protected abstract void assignerNombreTour();

    /**
     * Assiger la collection de joueur
     * @param joueurs
     */
    private void creerCollectionJoueur(CollectionJoueurs joueurs){
        this.joueurs = joueurs;
    }

    /**
     * Creer une collection de des
     */
    protected abstract void creerCollectionDes();

    /**
     * Assigne la strategie de score
     */
    protected abstract void setStrategieScore();

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
}
