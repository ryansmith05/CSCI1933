import java.util.Scanner;

public class Piece {

    // Instance variables
    private char character;
    private int row;
    private int col;
    private boolean isBlack;

    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            // Pawn chars
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            // Rook chars
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            // Knight chars
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            // Bishop chars
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            // Queen chars
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            // King chars
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the current chess unicode character.
     * @return Unicode character.
     */
    public char getCharacter(){
        return this.character;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        return this.isBlack;
    }

    /**
     * Tests the equality of two Piece objects based on
     * their character parameter.
     * @param other An instance of Piece to compare with this
     *              instance.
     * @return Boolean value representing equality result.
     */
    public boolean equals(Piece other){
        return this.character == other.character;
    }

    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return "" + this.character;
    }

    public void pawnPromotion(int row, boolean isBlack) {
        if ((this.character == '\u2659') || (this.character == '\u265f')){
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Choose your promotion: Queen, Bishop, Rook, Knight");
            String input = myScanner.nextLine();
            if(isBlack && row == 7){
                if(input.equals("Queen")){
                    character = '\u265b';
                    Queen Queen = new Queen(row, col, true);
                    System.out.println("Pawn has been promoted");
                }else if(input.equals("Rook")) {
                    character = '\u265c';
                    Rook Rook = new Rook(row, col, true);
                    System.out.println("Pawn has been promoted");
                }else if(input.equals("Bishop")) {
                    character = '\u265d';
                    Bishop BIshop = new Bishop(row, col, true);
                    System.out.println("Pawn has been promoted");
                }else if(input.equals("Knight")) {
                    character = '\u265e';
                    Knight Knight = new Knight(row, col, true);
                    System.out.println("Pawn has been promoted");
                }
            }
            if (!isBlack && row == 0) {
                if (input.equals("Queen")) {
                    character = '\u2655';
                    Queen Queen = new Queen(row, col, false);
                    System.out.println("Pawn has been promoted");
                } else if (input.equals("Rook")) {
                    character = '\u2656';
                    Rook Rook = new Rook(row, col, false);
                    System.out.println("Pawn has been promoted");
                } else if (input.equals("Bishop")) {
                    character = '\u2657';
                    Bishop Bishop = new Bishop(row, col, false);
                    System.out.println("Pawn has been promoted");
                } else if (input.equals("Knight")) {
                    character = '\u2658';
                    Knight Knight = new Knight(row, col, false);
                    System.out.println("Pawn has been promoted");
                }
            }
        }
    }
}
