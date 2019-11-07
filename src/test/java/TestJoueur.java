import framework.Joueur;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJoueur {

    Joueur j1;
    Joueur j2;
    @Test
    public void setup(){
        j1 = new Joueur("a");
        assertEquals("a", j1.getNom());
        assertEquals(0, j1.getScore());
        j2 = new Joueur("b");
    }

    @Test
    public void ajouterScore(){
        setup();
        j1.ajouterScore(12);
        assertEquals(12, j1.getScore());

        j1.ajouterScore(2);
        assertEquals(14, j1.getScore());

        j1.ajouterScore(-4);
        assertEquals(18, j1.getScore());

    }

    @Test
    public void compareTo(){
        setup();
        ajouterScore();
        j2.ajouterScore(2);
        //j1 > j2
        int compare = j1.compareTo(j2);
        assertEquals(1, compare);

        //j2 < j1
        compare = j2.compareTo(j1);
        assertEquals(-1 , compare);

        //j1 == j2
        j1.reinitialiser();
        j1.ajouterScore(2);
        compare = j2.compareTo(j1);
        assertEquals(0, compare);
    }



}
