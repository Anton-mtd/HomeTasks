package lesson7;


public class Main {

    public static void main(String[] args) {
        testGraph("Москва","Воронеж");
        testGraph("Орел","Липецк");
        testGraph("Воронеж","Тула");

    }

    public static void testGraph(String from, String to) {
        createGraph().findShortestWay(from, to);
    }

    private static GraphImpl createGraph() {
        GraphImpl graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула", 180);
        graph.addEdge("Москва", "Рязань", 210);
        graph.addEdge("Москва", "Калуга", 200);
        graph.addEdge("Тула", "Москва", 180);
        graph.addEdge("Тула", "Липецк", 280);
        graph.addEdge("Липецк", "Тула", 280);
        graph.addEdge("Липецк", "Воронеж", 130);
        graph.addEdge("Липецк", "Саратов", 570);
        graph.addEdge("Воронеж", "Липецк", 130);
        graph.addEdge("Воронеж", "Саратов", 520);
        graph.addEdge("Воронеж", "Курск", 230);
        graph.addEdge("Рязань", "Москва", 210);
        graph.addEdge("Рязань", "Тамбов", 290);
        graph.addEdge("Тамбов", "Рязань", 290);
        graph.addEdge("Тамбов", "Саратов", 450);
        graph.addEdge("Саратов", "Липецк", 570);
        graph.addEdge("Саратов", "Воронеж", 520);
        graph.addEdge("Саратов", "Тамбов", 450);
        graph.addEdge("Калуга", "Москва", 200);
        graph.addEdge("Калуга", "Орел", 210);
        graph.addEdge("Орел", "Калуга", 210);
        graph.addEdge("Орел", "Курск", 170);
        graph.addEdge("Курск", "Воронеж", 230);
        graph.addEdge("Курск", "Орел", 170);
        return graph;
    }
}
