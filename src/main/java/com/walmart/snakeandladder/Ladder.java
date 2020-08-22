/*
 * Created on 25-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.walmart.snakeandladder;

public class Ladder implements Piece {

    private Cell toCell;
    private Cell fromCell;

    public Ladder(Cell fromCell, Cell toCell) {
        this.toCell = toCell;
        this.fromCell = fromCell;
    }

    public Cell getNextPos() {

        // TODO Auto-generated method stub
        return toCell;
    }

    public Cell getToCell() {

        return toCell;
    }

    public void setToCell(Cell toCell) {

        this.toCell = toCell;
    }

    public Cell getFromCell() {

        return fromCell;
    }

    public void setFromCell(Cell fromCell) {

        this.fromCell = fromCell;
    }

}
