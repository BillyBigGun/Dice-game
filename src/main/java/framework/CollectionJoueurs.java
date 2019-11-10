package framework;

import java.util.Iterator;

public class CollectionJoueurs {

    private Joueur[] joueurs;

    //Permet de determiner si les tableau est plein
    //Es l'indice du joueur dun nouveau joueur dans le tableau
    int indiceNouveauJoueur;

    /**
     * Ajoute un nouveau joueur au tableau
     * Si le tableau est plein, on l'agrandi
     * @param j
     * @return la longueur de la collection de joueur
     */
    public int ajouterJoueur(Joueur j){
        //Lorsque le tableau n'est pas rempli, ajouter le joueur dans ce tableau dans l'indice vide le plus bas
        if(indiceNouveauJoueur < joueurs.length)
            joueurs[indiceNouveauJoueur++] = j;

        //Cree un tableau plus grand avec un joueur de plus
        else{
            Joueur[] js = new Joueur[joueurs.length + 1];
            for(int i =0; i < js.length - 1; ++i){
                js[i] = joueurs[i];
            }
            //Ajoute le nouveau joueur au tableau
            js[js.length - 1] = j;
            joueurs = js;
            indiceNouveauJoueur++;
        }
        return joueurs.length;
    }

    /**
     * retourne le tableau de joueurs
     * @return
     */
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

    /**
     * Reinitialise le score de tous les joueurs de la collection
     */
    public void reinitialiserScore(){
        Iterator<Joueur> iterator = creerIterator();
        while(iterator.hasNext()){
            iterator.next().reinitialiser();
        }
    }
    /**
     * Cree un tableau de joueur vide, il faut les ajouter avec la methode ajouter joueur
     *
     */
    public CollectionJoueurs(){
        joueurs = new Joueur[1];
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
