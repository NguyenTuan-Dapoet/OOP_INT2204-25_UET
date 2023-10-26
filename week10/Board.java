package com.example.week10;

import java.util.ArrayList;

public class Board {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<Piece>();
    }

    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) == null) {
                pieces.add(piece);
            }
        }
    }

    public boolean validate(int x, int y) {
        return x >= 1 && x <= WIDTH && y >= 1 && y <= HEIGHT;
    }

    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                break;
            }
        }
    }

    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }
}
