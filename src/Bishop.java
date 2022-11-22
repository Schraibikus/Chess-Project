public class Bishop extends ChessPiece{
    public Bishop(String color) {
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

        int bishopMoveX = Math.abs(line-toLine);
        int bishopMoveY = Math.abs(column-toColumn);

        if (bishopMoveX == bishopMoveY) return true;
        else return false;
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}
