public class Board {

    // Instance variables
    private Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        board = new Piece[8][8];
    }
    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move
    // is legal, and to execute the move if it is. Your Game class should not 
    // directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (board[startRow][startCol] != null){
            if (board[startRow][startCol].isMoveLegal(this, endRow, endCol)){
                board[startRow][startCol].setPosition(endRow,endCol);
                board[endRow][endCol] = board[startRow][startCol];
                board[startRow][startCol] = null;

                return true;
            }
        }
        return false;
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        char wKing = '\u2654';
        char bKing = '\u265a';
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getCharacter() == wKing || board[i][j].getCharacter() == bKing) {
                        count += 1;
                    }
                }
            }
        }
        if (count < 2){
            return true;
        }else {
            return false;
        }
    }

    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        StringBuilder result = new StringBuilder();
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < 8; i++) {
            result.append(i);
            result.append("|");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    result.append('\u2000');
                    result.append("|");
                } else {
                    result.append(board[i][j]);
                    result.append("|");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }


    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                board[i][j] = null;
            }
        }

    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if ((startRow <= 7) && (endRow <= 7) && (startRow >= 0) && (endRow >= 0) && (startCol <= 7) && (endCol <= 7) && (startCol >= 0) && (endCol >= 0)) {
            if (board[startRow][startCol] != null) {
                if (board[endRow][endCol] == null || board[endRow][endCol].getIsBlack() != isBlack) {
                    if (board[startRow][startCol].getIsBlack() == isBlack) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if ((Math.abs(endRow - startRow) <= 1) && (Math.abs(endCol - startCol) <= 1)) {
            return true;
        }
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow != endRow) {
            return false;
        }
        int startColIdx = Math.min(startCol, endCol) + 1;
        int endColIdx = Math.max(startCol, endCol) - 1;
        for (int i = startColIdx; i <= endColIdx; i++){
            if (board[startRow][i] != null){
                return false;
            }
        }
        return true;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol != endCol){
            return false;
        }
        int startRowIdx = Math.min(startRow, endRow) + 1;
        int endRowIdx = Math.max(startRow, endRow) - 1;
        for (int i = startRowIdx; i <= endRowIdx; i++){
            if (board[i][startCol] != null){
                return false;
            }
        }
        return true;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);
        if (rowDiff != colDiff) {
            return false;
        }
        int rowDir = 1;
        if (endRow < startRow) {
            rowDir = -1;
        }
        int colDir = 1;
        if (endCol < startCol) {
            colDir = -1;
        }
        for (int i = 1; i < rowDiff; i++) {
            int row = startRow + (i * rowDir);
            int col = startCol + (i * colDir);
            if (board[row][col] != null) {
                return false;
            }
        }
        return true;
    }
}
