package com.prolificidea.codeoff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Config {
    
    //screen constants
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();
    public static final int SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();
    public static int FONT_SIZE = 16;

    //colors
    public static Color COLOR_START = new Color(255, 255, 255); //white
    public static Color COLOR_DEFAULT = new Color(0,0,255); //blue
    public static Color COLOR_STAGE_ONE = new Color(240,248,255);
    public static Color COLOR_STAGE_TWO = new Color(135,206,250);
    public static Color COLOR_STAGE_THREE = new Color(66, 198, 255);
    public static Color COLOR_STAGE_FOUR = new Color(0,191,255);
    public static Color COLOR_STAGE_FIVE = new Color(30,144,255);
}
