package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.ui.Renderable;

/**
 * A cursor capable of moving freely inside a grid
 */
public interface GridCursor extends Renderable {

    /**
     * Moves this cursor one position up, making sure we stay within grid boundaries
     */
    void moveUp();

    /**
     * Moves this cursor one position down, making sure we stay within grid boundaries
     */
    void moveDown();

    /**
     * Moves this cursor one position left, making sure we stay within grid boundaries
     */
    void moveLeft();

    /**
     * Moves this cursor one position right, making sure we stay within grid boundaries
     */
    void moveRight();

    void setGrid(Grid grid);

    Grid getGrid();

}
