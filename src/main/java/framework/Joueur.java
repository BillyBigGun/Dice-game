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

    public void ajouterScore(int ajout) {
        score += Math.abs(ajout);
    }

    public void reinitialiser(){
        score = 0;
    }

    public Joueur(String nom){
        this.nom = nom;
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
