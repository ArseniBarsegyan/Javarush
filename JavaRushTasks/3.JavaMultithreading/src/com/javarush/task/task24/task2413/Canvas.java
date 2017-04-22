package com.javarush.task.task24.task2413;

/**
 * Created by arseniy.barsegyan on 21.04.2017.
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    void setPoint(double x, double y, char c) {
        if (x < 0 || y < 0 || y > matrix.length || x > matrix[0].length) {

        } else {
            int ix = (int) Math.round(x);
            int iy = (int) Math.round(y);
            matrix[iy][ix] = c;
        }
    }

    void drawMatrix(double x, double y, int[][]maxtrix, char c) {
        for (int i = 0; i < maxtrix.length; i++) {
            for (int j = 0; j < maxtrix[i].length; j++) {
                if (maxtrix[i][j] != 0) {
                    setPoint(x+j, y+i,c);
                }
            }
        }
    }
}
