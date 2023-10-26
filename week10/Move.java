package com.example.week10;

import java.util.HashMap;

public class Move {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private Piece movedPiece;
    private Piece killedPiece;

    private HashMap<Integer, String> maps = new HashMap<Integer, String>() {
        {
            put(1, "a");
            put(2, "b");
            put(3, "c");
            put(4, "d");
            put(5, "e");
            put(6, "f");
            put(7, "g");
            put(8, "h");
        }
    };

    public Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    public Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }
    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public String toString() {
        String x = maps.get(this.endX);
        String y = Integer.toString(this.endY);
        String color = this.movedPiece.getColor();
        String symbol = this.movedPiece.getSymbol();
        return color + "-" + symbol + x + y;
    }

}
