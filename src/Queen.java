public class Queen extends ChessPiece{
    public Queen(String color) {
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

        int queenMoveX = Math.abs(line-toLine);
        int queenMoveY = Math.abs(column-toColumn);

        if (queenMoveX == queenMoveY) return true;
        if (queenMoveX <= 7 &&  toColumn == column) return true;
        if (queenMoveY <= 7 && toLine == line) return true;
        else return false;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }
}
