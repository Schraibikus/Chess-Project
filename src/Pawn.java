public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || line < 0 || toLine > 7 || line > 7
                || toColumn < 0 || column < 0 || toColumn > 7 || column > 7) return false;
        if (toLine == line && toColumn == column) return false;

        int pawnMove = Math.abs(line-toLine);

        if (color.equals("White")){
            if (line == 1){
                if (pawnMove == 2 && toColumn == column) return true;
            } else return false;
            if (pawnMove == 1 && toColumn == column) return true;
            else return false;
        }
        if (color.equals("Black")){
            if (line == 6){
                if (pawnMove == 2 && toColumn == column) return true;
            } else return false;
            if (pawnMove == 1 && toColumn == column) return true;
            else return false;
        } else return false;
    }
    @Override
    public String getSymbol() {
        return "P";
    }
}
