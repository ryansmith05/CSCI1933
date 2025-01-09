public class Bishop {
    private int row;
    private int col;
    private boolean isBlack;
    public Bishop(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        //check color of piece and if space moving to is null
        if (board.verifySourceAndDestination(this.row, this.col, endRow, endCol, isBlack)){
            ////check if diagonal move is legal
            if (board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
                return true;
            }
        }
        return false;
    }
}
