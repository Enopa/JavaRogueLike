/***************************
This class will be used to 
create the middle panels
on the GUI. This acts like a 
log for the players actions.
Displays anything the player 
performs and acts a confirmation 
for their actions
***************************/

import java.awt.*;
import java.awt.event.*;

class MidPanel extends Panel
{
    //This text area will consistently be appended to add new actions
    TextArea info;
    public MidPanel(Frame f)
    {
        info = new TextArea(10, 20);
        info.setEditable(false);
        //Initially holds information about the classes
        info.setText(
            "---CLASSES---\n\n" +
            "KNIGHT\n" +
            "HP: 100\n" +
            "STR: 2\n" +
            "DEF: 2\n" +
            "Well Balanced. Shop discounts and has more money\n" +
            "\n" +
            "BARBARIAN\n" +
            "HP: 50\n" +
            "STR: 5\n" +
            "DEF: 1\n" +
            "High attack but low health. Has two weapons and deals a lot of damage.\n" +
            "\n" +
            "JUGGERNAUT\n" +
            "HP: 150\n" +
            "STR: 1\n" +
            "DEF: 5\n" +
            "High Defense but low attack. Can resist a lot of damage\n" 
        );
        f.add(info);
    }
}