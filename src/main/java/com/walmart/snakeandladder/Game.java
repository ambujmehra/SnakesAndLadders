/*
 * Created on 25-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.walmart.snakeandladder;

import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Board board = new Board.Builder().makeCells().setPlayerA().setPlayerB().setSnakes()
                .setLadders().build();
        System.out.println("----------Players--------------");
        System.out.println(board.getPlayerA().getCurCell().getCellNo());
        System.out.println(board.getPlayerB().getCurCell().getCellNo());
        System.out.println("----------Ladders--------------");

        ArrayList<Ladder> l = (ArrayList<Ladder>) board.getLadders();
        for (int i = 0; i < l.size(); i++) {
            System.out.println(
                    l.get(i).getFromCell().getCellNo() + " " + l.get(i).getToCell().getCellNo());
        }

        System.out.println("----------Snakes--------------");
        ArrayList<Snake> s = (ArrayList<Snake>) board.getSnakes();
        for (int i = 0; i < s.size(); i++) {
            System.out.println(
                    s.get(i).getFromCell().getCellNo() + " " + s.get(i).getToCell().getCellNo());
        }
        System.out.println("----------Game--------------");
        boolean flag = true;
        Dice d = new Dice();
        while (board.getPlayerA().getCurCell().getCellNo() != 99
                || board.getPlayerB().getCurCell().getCellNo() != 99) {
            if (flag) {
                int val = d.getValue();
                System.out.print("PlayerA->" + board.getPlayerA().getCurCell().getCellNo());

                int nextcell = board.getNextCellNo(val, board.getPlayerA());
                if (nextcell == 99) {
                    System.out.println();
                    System.out.println("Player A won!!!!!!");
                    break;
                } else if (nextcell == -1) {
                    flag = !flag;
                    continue;
                }

                board.getPlayerA().setCurCell(board.getListOfCell().get(nextcell));
                System.out.println(" " + board.getPlayerA().getCurCell().getCellNo());
            } else {
                int val = d.getValue();
                System.out.print("PlayerB->" + board.getPlayerB().getCurCell().getCellNo());

                int nextcell = board.getNextCellNo(val, board.getPlayerB());
                if (nextcell == 99) {
                    System.out.println();

                    System.out.println("Player B won!!!!!!");
                    break;
                } else if (nextcell == -1) {
                    flag = !flag;
                    continue;
                }

                board.getPlayerB().setCurCell(board.getListOfCell().get(nextcell));
                System.out.println(" " + board.getPlayerB().getCurCell().getCellNo());

            }
            flag = !flag;
        }

    }

}
