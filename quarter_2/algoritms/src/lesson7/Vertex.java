package lesson7;

import java.util.Objects;

public class Vertex {

    private final String label;
    private boolean isVisited;
    private Integer distanceMark = 0;
    private Integer shortestWayFromVertex;


    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Integer getDistanceMark() {
        return distanceMark;
    }

    public void setDistanceMark(Integer distanceMark) {
        this.distanceMark = distanceMark;
    }

    public Integer getShortestWayFromVertex() {
        return shortestWayFromVertex;
    }

    public void setShortestWayFromVertex(Integer shortestWayFromVertex) {
        this.shortestWayFromVertex = shortestWayFromVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }
}
