import framework.CollectionJoueurs;
import framework.Joueur;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;


public class TestCollectionJoueur {

    CollectionJoueurs cj;

    @Test
    public void setup(){

        cj = new CollectionJoueurs(1);
        cj.ajouterJoueur("a");
    }

    @Test
    public void ajouterJoueur(){
        setup();
        int longueur = cj.ajouterJoueur("b");
        assertEquals(2, longueur);
        longueur = cj.ajouterJoueur("c");
        assertEquals(3, longueur);
    }

    @Test
    public void iterator(){
        ajouterJoueur();

        Iterator<Joueur> it = cj.creerIterator();
        int indice = 0;
        while(it.hasNext()){
            String nom = it.next().getNom();
            //Test que le premier est bien le joueur a
            if(indice == 0){
                assertEquals("a", nom);
            }
            //Test que le dernier est bien le joueur c
            if(indice == 2){
                assertEquals("c", nom);
            }
            indice++;
        }
    }

    /**
     * Reinitialise les score des joueurs
     */
    @Test
    public void reinitialiser(){
        setup();
        Iterator<Joueur> it = cj.creerIterator();
        while(it.hasNext()){
            Joueur j = it.next();
            j.ajouterScore(3);
            assertEquals(3, j.getScore());

            cj.reinitialiserScore();
            assertEquals(0, j.getScore());
        }
    }
}