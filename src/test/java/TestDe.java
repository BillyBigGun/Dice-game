import JeuConcret.Fabrique;
import framework.De;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDe {

    De d1;
    De d2;
    final int d1Faces = 6;
    final int d2Faces = -1;

    /**
     * Initialise le test pour etre en mesure d'interagir avec un de
     */
    @Test
    public void setup(){
        Fabrique fb = new Fabrique();
        d1 = fb.creerDe(d1Faces);

        //Test face negative
        d2 = fb.creerDe(d2Faces);
        assertEquals(d1Faces, d1.getNbFaces());
        assertEquals(1, d2.getNbFaces());

        //test avec 0 face
        De d3 = fb.creerDe(0);
        assertEquals(1, d3.getNbFaces());
    }

    /**
     * test la duplication dun de en comparant sont nombre de faces
     */
    @Test
    public void dupliquer(){
        setup();
        d2 = d1.dupliquer();
        assertEquals(d2.getNbFaces(), d1.getNbFaces());
    }

    /**
     * Test le lancer d'un de respecte les valeurs qu'il peut supporter
     */
    @Test
    public void lancer(){
        setup();
        //faire plusieurs test de lance pour sassurer que ca respecte les condition
        for(int i = 0; i < 15; ++i){
            d1.lancer();
            assertTrue(d1.getFaceActuelle() <= d1Faces && d1.getFaceActuelle() >=1);
        }
    }

    /**
     * Sassure que le compare to fonctionne bien en essayant avec des valeurs plus petite plus grande et egales
     */
    @Test
    public void compareTo(){
        setup();
        d1.setFaceActuelle(3);
        d2.setFaceActuelle(1);

        int compare = d1.compareTo(d2);
        assertEquals(1, compare );

        compare = d2.compareTo(d1);
        assertEquals(-1, compare);

        compare = d1.compareTo(d1);
        assertEquals(0, compare);
    }
}
