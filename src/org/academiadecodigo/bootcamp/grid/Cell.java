package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.ui.Renderable;
import org.academiadecodigo.bootcamp.ui.Representable;

/**
 * A class representing a position in a grid,
 * capable of render itself to the console
 * represent itself as a string of text
 */
public class Cell implements Representable, Renderable {

    public static final String SELECTED_REPRESENTATION = "1";
    public static final String UNSELECTED_REPRESENTATION = "0";

    private boolean selected = false;
    private int col;
    private int row;

    /**
     * Create a new cell at a specific position
     * @param row the new cell row
     * @param col the new cell col
     */
    public Cell(int row, int col) {

        this.row = row;
        this.col = col;

    }

    /**
     * @see Representable#getRepresentation()
     */
    @Override
    public String getRepresentation() {
        return selected ? Cell.SELECTED_REPRESENTATION: Cell.UNSELECTED_REPRESENTATION;
    }

    /**
     * @see Renderable#render()
     */
    @Override
    public void render() {
        System.out.print(getRepresentation());
    }

    public void select() {
        selected = true;
    }

    public void unSelect() {
        selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "selected=" + selected +
                ", row=" + row +
                ", col=" + col +
                '}';
    }
}
