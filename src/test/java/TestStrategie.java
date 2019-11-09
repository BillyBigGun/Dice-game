import JeuConcret.Fabrique;
import Strategies.StrategieBuncoPlus;
import Strategies.StrategieScore;
import framework.CollectionJoueurs;
import framework.Joueur;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStrategie {

    StrategieScore strat;
    CollectionJoueurs cj;

    @Test
    public void setup(){
        Fabrique fb = new Fabrique();
        strat = new StrategieBuncoPlus();
        cj = fb.creerCollectionJoueur();
        cj.ajouterJoueur(fb.creerJoueur("a"));
        cj.ajouterJoueur(fb.creerJoueur("b"));
    }

    @Test
    public void calculerScore(){
        setup();
        int tour = 1;
        int[] valeurDe = new int[]{1,2};
        int score = strat.calculerScoreTour(valeurDe, tour);
        assertEquals(1, score);

        valeurDe = new int[]{2,2};
        score = strat.calculerScoreTour(valeurDe, tour);
        assertEquals(5, score);

        valeurDe = new int[]{1,1};
        score = strat.calculerScoreTour(valeurDe, tour);
        assertEquals(21, score);

        valeurDe = new int[]{1,2,1};
        score = strat.calculerScoreTour(valeurDe, tour);
        assertEquals(2, score);

        valeurDe = new int[]{2,3};
        score = strat.calculerScoreTour(valeurDe, tour);
        assertEquals(0 , score);
    }

    @Test
    public void calculerVainqueur(){
        setup();
        cj.getJoueurs()[0].ajouterScore(10);
        Joueur j = strat.calculerVainqueur(cj);
        assertEquals("a", j.getNom());

        cj.getJoueurs()[1].ajouterScore(20);
        j = strat.calculerVainqueur(cj);
        assertEquals("b", j.getNom());
    }
}
