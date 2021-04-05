/**********************
The enemy class. Holds
their health and damage
**********************/


public abstract class Enemy 
{
  String name;
  int HP;
  int maxHP;
  int damage;

  public Enemy(String n, int max, int dmg)
  {
    this.name = n;
    this.damage = dmg;
    this.maxHP = max;
    this.HP = max;
  }
  
  public int enemyAttack(int randomDamage)
  {
      //The amount of damage the enemy does is a randomised number less than their damage value
      return randomDamage;
  }
  
  
  public String takeDamage(int dmg)
  {
      //This returns the amount of damage the enemy took or the players action
      //Player action is returned here due to the fact that the enemy will take 0 damage if the player doesnt attack
      
      if (dmg == -5)
      {
          return("Weapons Switched");
      } else if (dmg == 0)
      {
          return("You blocked");
      } else if (dmg == -4)
      {
          return("Defense Increased");
      } else if (dmg == -1)
      {
          return("Strength Increased");
      }
      HP -= dmg;
      return ("Enemy took " + dmg + " damage!");
  }
  
  
  public String getInfo()
  {
      //Returns the informations about the enemy
      return (
      name + "\n\n" +
        "Health: " + HP + "/" + maxHP + "\n" +
        "Damage: " + damage + "\n");
  }
  
}