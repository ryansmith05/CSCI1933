import java.util.Queue;
import java.util.Random;

public class Minefield {
    /**
     * Global Section
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE_BRIGHT = "\u001b[34;1m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_RED_BRIGHT = "\u001b[31;1m";
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_GREY_BG = "\u001b[0m";
    private Cell[][] minefield;
    private int row;
    private int col;
    private int flagNum;
    private boolean gameOver;
    private boolean[][] flagged;
    private int mines;

    /**
     * Constructor
     *
     * @param rows    Number of rows.
     * @param columns Number of columns.
     * @param flags   Number of flags, should be equal to mines
     */
    public Minefield(int rows, int columns, int flags) {
        this.row = rows;
        this.col = columns;
        this.flagNum = flags;
        this.mines = flags;
        this.gameOver = false;
        this.flagged = new boolean[rows][columns];
        minefield = new Cell[rows][columns];

        //initialize cells
        for (int i = 0; row < minefield.length; i++) {
            for (int j = 0; col < minefield[i].length; j++) {
                minefield[row][col] = new Cell(false, "-");
            }
        }
    }

    /**
     * evaluateField
     *
     * @function When a mine is found in the field, calculate the surrounding 9x9 tiles values. If a mine is found, increase the count for the square.
     */
    public void evaluateField() {
        int amountMine = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; i < col; i++) {
                if (minefield[i][j].getStatus().equals("M")) {
                    amountMine++;
                }
            }
        }
    }

    /**
     * createMines
     *
     * @param x     Start x, avoid placing on this square.
     * @param y     Start y, avoid placing on this square.
     * @param mines Number of mines to place.
     */
    public void createMines(int x, int y, int mines) {
        Random r = new Random();
        while (mines < flagNum && mines > 0) {
            for (int i = 0; i < mines; i++) {
                row = r.nextInt(row);
                col = r.nextInt(col);
                while (row != x && col != y) {
                    minefield[row][col].setStatus("M");
                }
            }
        }
    }

    /**
     * guess
     *
     * @param x    The x value the user entered.
     * @param y    The y value the user entered.
     * @param flag A boolean value that allows the user to place a flag on the corresponding square.
     * @return boolean Return false if guess did not hit mine or if flag was placed, true if mine found.
     */
    public boolean guess(int x, int y, boolean flag) {
        //not done! need to be able to put flag??
        if (!minefield[x][y].getStatus().equals("M")) {
            minefield[x][y].setRevealed(true);
            return false;
        } else if (minefield[x][y].getStatus() == "M") {
            this.gameOver = true;
            return true;
        }
        return false;
    }

    /**
     * gameOver
     *
     * @return boolean Return false if game is not over and squares have yet to be revealed, otheriwse return true.
     */
    public boolean gameOver() {
        return this.gameOver;
    }

    /**
     * revealField
     * <p>
     * This method should follow the psuedocode given.
     * Why might a stack be useful here rather than a queue?
     *
     * @param x The x value the user entered.
     * @param y The y value the user entered.
     */
    public void revealZeroes(int x, int y) {
        Stack1Gen<int[]> myStack = new Stack1Gen<>();
        myStack.push(new int[]{x, y});
        while (!myStack.isEmpty()) {
            int[] coordinates = myStack.pop();
            int newX = coordinates[0];
            int newY = coordinates[1];

            minefield[newX][newY].setRevealed(true); //set revealed to true

            if ((0 <= newX - 1 && newX - 1 < minefield.length) && (!minefield[newX - 1][newY].getRevealed()) && (minefield[newX - 1][newY].getStatus().equals("0"))) { //check left
                myStack.push(new int[]{newX - 1, newY});
            }
            if ((0 <= newX + 1 && newX + 1 < minefield.length) && (!minefield[newX + 1][newY].getRevealed()) && (minefield[newX + 1][newY].getStatus().equals("0"))) { //check right
                myStack.push(new int[]{newX + 1, newY});
            }
            if ((0 <= newY - 1 && newY - 1 < minefield.length) && (!minefield[newX][newY - 1].getRevealed()) && (minefield[newX][newY - 1].getStatus().equals("0"))) { //check up
                myStack.push(new int[]{newX, newY - 1});
            }
            if ((0 <= newY + 1 && newY + 1 < minefield.length) && (!minefield[newX][newY + 1].getRevealed()) && (minefield[newX][newY + 1].getStatus().equals("0"))) { //check down
                myStack.push(new int[]{newX, newY + 1});
            }
        }
    }

    /**
     * revealMines
     * <p>
     * This method should follow the psuedocode given.
     * Why might a queue be useful for this function?
     *
     * @param x The x value the user entered.
     * @param y The y value the user entered.
     */
    public void revealMines(int x, int y) {
        Q1Gen<int[]> myQueue = new Q1Gen<>();
        myQueue.add(new int[]{x, y});

        while (myQueue.length() != 0) {
            int[] coordinates = myQueue.remove();
            int newX = coordinates[0];
            int newY = coordinates[1];

            minefield[newX][newY].setRevealed(true); //set revealed to true

            if (minefield[newX][newY].getStatus().equals("M")) { // found a mine, stop searching
                break;
            }
            if ((0 <= newX - 1 && newX - 1 < minefield.length) && (!minefield[newX - 1][newY].getRevealed())) { //add left
                myQueue.add(new int[]{newX - 1, newY});
            }
            if ((0 <= newX + 1 && newX + 1 < minefield.length) && (!minefield[newX + 1][newY].getRevealed())) { //add right
                myQueue.add(new int[]{newX + 1, newY});
            }
            if ((0 <= newY - 1 && newY - 1 < minefield.length) && (!minefield[newX][newY - 1].getRevealed())) { //add up
                myQueue.add(new int[]{newX, newY - 1});
            }
            if ((0 <= newY + 1 && newY + 1 < minefield.length) && (!minefield[newX][newY + 1].getRevealed())) { //add down
                myQueue.add(new int[]{newX, newY + 1});
            }
        }
    }

    /**
     * revealStart
     *
     * @param x The x value the user entered.
     * @param y The y value the user entered.
     */
    public void revealStart(int x, int y) {
        // Create mines on the field, avoiding the starting point (x, y)
        createMines(x, y, mines);

        // Evaluate the field to calculate the number of surrounding mines for each cell
        evaluateField();

        // Reveal enough information for the user to get started
        revealMines(x, y);
    }

    /**
     * printMinefield
     *
     * @fuctnion This method should print the entire minefield, regardless if the user has guessed a square.
     * *This method should print out when debug mode has been selected.
     */
    public void printMinefield() {
        // Print column numbers
        System.out.print("  ");
        for (int i = 0; i < this.col; i++) {
            System.out.print(i % 10 + " ");
        }
        System.out.println();

        // Print rows
        for (int row = 0; row < this.row; row++) {
            // Print row number
            System.out.print(row % 10 + " ");

            // Print cells
            for (int col = 0; col < this.col; col++) {
                Cell cell = minefield[row][col];
                String status = cell.getStatus();

                if ("1".equals(status)) {
                    System.out.print(ANSI_BLUE + status + ANSI_GREY_BG + " ");
                } else if ("0".equals(status)) {
                    System.out.print(ANSI_YELLOW + status + ANSI_GREY_BG + " ");
                } else if ("2".equals(status)) {
                    System.out.print(ANSI_GREEN + status + ANSI_GREY_BG + " ");
                } else if ("M".equals(status)) {
                    System.out.print(ANSI_RED + status + ANSI_GREY_BG + " ");
                } else if ("3".equals(status)) {
                    System.out.print(ANSI_RED + status + ANSI_GREY_BG + " ");
                } else {
                    System.out.print(status + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * toString
     *
     * @return String The string that is returned only has the squares that has been revealed to the user or that the user has guessed.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("  ");
        for (int i = 0; i < this.col; i++) {
            result.append(i % 10).append(" ");
        }
        result.append("\n");

        // Print rows
        for (int row = 0; row < this.row; row++) {
            result.append(row % 10).append(" ");
            for (int col = 0; col < this.col; col++) {
                Cell cell = minefield[row][col];
                if (flagged[row][col]) {
                    result.append("F").append(" ");
                } else if (cell.getRevealed()) {
                    String status = cell.getStatus();
                    if ("1".equals(status)) {
                        result.append(ANSI_BLUE).append(status).append(ANSI_GREY_BG).append(" ");
                    } else if ("0".equals(status)) {
                        result.append(ANSI_YELLOW).append(status).append(ANSI_GREY_BG).append(" ");
                    } else if ("2".equals(status)) {
                        result.append(ANSI_GREEN).append(status).append(ANSI_GREY_BG).append(" ");
                    } else if ("M".equals(status)) {
                        result.append(ANSI_RED).append(status).append(ANSI_GREY_BG).append(" ");
                    } else if ("3".equals(status)) {
                        result.append(ANSI_RED).append(status).append(ANSI_GREY_BG).append(" ");
                    } else {
                        result.append(status).append(" ");
                    }
                } else {
                    result.append("-").append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}