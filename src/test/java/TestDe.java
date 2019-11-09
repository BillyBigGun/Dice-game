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

    @Test
    public void setup(){
        Fabrique fb = new Fabrique();
        d1 = fb.creerDe(d1Faces);
        d2 = fb.creerDe(d2Faces);
        assertEquals(d1Faces, d1.getNbFaces());
        assertEquals(1, d2.getNbFaces());

    }

    @Test
    public void dupliquer(){
        setup();
        d2 = d1.dupliquer();
        assertEquals(d2.getNbFaces(), d1.getNbFaces());
    }

    @Test
    public void lancer(){
        setup();
        //faire plusieurs test de lance pour sassurer que ca respecte les condition
        for(int i = 0; i < 15; ++i){
            d1.lancer();
            assertTrue(d1.getFaceActuelle() <= d1Faces && d1.getFaceActuelle() >=1);
        }
    }

    //TODO ces test ne sont pas tres precis
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
