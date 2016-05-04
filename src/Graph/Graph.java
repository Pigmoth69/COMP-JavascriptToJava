package Graph;

import java.util.ArrayList;

public class Graph<E> {
    private ArrayList<Vertex<E>> vertices;

    public ArrayList<Vertex<E>> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex<E>> vertices) {
        this.vertices = vertices;
    }
}