package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.grid.CellCursor;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.bootcamp.grid.simplegfx.SimpleGfxGridCursor;
import org.academiadecodigo.bootcamp.ui.UserInterface;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();

        main.runSimpleGfxMapEditor();
        main.runCharMapEditor();

    }

    public void runSimpleGfxMapEditor() throws InterruptedException {

        CellFactory cellFactory = new CellFactory(UserInterface.SGFX);
        CellCursor cursor = new SimpleGfxGridCursor(0, 0);
        FileHelper fileHelper = new FileHelper("resources/grid.txt");
        Grid grid = new SimpleGfxGrid(20, 20);
        grid.setCellFactory(cellFactory);

        MapEditor mapEditor = new MapEditor(grid);
        mapEditor.setCursor(cursor);
        mapEditor.setFileHelper(fileHelper);
        mapEditor.start();

        grid.toggleCell(cursor);
        cursor.moveDown();
        grid.toggleCell(cursor);
        cursor.moveDown();
        grid.toggleCell(cursor);
        cursor.moveRight();
        grid.toggleCell(cursor);
        cursor.moveRight();
        grid.toggleCell(cursor);
        cursor.moveUp();
        grid.toggleCell(cursor);
        cursor.moveUp();
        grid.toggleCell(cursor);
    }

    public void runCharMapEditor() throws InterruptedException {

        CellFactory cellFactory = new CellFactory(UserInterface.CONSOLE);
        CellCursor cursor = new CellCursor(0, 0);
        Grid grid = new Grid(20, 20);
        grid.setCellFactory(cellFactory);
        cursor.setGrid(grid);

        MapEditor mapEditor = new MapEditor(grid);
        mapEditor.start();

        System.out.println();
        grid.toggleCell(cursor);
        cursor.moveDown();
        grid.toggleCell(cursor);
        cursor.moveDown();
        grid.toggleCell(cursor);
        cursor.moveRight();
        grid.toggleCell(cursor);
        cursor.moveRight();
        grid.toggleCell(cursor);
        cursor.moveUp();
        grid.toggleCell(cursor);
        cursor.moveUp();
        grid.toggleCell(cursor);

        grid.render();

    }
}
