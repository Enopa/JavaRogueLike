
/***************************
HealPotion Class
When usePotion is run, the players
Health is restored
***************************/

class HealPotion extends Potion
{
    public String name;  
    public HealPotion()
    {
        this.name = "Healing";
    }

    
    @Override
    public String description()
    {
        return("Healing Potion - Restores some of your health points");
    }

    @Override 
    public String usePotion(Character player)
    {
        //This method checks for the players current health and ensures that the player is not healed over their max HP
        if (player.HP < player.maxHealth)
        {
            int oldHP = player.HP;
            player.HP += (player.maxHealth * 0.2);
            if (player.HP >= player.maxHealth)
            {
                player.HP = player.maxHealth;
            }
            player.potion = null;
            return(player.name + "'s was healed from " + oldHP + "HP to " + player.HP + "HP");
        } else if (player.HP == player.maxHealth)
        {
            return("You're already at max health, no need to use this potion");
        }
        return("How we get here??");
    }
}