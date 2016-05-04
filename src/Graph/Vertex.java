package Graph;

import java.util.ArrayList;

/**
 * Created by danny on 29/04/2016.
 */
public class Vertex<E> {
    private E elem;
    private ArrayList<Vertex<E>> neighbors;

    public Vertex(E elem) {
        this.elem=elem;
    }

    public E getElem() {
        return elem;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public ArrayList<Vertex<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Vertex<E>> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeightbor(E elem){
        neighbors.add(new Vertex(elem));
    }
}