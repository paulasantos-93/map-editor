package org.academiadecodigo.bootcamp.grid.simplegfx;

import org.academiadecodigo.bootcamp.grid.Cell;
import org.academiadecodigo.bootcamp.grid.CellCursor;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.ui.Renderable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * A Cell cursor controllable with the keyboard for the Simple Graphics library
 */
public class SimpleGfxGridCursor extends CellCursor implements KeyboardHandler {

    private Rectangle frame;
    private Keyboard keyboard;
    private SimpleGfxGrid grid;

    /**
     * Creates a new CellCursor for the simple graphics library
     * @see Cell#Cell(int, int)
     */
    public SimpleGfxGridCursor(int row, int col) {
        super(row, col);
        setupKeyboard();
    }

    /**
     * @see Renderable#render()
     */
    @Override
    public void render() {

        if (frame == null) {
            frame = new Rectangle(grid.getCanvasMargin() + grid.getCellSize() * getCol(), // x
                    grid.getCanvasMargin() + grid.getCanvasMargin() * getRow(), // y
                    grid.getCellSize(), // width
                    grid.getCellSize()); // height
        }

        if (grid.getGridCell(this).isSelected()) {
            frame.setColor(Color.BLUE);
        } else {
            frame.setColor(Color.YELLOW);
        }

        frame.fill();

    }

    /**
     * @see KeyboardHandler#keyPressed(KeyboardEvent)
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                getGrid().toggleCell(this);
                break;
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;

            case KeyboardEvent.KEY_UP:
                moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;
        }

        render();
    }

    /**
     * @see KeyboardHandler#keyReleased(KeyboardEvent)
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    /**
     * @see CellCursor#moveDown()
     */
    @Override
    public void moveDown() {

        int prevRow = this.getRow();
        super.moveDown();
        frame.translate(0, (getRow() - prevRow) * grid.getCellSize());

    }

    /**
     * @see CellCursor#moveUp()
     */
    @Override
    public void moveUp() {

        int prevRow = this.getRow();
        super.moveUp();
        frame.translate(0, (getRow() - prevRow) * grid.getCellSize());

    }

    /**
     * @see CellCursor#moveLeft()
     */
    @Override
    public void moveLeft() {

        int prevCol = this.getCol();
        super.moveLeft();
        frame.translate((getCol() - prevCol) * grid.getCellSize(), 0);

    }

    /**
     * @see CellCursor#moveRight()
     */
    @Override
    public void moveRight() {

        int prevCol = this.getCol();
        super.moveRight();
        frame.translate((getCol() - prevCol) * grid.getCellSize(), 0);

    }

    /**
     * @see CellCursor#setGrid(Grid)
     */
    @Override
    public void setGrid(Grid grid) {

        super.setGrid(grid);

        if (!(grid instanceof SimpleGfxGrid)) {
            throw new IllegalArgumentException("simple graphics grid required");
        }

        this.grid = (SimpleGfxGrid) grid;
    }

    private void setupKeyboard() {

        keyboard = new Keyboard(this);

        KeyboardEvent toggle = new KeyboardEvent();
        toggle.setKey(KeyboardEvent.KEY_SPACE);
        toggle.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(toggle);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

    }

}
