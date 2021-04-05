/***************************
Defense Potion Class
When usePotion is run, the players
defense is increased.
***************************/

class DefensePotion extends Potion
{
  public String name;  
  public DefensePotion()
  {
    this.name = "Defense";
  }

  @Override
  public String description()
  {
    return("Defense Potion - Increases your defense");
  }
  
  @Override 
  public String usePotion(Character player)
  {
      player.defense++;
      player.potion = null;
      return(player.name + "'s defense increased from " + (player.defense - 1) + " to " + player.defense);
      
  }
}