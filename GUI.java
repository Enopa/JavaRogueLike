/***************************
This class will be used to create
menu within the game.
It contains the top panel, mid panel and bottom panel.
Keeps them organised and referencable from one point
***************************/

import java.awt.*;
import java.awt.event.*;

public class GUI extends Panel
{
    TopPanel top;
    MidPanel mid;
    BotPanel bot;
    
    public GUI(Frame f)
    {
        top = new TopPanel(f);
        mid = new MidPanel(f);
        bot = new BotPanel(f);  
    }
}