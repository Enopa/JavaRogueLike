/***************************
Potion superclass
This is the base potion class that 
the player will have equipped if no 
special potion is available.
It does nothing
***************************/

public abstract class Potion
{
    public String name; 
    
    public String usePotion(Character player)
    {
        return("No potion currently equipped");
    }
    
    public String description()
    {
        return "No Potion Currently Equipped";
    }
}