import JeuConcret.BuncoPlus;
import JeuConcret.Fabrique;
import framework.CollectionDes;
import framework.CollectionJoueurs;
import org.junit.Test;

public class TestBuncoPlus {

    BuncoPlus buncoPlus;
    @Test
    public void setup(){
        Fabrique fb = new Fabrique();
        CollectionJoueurs cj = fb.creerCollectionJoueur();
        cj.ajouterJoueur(fb.creerJoueur("Alex"));
        cj.ajouterJoueur(fb.creerJoueur("Billy"));

        buncoPlus = new BuncoPlus(cj);
    }

    @Test
    public void finTourJoueur(){
        setup();
        buncoPlus.jouer();
        buncoPlus.finTourJoueur();
    }

    @Test
    public void jouer(){
        setup();
        int i = 0;
        while(100 > i++){
            buncoPlus.jouer();
        }
    }
}
