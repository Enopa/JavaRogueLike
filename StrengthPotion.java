/***************************
Strenght Potion Class
When usePotion is run, the players
strength is increased.
***************************/

class StrengthPotion extends Potion
{
  public String name;  
  public StrengthPotion()
  {
    this.name = "Strength";
  }
  
  @Override
  public String description()
  {
    return "Strength Potion - Increases your strength";
  }
  
  @Override 
  public String usePotion(Character player)
  {
      player.strength++;
      player.potion = null;
      return(player.name + "'s strength increased from " + (player.strength - 1) + " to " + player.strength);
      
  }
}