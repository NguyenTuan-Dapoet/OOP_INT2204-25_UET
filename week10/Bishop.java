package com.example.week10;

public class Bishop extends Piece {

    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }
    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int currentX = getCoordinatesX();
        int currentY = getCoordinatesY();

        if (Math.abs(currentX - x) == Math.abs(currentY - y)) {
            int deltaX = (x - currentX > 0) ? 1 : -1;
            int deltaY = (y - currentY > 0) ? 1 : -1;

            int nextX = currentX + deltaX;
            int nextY = currentY + deltaY;

            //đi từng ô
            while (nextX != x) {
                // Kiểm tra xem có quân cờ nào trên đường đi không
                if (board.getAt(nextX, nextY) != null) {
                    return false;
                }
                //cập nhật
                nextX += deltaX;
                nextY += deltaY;
            }

            // Kiểm tra nếu tại vị trí đích có quân cờ và màu khác (ăn quân) hoặc trống
            Piece destinationPiece = board.getAt(x, y);
            return destinationPiece == null || !destinationPiece.getColor().equals(getColor());
        }
        return false;
    }
}
