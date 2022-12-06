//public class King extends ChessPiece{
//    public King(String color) {
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
//        int kingMoveX = Math.abs(line-toLine);
//        int kingMoveY = Math.abs(column-toColumn);
//
//        if (kingMoveX <= 1 && kingMoveY <= 1) return true;
//        else return false;
//    }
//    @Override
//    public String getSymbol() {
//        return "K";
//    }
//    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column){
//        for (int i = 0; i < 7; i++) {
//            for (int j = 0; j < 7; j++) {
//                if (chessBoard.board[i][j] != null){
//                    if (chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard,i,j,line,column)){
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}
public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (this.checkPos(line) && this.checkPos(column) && this.checkPos(toLine) && this.checkPos(toColumn)) {
            if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
                if (this.isUnderAttack(chessBoard, toLine, toColumn)) {
                    return false;
                } else if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (this.checkPos(line) && this.checkPos(column)) {
            for(int i = 0; i < 7; ++i) {
                for(int j = 0; j < 7; ++j) {
                    if (chessBoard.board[i][j] != null && !chessBoard.board[i][j].getColor().equals(this.color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}