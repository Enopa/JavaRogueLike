/***************************
Juggernaut Class
Has additional absorb hit method
that allowed the character to take 
no damage for the first hit of combat
***************************/


class Juggernaut extends Character
{
  public String name;
  public Juggernaut (String nam)
  {
    
    super(1, 150, 5, nam);
  }

  @Override
  public String getName()
  {
    return "Juggernaut";
  }
  
  @Override
  public int attack(String attackName)
  {
      //Returns the amount of damage the player does dependent on the attack they performed
      switch (attackName)
      {
          case "Attack":
            return (weapon.damage * strength);
          case "Guarded Attack":
            block = (weapon.defense * defense) / 2;
            return ((weapon.damage * strength) /2);
          case "Defensive Stance":
            defense += 1;
            return -4;
          case "Block":
            block = (defense * weapon.defense);
            return 0;
          default:
            return 0;
      }
  }  
  
  
  @Override
  public String moveSet()
  {
      //Returns a description of each characters moves
      return(
      "MOVE SET\n" +
      "Attack: Does " + (weapon.damage * strength) + " damage\n\n" +
      "Guarded Attack: Blocks " + ((weapon.defense * defense) / 2) + " and deals " + ((weapon.damage * strength) /2) + " damage\n\n" +
      "Defensive Stance: Increases your defence for the rest of combat\n\n" +
      "Block: Reduces incoming damage by " + (weapon.defense * defense) 
      );
  }
}