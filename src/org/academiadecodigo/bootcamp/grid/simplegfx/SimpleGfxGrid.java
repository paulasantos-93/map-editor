package org.academiadecodigo.bootcamp.grid.simplegfx;

import org.academiadecodigo.bootcamp.grid.Cell;
import org.academiadecodigo.bootcamp.grid.CellCursor;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.ui.Renderable;
import org.academiadecodigo.bootcamp.ui.UserInterface;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Grid for usage with the Simple Graphics library
 */
public class SimpleGfxGrid extends Grid {

    private int canvasMargin = 10;
    private int cellSize = 20;
    private Rectangle frame;

    /**
     * Constructs a new Grid for usage with the Simple Graphics library
     * @param rows the number for rows of the grid
     * @param cols the number of columns of the grid
     */
    public SimpleGfxGrid(int rows, int cols) {
        super(rows, cols);
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {

        // make sure the grid is setup with the correct cell factory
        if (getCellFactory().getUserInterface() != UserInterface.SGFX) {
            throw new IllegalStateException("wrong factory type for this grid");
        }

        for (int i = 0; i < getRows() * getCols(); i++) {
            SimpleGfxGridCell cell = (SimpleGfxGridCell) getCellFactory().makeCell(i / getCols(), i % getCols());
            cell.setGrid(this);
            getCells().add(cell);
        }
    }

    /**
     * @see Renderable#render()
     */
    @Override
    public void render() {

        if (getCells().isEmpty()) {
            init();
        }

        drawCanvas();
        drawCells();
    }

    /**
     * @see Grid#toggleCell(CellCursor)
     */
    @Override
    public void toggleCell(CellCursor cursor) {
        super.toggleCell(cursor);
        getGridCell(cursor).render();
        cursor.render();
    }

    /**
     * @see Grid#updateCells(String)
     */
    @Override
    public void updateCells(String representation) {
        super.updateCells(representation);
        render();
    }

    public int getCanvasMargin() {
        return canvasMargin;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public String toString() {
        return "SimpleGfxGrid{" +
                "canvasMargin=" + canvasMargin +
                ", cellSize=" + cellSize +
                "} " + super.toString();
    }

    private void drawCanvas() {

        if (frame == null) {
            frame = new Rectangle(this.canvasMargin, // x
                    this.canvasMargin, // y
                    getRows() * this.cellSize, // width
                    getCols() * this.cellSize); // height
        }

        frame.draw();
    }

    private void drawCells() {
        for (Cell cell : getCells()) {
            cell.render();
        }
    }
}
