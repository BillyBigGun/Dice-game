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

    @Test
    public void setup(){
        cd = new CollectionDes(2,6);
        assertEquals(2, cd.getNbDe());

    }

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

    @Test
    public void lancer(){
        setup();
        int[] valeurDe = cd.lancer();
        assertTrue(valeurDe[0] > 0 && valeurDe[0] <= 6);
        assertTrue(valeurDe[1] > 0 && valeurDe[1] <= 6);
    }

}