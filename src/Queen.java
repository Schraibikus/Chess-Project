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

        return false;
    }

    public String getSymbol() {
        return "Q";
    }
}