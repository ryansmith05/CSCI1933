public class Queen {
    private int row;
    private int col;
    private boolean isBlack;
    public Queen(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        //check color of piece and if space moving to is null
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack))
            //check if vertical move is legal or horizontal move is legal or adjacent move is legal
            if (board.verifyVertical(this.row, this.col, endRow, endCol) || board.verifyHorizontal(this.row, this.col, endRow, endCol) ||
                    board.verifyAdjacent(this.row, this.col, endRow, endCol) || board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
                return true;
            }
        return false;
    }
}
