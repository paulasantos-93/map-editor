package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridCursor;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MapEditor implements KeyboardHandler {

    private Grid grid;
    private GridCursor cursor;
    private FileHelper fileHelper;
    private Keyboard keyboard;

    public MapEditor(Grid grid) {
        this.grid = grid;
    }

    public void setFileHelper(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
        setupKeyboard();
    }

    public void setCursor(GridCursor cursor) {
        this.cursor = cursor;
        cursor.setGrid(grid);
    }

    public void start() {

        grid.render();

        if (cursor != null) {
            cursor.render();
        }

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            fileHelper.saveRepresentation(grid);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            grid.updateCells(fileHelper.loadRepresentation());
            cursor.render();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    private void setupKeyboard() {

        keyboard = new Keyboard(this);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);

    }
}
