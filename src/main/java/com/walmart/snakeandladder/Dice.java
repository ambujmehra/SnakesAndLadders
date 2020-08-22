/*
 * Created on 25-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.walmart.snakeandladder;

import java.util.Random;

public class Dice {

    private int value;

    public int getValue() {

        Random r = new Random();
        int Low = 1;
        int High = 7;
        return r.nextInt(High - Low) + Low;

    }

}
