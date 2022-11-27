package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.Cell;
import org.academiadecodigo.bootcamp.grid.simplegfx.SimpleGfxGridCell;
import org.academiadecodigo.bootcamp.ui.UserInterface;

public class CellFactory {

    private UserInterface userInterface = UserInterface.CONSOLE;

    public CellFactory(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public Cell makeCell(int row, int col) {

        Cell cell;

        switch (userInterface) {
            case CONSOLE:
                cell = new Cell(row, col);
                break;
            case SGFX:
                cell = new SimpleGfxGridCell(row, col);
                break;
            default:
                cell = new Cell(row, col);
        }

        return cell;
    }

    public UserInterface getUserInterface() {
        return userInterface;
    }

}
