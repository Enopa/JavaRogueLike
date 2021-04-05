/*************************************
Author: Jamal Haruna
Date:   26/01/2021
Versio: 1.0

This is an adventure game. You can
select a class and battle through a 
dangerous dungeon!
 *************************************/

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;

class Main extends Frame 
{
    //Initialising the character player, will use polymorphism to define it
    public static Character player;
    
    //The menu and frame must be public as they are reference by several functions
    public static Frame f = new Frame();
    public static GUI menu = new GUI(f); //the GUI class has several important methods that will be used throughout the program
    
    //Public random object for generating random numbers
    static Random rand = new Random();
    static int fightCount;
    static ArrayList<String> enemiesDefeated = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        //Main.main() starts the program and calls the additional functions
        //The main frame is given values here as well
        f.setLayout(new GridLayout(3,0));
        f.pack();
        f.setSize(700, 700);
        f.setVisible(true);
        //Ensuring the window can close
        f.addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent ev) 
                {
                    System.exit(0);
                }
            });
        classMenu();
    }

    public static void classMenu() throws IOException
    {
        //Run each time the player restarts
        //Allows the player to choose their class and give their character a name
        fightCount = 0;
        enemiesDefeated.clear();

        menu.bot.prompt.setEditable(true);
        String[] ops = {"Knight", "Barbarian", "Juggernaut"};
        menu.bot.setButtons(ops, "Enter your name here");
        
        //Exception handler in case a choice is not valid or understood
        try
        {
            String choice = input();
            String name = menu.bot.prompt.getText();
            //Switch Case statement to choose the players class
            switch (choice.toUpperCase())
            {
                case "BARBARIAN":
                player = new Barbarian(name);
                break;
                case "KNIGHT":
                player = new Knight(name);
                break;
                case "JUGGERNAUT":
                player = new Juggernaut(name);
                break;
                default:
                print("Not a valid option");
                classMenu();
            }
        } catch (Exception e) 
        {
            System.out.println("Something went wrong");
        }
        menu.bot.prompt.setEditable(false);
        print("Welcome, " + player.name + " the " + player.getName() + "!");
        rest(); 
    }

    public static void rest() throws IOException
    {
        //This function prints and runs the main options the player has within the rest menu
        print("\n");
        menu.top.refresh(player.getInfo(), player.moveSet());
        
        
        //ArrayList used here to ensure that I can add the extra option for the Barbarian
        ArrayList<String> listOps = new ArrayList<>();
        listOps.add("Drink equipped potion");
        if (player.getName().equals("Barbarian"))
        {
            listOps.add("Swap Weapons");
        }
        listOps.add("Visit Potion Shop");
        listOps.add("Return to combat");
        listOps.add("Fight Boss");
        listOps.add("Previous Scores");
        String[] ops = listOps.toArray(new String[0]);
        menu.bot.setButtons(ops, "Rest Area");

        try 
        {
            String choice = input();
            switch (choice) 
            {
                case "Drink equipped potion":
                if (player.potion == null)
                {
                    print("No potion equipped");
                } else
                {
                    menu.mid.info.append(player.potion.usePotion(player));
                }
                break;
                case "Swap Weapons":
                menu.mid.info.append(((Barbarian)player).switchWeapons());
                break;
                case "Visit Potion Shop":
                shop();
                break;
                case "Return to combat":
                preFight(false);
                break;
                case "Fight Boss":
                preFight(true);
                break;
                case "Previous Scores":
                outputSaveData();
                break;
                default:
                print("Not a valid number, please try again");
            }
        } catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        rest();
    }

    public static void shop() throws IOException
    {
        //This function allows the player to select and buy a potion.
        menu.top.refresh(player.getInfo(), "WELCOME TO MY HUMBLE POTION SHOP!!!\n" +
            "───▄▀▀▀▄▄▄▄▄▄▄▀▀▀▄───\n" +
            "───█▒▒░░░░░░░░░▒▒█───\n" +
            "────█░░█░░░░░█░░█────\n" +
            "─▄▄──█░░░▀█▀░░░█──▄▄─\n" +
            "█░░█─▀▄░░░░░░░▄▀─█░░█");
            
        //The knight class gets a discount
        if (player.getName().equals("Knight"))
        {
            print("OOH A KNIGHT!!! You get a 10% discount on all items!");
            if (!((Knight)player).moneyRecieved)
            {
                //moneyRecieved set to false after combat
                print("And cause you look so COOL, here's some free money!!!\n");
                ((Knight)player).money();
                ((Knight)player).moneyRecieved = true;
            }

        }
        final String[] ops = {"Strength Potion-60 gold", "Defense Potion-60 gold", "Max Health Potion-50 gold", "Healing Potion-10 gold", "Return to rest area"};
        menu.bot.setButtons(ops, "What will you buy?");

        try 
        {
            String choice = input();
            switch (choice) 
            {
                case "Strength Potion-60 gold":
                menu.mid.info.append(player.buy(60, new StrengthPotion()));
                break;
                case "Defense Potion-60 gold":
                menu.mid.info.append(player.buy(60, new DefensePotion()));
                break;
                case "Max Health Potion-50 gold":
                menu.mid.info.append(player.buy(50, new MaxPotion()));
                break;
                case "Healing Potion-10 gold":
                menu.mid.info.append(player.buy(10, new HealPotion()));
                break;
                case "Return to rest area":
                print("Bye Bye!");
                break;
                default:
                print("SORRY I DONT SELL THAT!!!");
            }
        } catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        rest();
    }

    public static  void preFight(Boolean boss) throws IOException
    {
        //Prefight method to initialise the enemy and attack options for the player
        Enemy[] types = {new Imp(), new Troll(), new Orc(), new Goblin()};
        Enemy enemy =  types[rand.nextInt(4)];
        
        //Dragon is the final boss, once beaten the game ends
        if (boss)
        {
            enemy = new Dragon();
        }
        
        //As some of the moves affect strength and defense, we store the previous values so we can reset them afer
        int preStrength = player.strength;
        int preDefense = player.defense;
        String[] ops;
        
        switch (player.getName())
        {
            case "Knight":
            ops = new String[]{"Attack", "Coin Toss","Empower", "Block"};
            break;
            case "Barbarian":
            ops = new String[]{"Attack", "All Out","Swap Weapons", "Block"};
            break;
            case "Juggernaut":
            ops = new String[]{"Attack", "Guarded Attack","Defensive Stance", "Block"};
            break; 
            default:
            ops = new String[]{"Error"};
            break;
        }
        menu.bot.setButtons(ops, "Which attack will you perform?");
        fight(enemy, preStrength, preDefense);
    }

    public static void fight(Enemy enemy, int preS, int preDef) throws IOException
    {
        //Until the player wins or dies, this method will run recursively
        int enemyDMG = rand.nextInt(enemy.damage);
        menu.top.refresh(player.getInfo(), enemy.getInfo());
        print("\n");
        print("Enemy intends to attack for " + enemyDMG + " damage");

        try {
            String choice = input();
            //Enemy takes damage before the player to ensure player has upper hand in battle
            print(enemy.takeDamage(player.attack(choice)));
            if (enemy.HP <= 0)
            {
                if(!enemy.name.equals("Dragon"))
                {
                    fightCount++;
                    enemiesDefeated.add(enemy.name);
                    postFight(preS, preDef);
                } else 
                {
                    endGame(true);
                }

            }
            print(player.takeDamage(enemy.enemyAttack(enemyDMG)));
            if (player.HP <= 0)
            {
                print("YOU DIED");
                endGame(false);
            }
            fight(enemy, preS, preDef);
        } catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
    }

    public static void postFight(int preS, int preDef) throws IOException
    {
        //Run everytime the player wins a fight
        //Strenght and defense values reset
        player.strength = preS;
        player.defense = preDef;
        print("YOU WIN");
        int droppedGold = rand.nextInt(50);
        print("Enemy dropped " + droppedGold + "gold");
        player.gold += droppedGold;
        
        //Player has an option to swap their weapons with new one
        print("They also dropped a weapon:");
        Weapon newWeapon = new Weapon();
        print(newWeapon.getInfo());
        menu.bot.setButtons(new String[]{"Yes", "No"}, "Would you like to take it?");

        try
        {
            String choice = input();
            if (choice.equals("Yes"))
            {
                player.weapon = newWeapon;
                print("Weapons swapped");
            } else 
            {
                print("Your weapon shall remain the same");
            }
            if (player.getName().equals("Knight"))
            {
                //So the player can recieve more money the next time they visit the shop
                ((Knight)player).moneyRecieved = false;
            }
        } catch (Exception e)
        { 
            System.out.println("Something went wrong");
        }
        rest();
    }

    public static void endGame(boolean win) throws IOException
    {   
        //This is run at the end of the game
        try
        {
            String choice;
            String[] ops = new String[]{"Yes", "No"};
            //If you win, you get the option to record your score
            if (win)
            {
                print("YOU BEAT THE GAME");
                menu.bot.setButtons(ops, "Would you like to record your win?");
                choice = input();
                if (choice.equals("Yes"))
                {
                    PrintWriter outputStream = new PrintWriter(new FileWriter("scores.txt", true));
                    outputStream.println("\n\n" + player.getInfo() + "\nNumber of Battles fought: " + fightCount);
                    String enemyList = "";
                    for (int i = 0; i < enemiesDefeated.size(); i++)
                    {
                        enemyList += enemiesDefeated.get(i) + " ";
                    }
                    outputStream.println("Enemies Defeated: " + enemyList);
                    outputStream.close();
                }
            }

            menu.bot.setButtons(ops, "Would you like to see the recorded scores?");
            choice = input();
            if (choice.equals("Yes"))
            {
                outputSaveData();
            }

            menu.bot.setButtons(ops, "Would you like to try again?");
            choice = input();
            if (choice.equals("Yes"))
            {
                //Runs class menu again, allows them to start again
                classMenu();
            } else 
            {
                //If they select no, the program closes
                System.exit(0);
            }
        } catch (Exception e)
        {
            System.out.println("Something went wrong");
        }

    }

    public static  void outputSaveData() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("scores.txt"));
        String currentLine;
        while ((currentLine = reader.readLine()) != null)
        {
            print(currentLine);
        }
    }

    /************************************
    -------PRINT AND INPUT METHODS-------
     ************************************/
    public static void print(String toPrint)
    {
        //Appens a string to the mid section of the menu
        menu.mid.info.append("\n" + toPrint);
    }


    public static String input()
    {
        //Returns the buttons choice for the player
        String choice = null;
        menu.bot.choose = null;
        while (choice == null)
        {
            choice = menu.bot.choose;
        }
        menu.bot.choose = null;
        return choice;
    }
}

/* Two phases
1. Fight Phase:
Here you can attack, defend or use potion
After battle you gain gold and a weapon/potion. Can only have one 
weapon or potion at a time, must swap them in and out.

Attacks damage enemy, damage is weapon damage multiplied by strength.
Block subtracts enemy damage. Block is defense on weapon multiplied by class defense.

Enemies can only attack.

2. Rest Phase
Here you can shop, use potion or check stats. 
Once you are done here you can battle another enemy or fight final boss.

Shop sells basic health potion and one weapon. Uses gold obtained from fights. 

FINAL BOSS:
Strong enemy with lots of health and relatively high attack.

Three classes
Knight: All rounder, good defense and attack, has more money and shop discounts
Barbarian: High attack but low defense, can carry two weapons and switch between them
Juggernaut: High defense but low attack, can absorb a single hit at the beginning of a fight
 */