/***************************
This class the bottom panel for
the game. This holds the 
buttons. These buttons can be updated
and changed as the program continues
***************************/

import java.awt.*;
import java.awt.event.*;

class BotPanel extends Panel implements ActionListener
{
    //The prompt value holds the question the player will be answering with the buttons
    TextArea prompt = new TextArea("Enter your name here");
    Panel choices = new Panel();
    Panel bp = new Panel();
    
    //choose is set to volatile due to threading issues
    //ensures the variable can be referenced from one specific point of memory
    volatile String choose;
    

    Frame parentFrame;
    public BotPanel(Frame f)
    {
        parentFrame = f;
        bp.setLayout(new GridLayout(2, 0));
        bp.add(prompt);
        Font  f1  = new Font(Font.SANS_SERIF, Font.BOLD,  40);
        prompt.setFont(f1);
        bp.add(choices);
        f.add(bp);
        choose = null;
    }

    public void setButtons(String[] buttonNames, String question)
    {
        //This method will replace the buttons on the bottom of the screen with new ones
        //The buttons will contain the names of the elements within the buttonNames arguement
        try
        {
            choices.removeAll();
            prompt.setText(question);
            choices.setLayout(new GridLayout(0, buttonNames.length)); //Layout changes dependent on number of buttons
            for (int i=0; i < buttonNames.length;i++)
            {
                Button b = new Button(buttonNames[i]);
                b.addActionListener(this);
                choices.add(b);
            }
            choose = null;
            parentFrame.revalidate(); //This is required to ensure the buttons fit on screen. This is due to the fact that the number of buttons is unknown
        } catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        //Clicking on the buttons causes their names to be stored in choose
        choose = e.getActionCommand();
    }
}
