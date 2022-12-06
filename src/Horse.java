//public class Horse extends ChessPiece {
//    public Horse(String color) {
//        super(color);
//    }
//
//    @Override
//    public String getColor() {
//        return color;
//    }
//
//    @Override
//    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
//        if (toLine < 0 || line < 0 || toLine > 7 || line > 7
//                || toColumn < 0 || column < 0 || toColumn > 7 || column > 7) return false;
//        if (toLine == line && toColumn == column) return false;
//
//        int horseMoveX = Math.abs(line - toLine);
//        int horseMoveY = Math.abs(column - toColumn);
//        int z = Math.abs((line + column) - (toLine + toColumn));
//
//        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color))
//             {
//                 System.out.println("Клетка занята союзником.");
//            if (horseMoveX == 1 || horseMoveX == 2 && horseMoveY == 2 || horseMoveY == 1); return true;
//        } else return false;
//
////        if (horseMoveX == 1 || horseMoveX == 2 && horseMoveY == 2 || horseMoveY == 1) {
////            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color))
////                System.out.println("Клетка занята союзником."); return false;
////        } else return true;
//    }
//
//    @Override
//    public String getSymbol() {
//        return "H";
//    }
//}
public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPos(line) && this.checkPos(column) && this.checkPos(toLine) && this.checkPos(toColumn)) {
            if (line != toLine && column != toColumn && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) && chessBoard.board[line][column] != null) {
                if (!chessBoard.board[line][column].equals(this)) {
                    return false;
                }

                int[][] positions = new int[][]{{line - 2, column - 1}, {line - 2, column + 1}, {line + 2, column - 1}, {line + 2, column + 1}, {line - 1, column - 2}, {line - 1, column + 2}, {line + 1, column - 2}, {line + 1, column + 2}};

                for(int i = 0; i < positions.length; ++i) {
                    if (positions[i][0] == toLine && positions[i][1] == toColumn) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "H";
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
