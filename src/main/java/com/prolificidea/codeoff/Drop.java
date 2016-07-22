package com.prolificidea.codeoff;

import static com.prolificidea.codeoff.Config.*;
import java.awt.*;
import java.util.Random;

public class Drop {

    private Random rng = new Random();
    private int velocity, length, x, y;
    private char[][] text;

    Drop(int x) {
        this.x = x;
        length = getRandomInteger(10, 50); //5, 30
        text = createContent(length);
        velocity = getRandomInteger(3, 10);
        this.y = (-1) * length * Config.FONT_SIZE;
    }
    
    protected char[][] createContent(int length) {
        char[][] result = new char[length][1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = getRandomCharacter();
        }
        return result;
    }

    public void draw(Graphics2D g2) {
        int fontSize = g2.getFont().getSize();
        for (int i = 0; i < length; i++) {
            if (getRandomInteger(0, length) == i)
                text[i][0] = getRandomCharacter();
            if (i == length - 1) //first char
                g2.setColor(COLOR_START);
            else if (isStageOne())
                g2.setColor(COLOR_STAGE_ONE);
            else if (isStageTwo())
                g2.setColor(COLOR_STAGE_TWO);
            else if (isStageThree())
                g2.setColor(COLOR_STAGE_THREE);
            else if (isStageFour())
                g2.setColor(COLOR_STAGE_FOUR);
            else if (isStageFive())
                g2.setColor(COLOR_STAGE_FIVE);
            else //string
                g2.setColor(COLOR_DEFAULT);
            g2.drawChars(text[i], 0, 1, x, y + (i * fontSize));
        }
        y += velocity;
    }
    
    public char getRandomCharacter() {
        return (char) (rng.nextInt(26) + 'a');
    }

    public int getRandomInteger(int min, int max) {
        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean isOffScreen() {
        return (y > SCREEN_HEIGHT);
    }

    private boolean isStageOne() {
        return (y < 0);
    }

    private boolean isStageTwo() {
        return (y > 0 && y < 200);
    }

    private boolean isStageThree() {
        return (y > 200 && y < 400);
    }

    private boolean isStageFour() {
        return (y > 400 && y < 600);
    }

    private boolean isStageFive() {
        return (y > 600 && y < 800);
    }
}