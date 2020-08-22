/*
 * Created on 25-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.walmart.snakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private Player playerA;
    private Player playerB;
    private List<Cell> listOfCell;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public static class Builder {

        private Player playerA;
        private Player playerB;
        private List<Cell> listOfCell;
        private List<Snake> snakes;
        private List<Ladder> ladders;

        private int randomSnakesLadder() {

            Random r = new Random();
            int Low = 5;
            int High = 10;
            return r.nextInt(High - Low) + Low;
        }

        private int randomSnakeCellNo() {

            Random r = new Random();
            int Low = 20;
            int High = 80;
            return r.nextInt(High - Low) + Low;
        }

        public Builder makeCells() {

            listOfCell = new ArrayList<Cell>();
            for (int i = 0; i < 100; i++) {
                listOfCell.add(new Cell(i));
            }
            return this;
        }

        public Builder setPlayerA() {

            playerA = new Player(listOfCell.get(0));
            return this;
        }

        public Builder setPlayerB() {

            playerB = new Player(listOfCell.get(0));
            return this;
        }

        public Builder setSnakes() {

            snakes = new ArrayList<Snake>();
            int noOfSnake = randomSnakesLadder();

            for (int i = 1; i <= noOfSnake; i++) {
                int startCell = randomSnakeCellNo();
                int endCell = randomSnakeCellNo();
                while (endCell >= startCell) {
                    endCell = randomSnakeCellNo();
                }
                Snake snake = new Snake(listOfCell.get(startCell), listOfCell.get(endCell));
                listOfCell.get(startCell).setHasSnake(true);
                listOfCell.get(startCell).setHasLadder(false);
                listOfCell.get(startCell).setSnake(snake);

                snakes.add(snake);
            }
            return this;
        }

        public Builder setLadders() {

            ladders = new ArrayList<Ladder>();
            int noOfLadder = randomSnakesLadder();

            for (int i = 1; i <= noOfLadder; i++) {

                int startCell = randomSnakeCellNo();
                while (listOfCell.get(startCell).isHasSnake() != false) {
                    startCell = randomSnakeCellNo();
                }
                int endCell = randomSnakeCellNo();
                while (endCell <= startCell) {
                    endCell = randomSnakeCellNo();
                }

                Ladder ladder = new Ladder(listOfCell.get(startCell), listOfCell.get(endCell));
                listOfCell.get(startCell).setHasSnake(false);
                listOfCell.get(startCell).setHasLadder(true);
                listOfCell.get(startCell).setLadder(ladder);
                ladders.add(ladder);
            }
            return this;
        }

        public Board build() {

            return new Board(this);
        }

    }

    private Board(Builder builder) {
        playerA = builder.playerA;
        playerB = builder.playerB;
        snakes = builder.snakes;
        ladders = builder.ladders;
        listOfCell = builder.listOfCell;
    }

    public int getNextCellNo(int d, Player p) {

        int curCell = p.getCurCell().getCellNo();
        // Cell cur = p.getCurCell();
        curCell += d;
        System.out.print(" " + curCell + " ");
        if (curCell > 99)
            return -1;

        if (listOfCell.get(curCell).isHasSnake()) {
            System.out.print(" I am bit by snake moving to cell no "
                    + listOfCell.get(curCell).getSnake().getToCell().getCellNo());
            curCell = listOfCell.get(curCell).getSnake().getNextPos().getCellNo();
        } else if (listOfCell.get(curCell).isHasLadder()) {
            System.out.print(" I have got ladder moving to cell no "
                    + listOfCell.get(curCell).getLadder().getToCell().getCellNo());

            curCell = listOfCell.get(curCell).getLadder().getNextPos().getCellNo();
        }
        return curCell;
    }

    public Player getPlayerA() {

        return playerA;
    }

    public void setPlayerA(Player playerA) {

        this.playerA = playerA;
    }

    public Player getPlayerB() {

        return playerB;
    }

    public void setPlayerB(Player playerB) {

        this.playerB = playerB;
    }

    public List<Cell> getListOfCell() {

        return listOfCell;
    }

    public void setListOfCell(List<Cell> listOfCell) {

        this.listOfCell = listOfCell;
    }

    public List<Snake> getSnakes() {

        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {

        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {

        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {

        this.ladders = ladders;
    }

}
