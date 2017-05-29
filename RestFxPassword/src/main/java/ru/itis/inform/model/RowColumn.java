package ru.itis.inform.model;

/**
 * Created by Timur Mardanov on 24.05.2017.
 * ITIS
 */
public class RowColumn {
    public static int column;
    public static int row;

    public RowColumn(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
