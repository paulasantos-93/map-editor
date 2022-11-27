package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.CellFactory;
import org.academiadecodigo.bootcamp.ui.Renderable;
import org.academiadecodigo.bootcamp.ui.Representable;
import org.academiadecodigo.bootcamp.ui.UserInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * A grid which is a container of Cells,
 * capable of render itself on the console
 * and represent itself as a string of text
 */
public class Grid implements Representable, Renderable {

    private final List<Cell> cells = new ArrayList<>();
    private CellFactory cellFactory;

    private final int rows;
    private final int cols;

    /**
     * Create a new grid of a specific size
     * @param rows the number of rows for the new grid
     * @param cols the number of columns for the new grid
     */
    public Grid(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
    }

    /**
     * @see Representable#getRepresentation()
     */
    @Override
    public String getRepresentation() {

        StringBuilder stringBuilder = new StringBuilder("");

        for (Representable representable : cells) {
            stringBuilder.append(representable.getRepresentation());
        }

        return stringBuilder.toString();
    }

    /**
     * Populate the grid with cells
     */
    public void init() {

        // make sure the grid is setup with the correct cell factory
        if (getCellFactory().getUserInterface() != UserInterface.CONSOLE) {
            throw new IllegalStateException("wrong factory type for this grid");
        }

        for (int i = 0; i < this.rows * this.cols; i++) {
            cells.add(cellFactory.makeCell(i / this.cols, i % cols));
        }
    }

    /**
     * @see Renderable#render()
     */
    @Override
    public void render() {

        // perform lazy instantiation of cells
        if (cells.isEmpty()) {
            init();
        }

        // iterate and render each individual cell
        for (int i = 0; i < cells.size(); i++) {
           cells.get(i).render();

           // a newline is required for proper grid formatting
           if (i % getCols() == getCols() - 1) {
               System.out.println("");
           }
        }

    }

    public Cell getGridCell(Cell cell) {
        return cells.get(cell.getCol() + cell.getRow() * rows);
    }

    /**
     * Toggles the selected state of the cell which position
     * matches the cursor position
     * @param cursor the cursor used to obtain the cell position to toggle
     */
    public void toggleCell(CellCursor cursor) {

        Cell cell = getGridCell(cursor);

        if (cell.isSelected()) {
            cell.unSelect();
        } else {
            cell.select();
        }

    }

    /**
     * Update the selected state of each cell in the grid to match
     * a specific grid representation
     * @param representation the grid textual representation
     */
    public void updateCells(String representation) {

        String[] cellRepresentations = representation.split("");
        int numOfUpdates = Math.min(cellRepresentations.length, cells.size());

        for (int i = 0; i < numOfUpdates; i++) {

            if (cellRepresentations[i].equals(Cell.SELECTED_REPRESENTATION)) {
                cells.get(i).select();
            } else {
                cells.get(i).unSelect();
            }

        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCellFactory(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    public CellFactory getCellFactory() {
        return cellFactory;
    }
}
