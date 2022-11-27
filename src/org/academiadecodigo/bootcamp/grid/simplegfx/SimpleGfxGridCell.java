package org.academiadecodigo.bootcamp.grid.simplegfx;

import org.academiadecodigo.bootcamp.grid.Cell;
import org.academiadecodigo.bootcamp.ui.Renderable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * Cell for usage with the Simple Graphics library
 */
public class SimpleGfxGridCell extends Cell {

    private SimpleGfxGrid grid;
    private Rectangle frame;

    /**
     * Create a new cell for usage with the Simple Graphics library
     * @param row the new cell row
     * @param col the new cell col
     */
    public SimpleGfxGridCell(int row, int col) {
        super(row, col);
    }

    /**
     * @see Cell#render()
     */
    @Override
    public void render() {

        if (frame == null) {
            frame = new Rectangle(
                    grid.getCanvasMargin() + grid.getCellSize() * getCol(), // x
                    grid.getCanvasMargin() + grid.getCellSize() * getRow(), // y
                    grid.getCellSize(), // width
                    grid.getCellSize()); // height
        }

        if (isSelected()) {
            frame.fill();
        } else {
            frame.draw();
        }

    }

    public void setGrid(SimpleGfxGrid grid) {
        this.grid = grid;
    }
}
