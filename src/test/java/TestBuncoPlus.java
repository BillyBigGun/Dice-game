import JeuConcret.BuncoPlus;
import framework.CollectionDes;
import framework.CollectionJoueurs;
import org.junit.Test;

public class TestBuncoPlus {

    BuncoPlus buncoPlus;
    @Test
    public void setup(){
        CollectionJoueurs cj = new CollectionJoueurs(2);
        CollectionDes cd = new CollectionDes(3, 6);
        cj.ajouterJoueur("Alex");
        cj.ajouterJoueur("Billy");

        buncoPlus = new BuncoPlus(cj, cd);
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
