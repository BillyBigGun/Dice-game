package framework;

import java.util.Iterator;

public class CollectionJoueurs {

    private Joueur[] joueurs;

    //Permet de determiner si les tableau est plein
    //Es l'indice du joueur dun nouveau joueur dans le tableau
    int indiceNouveauJoueur;

    /**
     * Ajoute un nouveau joueur au tableau
     * @param nom
     * @return la longueur de la collection de joueur
     */
    public int ajouterJoueur(String nom){
        if(indiceNouveauJoueur < joueurs.length)
            joueurs[indiceNouveauJoueur++] = new Joueur(nom);

        //Cree un tableau plus grand avec un joueur de plus
        else{
            Joueur[] js = new Joueur[joueurs.length + 1];
            for(int i =0; i < js.length - 1; ++i){
                js[i] = joueurs[i];
            }
            js[js.length - 1] = new Joueur(nom);
            joueurs = js;
            indiceNouveauJoueur++;
        }
        return joueurs.length;
    }

    public Joueur[] getJoueurs(){
        return joueurs;
    }

    /**
     * Cree un iterateur pour parcourir les elements du tableau
     * @return
     */
    public Iterator<Joueur> creerIterator(){
        return new JoueurIterator<Joueur>();
    }

    public void reinitialiserScore(){
        Iterator<Joueur> iterator = creerIterator();
        while(iterator.hasNext()){
            iterator.next().reinitialiser();
        }
    }
    /**
     * Cree un tableau de joueur vide, il faut les ajouter avec la methode ajouter joueur
     * @param nbJoueurs
     */
    public CollectionJoueurs(int nbJoueurs){
        joueurs = new Joueur[nbJoueurs];
        indiceNouveauJoueur = 0;
    }

    /**
     * La classe iterateur qui soccupe de la navigation du tableau joueur
     * @param <Joueur>
     */
    private class JoueurIterator<Joueur> implements Iterator<Joueur>{

        private int indice;
        public JoueurIterator(){
            indice = 0;
        }

        /**
         * Verifie sil y a un autre joueur dans le tableau
         * @return
         */
        public boolean hasNext() {
            if(joueurs.length == indice)
                return false;
            return true;
        }

        /**
         * retourne le prochain joueur
         * @return
         */
        public Joueur next() {
            //incremente indice apres lavoir retourne
            return (Joueur) joueurs[indice++];
        }

        /**
         * Enleve le joueur present de la liste et change les suivant de place pour combler le trou du joueur retire
         */
        public void remove() {
            for(int i = indice; i < joueurs.length - 1; ++i){
                joueurs[indice] = joueurs[indice + 1];
            }
        }
    }

}
