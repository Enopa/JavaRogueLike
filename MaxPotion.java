/***************************
MaxPotion Class
When usePotion is run, the players
max health is increased.
***************************/

class MaxPotion extends Potion
{
  public String name;  
  public MaxPotion()
  {
    this.name = "Max HP";
  }

  @Override
  public String description()
  {
    return "Max Health Potion - Increases your maximum health";
  }
  
  @Override 
  public String usePotion(Character player)
  {
      player.maxHealth += 20;
      player.potion = null;
      return(player.name + "'s health increased from " + (player.maxHealth - 20) + " to " + player.maxHealth); 
  }
}