import JeuConcret.Fabrique;
import framework.CollectionDes;
import framework.De;
import framework.Joueur;
import junit.extensions.TestSetup;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCollectionDe {

    CollectionDes cd;

    /**
     * Initialise le test pour etre en mesure dinterragir avec la collection
     */
    @Test
    public void setup(){
        Fabrique fb = new Fabrique();
        cd = fb.creerCollectionDes(2,6);
        assertEquals(2, cd.getNbDe());

    }

    /**
     * Test l'iterateur de la collection
     */
    @Test
    public void creerIterator(){
        setup();
        Iterator<De> it = cd.creerIterator();
        int nbIteration = 0;
        while(it.hasNext()){
            De d = it.next();
            assertEquals(6, d.getNbFaces());
            nbIteration++;
        }
        assertEquals(2, nbIteration);
    }

    /**
     * S'assure que les valeurs d'un lancer reste entre les valeurs des faces des des
     */
    @Test
    public void lancer(){
        setup();
        int[] valeurDe = cd.lancer();
        assertTrue(valeurDe[0] > 0 && valeurDe[0] <= 6);
        assertTrue(valeurDe[1] > 0 && valeurDe[1] <= 6);
    }

}
