package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.ui.Representable;

/**
 * A Cell capable of moving itself within a grid
 */
public class CellCursor extends Cell implements GridCursor {

    public static final String SELECTED_REPRESENTATION = "#";
    public static final String UNSELECTED_REPRESENTATION = "O";

    private Grid grid;

    /**
     * @see Cell#Cell(int, int)
     */
    public CellCursor(int row, int col) {
        super(row, col);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * @see Representable#getRepresentation()
     */
    @Override
    public String getRepresentation() {
        return isSelected() ? CellCursor.SELECTED_REPRESENTATION : CellCursor.UNSELECTED_REPRESENTATION;
    }

    /**
     * @see GridCursor#moveUp()
     */
    @Override
    public void moveUp() {

        int row = getRow() - 1;
        setRow(row > 0 ? row : 0);

    }

    /**
     * @see GridCursor#moveDown()
     */
    @Override
    public void moveDown() {

        int row = getRow() + 1;
        setRow(row < grid.getRows() - 1 ? row : grid.getRows() - 1);

    }

    /**
     * @see GridCursor#moveLeft()
     */
    @Override
    public void moveLeft() {

        int col = getCol() - 1;
        setCol(col > 0 ? col : 0);

    }

    /**
     * @see GridCursor#moveRight()
     */
    @Override
    public void moveRight() {

        int col = getCol() + 1;
        setCol(col < grid.getCols() - 1 ? col : grid.getCols() - 1);

    }

}
