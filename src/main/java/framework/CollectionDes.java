package framework;

import java.util.Iterator;

public class CollectionDes {

    private De[] des;
    private int nbDes;

    public int getNbDe(){
        return nbDes;
    }

    /**
     * Cree un iterator de De
     * @return
     */
    public Iterator<De> creerIterator(){
        return new DeIterator<De>();
    }

    public int lancer(int indiceDe){
        if(indiceDe < des.length && indiceDe >= 0){
            return des[indiceDe].lancer();
        }
        return 0;
    }

    public CollectionDes(int nbDe, int nbFaces){
        this.nbDes = nbDe;
        this.des = new De[nbDe];
        for(int i = 0; i < des.length; ++i){
            this.des[i] = new De(nbFaces);
        }
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
