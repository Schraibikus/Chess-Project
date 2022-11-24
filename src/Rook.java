public class Rook extends ChessPiece{
    public Rook(String color) {
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

        int rookMoveX = Math.abs(line-toLine);
        int rookMoveY = Math.abs(column-toColumn);

        if (rookMoveX <= 7 &&  toColumn == column ||toLine == line) return true;
        else return false;
    }
    @Override
    public String getSymbol() {
        return "R";
    }
}
