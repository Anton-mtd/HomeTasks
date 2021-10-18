import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final String AI_WiN_MSG = "Победил компьютер!";
    public static final String HUMAN_WIN_MSG = "Победил человек!";
    public static final String DRAW_MSG = "Ничья!";

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';

    private static final int SIZE = 5;
    private static final int POINTS_FOR_WIN = 4;

    private static Scanner scanner;
    private static Random random;
    private static char[][] map;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();

        initMap();
        printMap();
        startGameLoop();
    }

    private static void startGameLoop() {
        while (true){
            humanTurn();
            printMap();

            if (checkEndGame(DOT_X)) break;

            aiTurn();
            printMap();

            if (checkEndGame(DOT_O)) break;
        }
    }

    private static boolean checkEndGame(char symbol) {
        if (isMapFull()){
            System.out.println(DRAW_MSG);
            return true;
        }

        if (isWin(symbol)){
            System.out.println(getWinMessageBy(symbol));
            return true;
        }
        return false;
    }

    private static String getWinMessageBy(char symbol){
        return symbol == DOT_X ? HUMAN_WIN_MSG : AI_WiN_MSG;
    }

    public static boolean isWin(char symbol) {
        return checkRowsAndCols(symbol) || checkDiagonals(symbol);
    }

    public static boolean checkRowsAndCols(char symbol){
        for (int i = 0; i < SIZE ; i++) {
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < SIZE ; j++) {
                rowCounter = (map[j][i] == symbol) ? ++rowCounter : 0;
                colCounter = (map[i][j] == symbol) ? ++colCounter : 0;
                if (rowCounter == POINTS_FOR_WIN || colCounter == POINTS_FOR_WIN)
                    return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonals(char symbol){
        int firstDiagCounter = 0;
        int secondDiagCounter = 0;
        for (int i = 0; i < SIZE ; i++) {
            firstDiagCounter = (map[i][i] == symbol) ? ++firstDiagCounter : 0;
            secondDiagCounter = (map[i][map.length - 1 - i] == symbol) ? ++secondDiagCounter: 0;
            if (firstDiagCounter == POINTS_FOR_WIN || secondDiagCounter == POINTS_FOR_WIN)
                return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (isEmptyCell(i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int [] cell = getNextCellToWin(DOT_O);
        if (cell == null) {
            cell = getNextCellToWin(DOT_X);
            if (cell == null){
                cell = getRandomEmptyCell();
            }
        }
        int row = cell[0];
        int col = cell[1];
        map[row][col] = DOT_O;
    }

    public static int[] getNextCellToWin(char symbol) {
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length ; j++) {
                if (map[i][j] == DOT_EMPTY && isGameMoveWinning(i,j,symbol)){
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }

    private static boolean isGameMoveWinning(int rowIndex, int colIndex, char symbol){
        map[rowIndex][colIndex] = symbol;
        boolean result = isWin(symbol);
        map[rowIndex][colIndex] = DOT_EMPTY;
        return result;
    }

    private static int[] getRandomEmptyCell(){
        int row, col;
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        }while (!isEmptyCell(row,col));
        return new int [] {row, col};
    }

    private static void humanTurn() {
        System.out.println("Введите координаты row col: ");
        int row;
        int col;

        while (true) {
            row = readIndex();
            col = readIndex();
            if (checkRange(row) && checkRange(col)){
                if (isEmptyCell(row - 1, col - 1)){
                    break;
                }
                else
                    System.out.println("Клетка уже занята!");
            }
            else
                System.out.println("координаты должны быть в диапазоне от 1 до " + SIZE);
        }

        map[row - 1][col - 1] = DOT_X;
    }

    private static boolean isEmptyCell(int row, int col){
        return map[row][col] == DOT_EMPTY;
    }

    private static int readIndex() {
        while (!scanner.hasNextInt()) {
            System.out.println("Координаты должны иметь целочисленное значение!");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private static boolean checkRange(int index) {
        return index >= 1 && index <= SIZE;
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int i = 0; i < map.length; i++) {
            printRowNumber(i);
            printRow(map[i]);
            System.out.println();
        }
    }

    private static void printRow(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    private static void printRowNumber(int rowNumber) {
        System.out.print((rowNumber + 1) + " ");
    }

    private static void printMapHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}