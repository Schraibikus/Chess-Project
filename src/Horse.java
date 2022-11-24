public class Horse extends ChessPiece {
    public Horse(String color) {
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

        int horseMoveX = Math.abs(line - toLine);
        int horseMoveY = Math.abs(column - toColumn);

        if (horseMoveX == 1 || horseMoveX == 2 && horseMoveY == 2 || horseMoveY == 1) {
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color))
                System.out.println("Клетка занята союзником.");
                return false;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
