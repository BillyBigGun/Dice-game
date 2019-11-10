import JeuConcret.BuncoPlus;
import JeuConcret.Fabrique;
import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.De;
import org.junit.Test;

import java.util.Iterator;
import static org.junit.Assert.assertEquals;

public class TestBuncoPlus {

    BuncoPlus buncoPlus;

    /**
     * Initialise le test pour etre en mesure d'interagir avec bunco+
     */
    @Test
    public void setup(){
        Fabrique fb = new Fabrique();
        CollectionJoueurs cj = fb.creerCollectionJoueur();
        cj.ajouterJoueur(fb.creerJoueur("Alex"));
        cj.ajouterJoueur(fb.creerJoueur("Billy"));
        cj.ajouterJoueur(fb.creerJoueur("Celine"));

        buncoPlus = new BuncoPlus(cj);
    }

    /**
     * S'assure que la fonction finTourJoueur fonctionne correctement
     * test 1 point : jouer encore
     * test 5 points : jouer encore
     * test bunco : fin du tour
     * test 0 : fin du tour
     */
    @Test
    public void finTourJoueur(){
        setup();

        CollectionDes des = buncoPlus.getCollectionDe();
        Iterator<De> it = des.creerIterator();
        while(it.hasNext()){
            De de = it.next();
            de.setFaceActuelle(1);
        }

        //Bunco cest la fin du tour d'un joueur
        boolean finTourJoueur = buncoPlus.finTourJoueur(des);
        assertEquals(true, finTourJoueur);


        //Test 1 point
        int indice = 1;
        it = des.creerIterator();
        while(it.hasNext()){
            De de = it.next();
            de.setFaceActuelle(indice++);
        }
        //1 point, le joueur continu a joueur
        finTourJoueur = buncoPlus.finTourJoueur(des);
        assertEquals(false, finTourJoueur);


        //Test 5 point
        it = des.creerIterator();
        while(it.hasNext()){
            De de = it.next();
            de.setFaceActuelle(2);
        }
        //5 point, le joueur continu a joueur
        finTourJoueur = buncoPlus.finTourJoueur(des);
        assertEquals(false, finTourJoueur);


        //Test 0 point
        indice = 2;
        it = des.creerIterator();
        while(it.hasNext()){
            De de = it.next();
            de.setFaceActuelle(indice ++);
        }
        //0 point, le joueur ne joue pu
        finTourJoueur = buncoPlus.finTourJoueur(des);
        assertEquals(true, finTourJoueur);

    }

    /**
     * Permet de lancer le jeu et de voir ce qui se passe dans la console
     */
    @Test
    public void jouer(){
        setup();
        int i = 0;
        while(150 > i++){
            buncoPlus.jouer();
        }
    }

    /**
     * Test la reinitialisation du jeu pour voir si on peut recommencer une partie
     */
    @Test
    public void reinitialserPartie(){
        jouer();
        //Fin de partie !!!important, si la partie dure plus que 100 tours, ceci ne sera pas vrai
        assertEquals(true, buncoPlus.getFinJeu());
        buncoPlus.reinitialiserPartie();
        //Pas la fin de la partie
        assertEquals(false,buncoPlus.getFinJeu());
    }
}
