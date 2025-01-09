import java.util.Scanner;
public class Game {
    public static void main(String args[]) {
        Scanner myScanner = new Scanner(System.in);
        Board myBoard = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard);
        //int counter = 0;
        boolean isBlack = false;

        while (!myBoard.isGameOver()) {
            System.out.println(myBoard);

            int startRow, startCol, endRow, endCol;
            while (true) {
                System.out.println("It is currently " + ((isBlack) ? "black" : "whites") + "'s turn to play");
                System.out.println(((isBlack) ? "Black" : "White") + " team, enter the desired start row and column and end row and column");
                startRow = myScanner.nextInt();
                startCol = myScanner.nextInt();
                endRow = myScanner.nextInt();
                endCol = myScanner.nextInt();
                if ((myBoard.getPiece(startRow, startCol) == null) || (myBoard.getPiece(startRow, startCol).getIsBlack() != isBlack) ||
                        !myBoard.movePiece(startRow, startCol, endRow, endCol)) {
                    System.out.println("Invalid move, try again");
                    continue;
                }break;
            }if(myBoard.getPiece(endRow, endCol).getCharacter() == '\u2659' || myBoard.getPiece(endRow, endCol).getCharacter() == '\u265f' ) {
                if ((endRow == 7) || (endRow == 0)) {
                    myBoard.getPiece(endRow, endCol).pawnPromotion(endRow, isBlack);
                }
            }

            isBlack = !isBlack;
        }
        System.out.println(myBoard);
        System.out.println("Congratulations team " + ((isBlack) ? "black" : "white") + ", you have won the game!");
    }
}
