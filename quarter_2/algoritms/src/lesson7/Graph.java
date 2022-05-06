package lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, Integer distance);

    int getSize();

    void display();

    void deepFirstSearch(String startLabel);

    void breadthFirstSearch(String startLabel);

}
