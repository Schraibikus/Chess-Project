//public class Pawn extends ChessPiece{
//    public Pawn(String color) {
//        super(color);
//    }
//
//    @Override
//    public String getColor() {
//        return color;
//    }
//    @Override
//    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
//        if (toLine < 0 || line < 0 || toLine > 7 || line > 7
//                || toColumn < 0 || column < 0 || toColumn > 7 || column > 7) return false;
//        if (toLine == line && toColumn == column) return false;
//
//        int pawnMove = Math.abs(line-toLine);
//
//        if (color.equals("White")){
//            if (line == 1){
//                if (pawnMove == 2 && toColumn == column) return true;
//            } else return false;
//            if (pawnMove == 1 && toColumn == column) return true;
//            else return false;
//        }
//        if (color.equals("Black")){
//            if (line == 6){
//                if (pawnMove == 2 && toColumn == column) return true;
//            } else return false;
//            if (pawnMove == 1 && toColumn == column) return true;
//            else return false;
//        } else return false;
//    }
//    @Override
//    public String getSymbol() {
//        return "P";
//    }
//}
public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPos(line) && this.checkPos(column) && this.checkPos(toLine) && this.checkPos(toColumn) && chessBoard.board[line][column] != null) {
            if (column != toColumn) {
                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1) && chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
                }

                return false;
            }

            byte dir;
            byte start;
            if (this.color.equals("White")) {
                dir = 1;
                start = 1;
            } else {
                dir = -1;
                start = 6;
            }

            if (line + dir == toLine) {
                return chessBoard.board[toLine][toColumn] == null;
            }

            if (line == start && line + 2 * dir == toLine) {
                return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][column] == null;
            }
        }

        return false;
    }

    public String getSymbol() {
        return "P";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}