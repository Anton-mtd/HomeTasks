package lesson7;

import lesson7.Vertex;

import java.util.*;

public class GraphImpl implements Graph {


    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;
    private Integer shortestWay;

    private Queue<Integer> passedVertex = new LinkedList<>();


    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }


    @Override
    public boolean addEdge(String startLabel, String secondLabel, Integer distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = distance;
        adjMatrix[endIndex][startIndex] = distance;


        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public int getShortestWay() {
        return shortestWay;
    }

    public void setShortestWay(int shortestWay) {
        this.shortestWay = shortestWay;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void findShortestWay(String startPoint, String finishPoint) {
        int startIndex = indexOf(startPoint);
        int endIndex = indexOf(finishPoint);

        passedVertex.add(startIndex);

        while (!passedVertex.isEmpty()) {
            Integer vertexIndex = -1;
            while (vertexIndex != null) {
                vertexIndex = findIndexNearestVertex(passedVertex.peek());
                if (vertexIndex != null && vertexIndex != endIndex) {
                    passedVertex.add(vertexIndex);
                }
            }
            vertexList.get(passedVertex.peek()).setVisited(true);
            passedVertex.remove();
        }
        setShortestWay(vertexList.get(endIndex).getDistanceMark());
        System.out.println(getShortestWay() + " км");
        System.out.println(printShortestWay(endIndex, new StringBuilder()));
    }


    private Integer findIndexNearestVertex(Integer vertexIndex) {
        for (int i = 0; i < adjMatrix.length; i++) {
            Vertex nearestVertex = vertexList.get(i);
            Vertex currentVertex = vertexList.get(vertexIndex);
            if (adjMatrix[vertexIndex][i] != null && !nearestVertex.isVisited()) {
                if (nearestVertex.getDistanceMark() == 0 || nearestVertex.getDistanceMark() > adjMatrix[vertexIndex][i] + currentVertex.getDistanceMark()) {
                    nearestVertex.setDistanceMark(currentVertex.getDistanceMark() + adjMatrix[vertexIndex][i]);
                    nearestVertex.setShortestWayFromVertex(vertexIndex);
                }
                adjMatrix[vertexIndex][i] = null;
                return i;
            }
        }
        return null;
    }

    private StringBuilder printShortestWay(int indexVertex, StringBuilder sb) {
        Integer lastVertexWay = indexVertex;
        Integer previousVertexWay = vertexList.get(lastVertexWay).getShortestWayFromVertex();

        sb.insert (0,vertexList.get(indexVertex));

        if (previousVertexWay == null) {
            return sb;
        } else {
            sb.insert(0, " -> ");
            printShortestWay(previousVertexWay, sb);
        } return sb;
    }

    @Override
    public void deepFirstSearch(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex == null) {
                stack.pop();
            } else {
                visitVertex(stack, vertex);
            }
        }

    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != null && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void breadthFirstSearch(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(queue, vertex);
            }
        }
    }
}

