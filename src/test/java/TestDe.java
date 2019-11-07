import framework.De;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDe {

    De d1;
    De d2;
    final int d1Faces = 6;
    final int d2Faces = 1;

    @Test
    public void setup(){
        d1 = new De(d1Faces);
        d2 = new De(d2Faces);
        assertEquals(d1Faces, d1.getNbFaces());
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
        //faire plusieurs test de lance pour sassurer que
        for(int i = 0; i < 15; ++i){
            d1.lancer();
            assertTrue(d1.getFaceActuelle() <= d1Faces && d1.getFaceActuelle() >=1);
        }
    }

    //TODO ces test ne sont pas tres precis
    @Test
    public void compareTo(){
        setup();
        d1.lancer();
        d2.lancer();

        int compare = d1.compareTo(d2);
        assertTrue(compare >= 0);

        compare = d2.compareTo(d1);
        assertTrue(compare <= 0);

        compare = d1.compareTo(d1);
        assertEquals(0, compare);
    }
}
