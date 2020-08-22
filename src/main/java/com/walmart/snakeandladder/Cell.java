/*
 * Created on 25-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.walmart.snakeandladder;

public class Cell {

    private int cellNo;
    private boolean hasSnake;
    private boolean hasLadder;
    private Snake snake;
    private Ladder ladder;

    public Cell(int cellNo) {
        this.cellNo = cellNo;
    }

    public int getCellNo() {

        return cellNo;
    }

    public void setCellNo(int cellNo) {

        this.cellNo = cellNo;
    }

    public boolean isHasSnake() {

        return hasSnake;
    }

    public void setHasSnake(boolean hasSnake) {

        this.hasSnake = hasSnake;
    }

    public boolean isHasLadder() {

        return hasLadder;
    }

    public void setHasLadder(boolean hasLadder) {

        this.hasLadder = hasLadder;
    }

    public Snake getSnake() {

        return snake;
    }

    public void setSnake(Snake snake) {

        this.snake = snake;
    }

    public Ladder getLadder() {

        return ladder;
    }

    public void setLadder(Ladder ladder) {

        this.ladder = ladder;
    }

}
