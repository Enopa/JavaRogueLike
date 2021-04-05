/***************************
This class contains the top panel
Typically will hold the player and
enemy stats
***************************/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TopPanel extends Panel
{
    //playerStat will typically hold player stats. Hold the introduction when program started
    JTextArea playerStat = new JTextArea(
    " Welcome to the Monster-Fight Game!\n" + 
    " You will be tasked to defeat monsters.\n" +
    " After each fight you will be given a weapon or potion\n" +
    " Use these to become strong enough to defeat the final boss!\n" +
    " Good Luck and Have Fun\n\n\n" +
    " FIRST YOU MUST CHOOSE YOUR CLASS\n" +
    " There are three classes, choose wisely..."
    ); 
    
    //Holds enemy stats and shop ASCII art
    JTextArea otherthing = new JTextArea("");
    public TopPanel(Frame f)
    {
        playerStat.setEditable(false);
        playerStat.setLineWrap(true); //Ensures there is no scrollbar, not needed for top panels
        otherthing.setEditable(false);
        otherthing.setLineWrap(true);
        Panel tp = new Panel();
        tp.setLayout(new GridLayout(0, 2));
        tp.add(playerStat);
        tp.add(otherthing);
        f.add(tp);
    }
    
    public void refresh(String output, String output2)
    {
        //Sets the text for the top two panels once again, needed in case a a stat changes and needs to be displayed
        playerStat.setText(output);
        otherthing.setText(output2);
    }
}