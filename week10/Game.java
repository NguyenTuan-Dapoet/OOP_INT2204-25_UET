package com.example.week10;

import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Move> moveHistory;

    public Game(Board board) {
        this.board = board;
        this.moveHistory = new ArrayList<Move>();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (board.validate(x, y)) {
            if (piece.canMove(board, x, y)) {
                Piece destinationPiece = board.getAt(x, y);
                if (destinationPiece != null) {
                    // Nếu có quân cờ tại vị trí đích, thêm nước đi ăn quân vào lịch sử
                    Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece, destinationPiece);
                    moveHistory.add(move);
                    // Xóa quân cờ đích khỏi bàn cờ
                    board.removeAt(x, y);
                } else {
                    // Nếu vị trí đích trống, thêm nước đi thông thường vào lịch sử
                    Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(), x, y, piece);
                    moveHistory.add(move);
                }
                // Di chuyển quân cờ
                piece.setCoordinatesX(x);
                piece.setCoordinatesY(y);
            }
        }
    }
}
