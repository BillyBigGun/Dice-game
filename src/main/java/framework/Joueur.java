package framework;
import java.util.*;

public class Joueur implements Comparable<Joueur>{

    private String nom;
    private int score;

    public int getScore(){
        return score;
    }

    public String getNom(){
        return nom;
    }

    /**
     * Ajoute toujours une valeur positive, ne peut pas reduire le score
     * @param ajout
     */
    public void ajouterScore(int ajout) {
        score += Math.abs(ajout);
    }

    /**
     * Soustrait une valeur au score, ne peut pas etre sous 0
     * @param reduction
     * @return
     */
    public void soustraireScore(int reduction){
        if(score - Math.abs(reduction) >= 0){
            score -= Math.abs(reduction);
        }
        else
            score = 0;
    }

    /**
     * Reinitialise le score a 0
     */
    public void reinitialiser(){
        score = 0;
    }

    public Joueur(String nom){
        this.nom = nom;
        if(nom == null || nom == "")
            this.nom = "NoName";
        this.score = 0;
    }

    public int compareTo(Joueur joueur){
        int scoreJoueur = joueur.getScore();
        if(scoreJoueur < this.score)
            return 1;
        else if(scoreJoueur > this.score)
            return -1;
        return 0;
    }
}
