/*
 * Created on 25-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.walmart.snakeandladder;

public class Player {

    private Cell curCell;

    public Player(Cell curCell) {
        this.curCell = curCell;
    }

    public Cell getCurCell() {

        return curCell;
    }

    public void setCurCell(Cell curCell) {

        this.curCell = curCell;
    }

}
