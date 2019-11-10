package framework;

import JeuConcret.Fabrique;

import java.util.Iterator;

public class CollectionDes {

    private De[] des;
    private int nbDes;

    public int getNbDe(){
        return des.length;
    }

    /**
     * Cree un iterator de De
     * @return
     */
    public Iterator<De> creerIterator(){
        return new DeIterator<De>();
    }

    /*public int lancer(int indiceDe){
        if(indiceDe < des.length && indiceDe >= 0){
            return des[indiceDe].lancer();
        }
        return 0;
    }*/

    /**
     * Lance tous les des et retourne la valeur de chacun
     * @return
     */
    public int[] lancer(){
        Iterator<De> it = creerIterator();
        int[] valeurDes = new int[getNbDe()];
        int indice = 0;
        while (it.hasNext()){
            valeurDes[indice++] = it.next().lancer();
        }
        return valeurDes;
    }

    /**
     * Cree une collection de des a partir d'un tableau de des
     * @param lesDes
     */
    public CollectionDes(De[] lesDes){
        Fabrique fb = new Fabrique();
        this.nbDes = lesDes.length;
        this.des = lesDes;
    }

    private class DeIterator<De> implements Iterator<De>{

        private int indice;

        public DeIterator(){
            indice = 0;
        }

        /**
         * Verifie qu'il y a un autre de dans la collection
         * @return
         */
        public boolean hasNext() {
            if(des.length == indice)
                return false;
            return true;
        }

        /**
         * Prend le prochain de et increment lindice
         * @return
         */
        public De next() {
            //incremente indice apres lavoir retourne
            return (De) des[indice++];
        }

        /**
         * Enleve le de et change la position des autres des pour combler son vide
         */
        public void remove(){
            for(int i = indice; i < des.length - 1; ++i){
                des[indice] = des[indice + 1];
            }
        }

    }

}
