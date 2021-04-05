/******************************
Character class. Parent class of the 
individual types of character the player
can choose.
Has basic attack and damage class methods
******************************/

public abstract class Character
{
  //Unfortunately these are all public
  //At the point of realising these should have local scope a majority of the program had been constructed
  //Thus to make these private would require the entire project to be reformed entirely
  public int strength;
  public int HP;
  public int maxHealth;
  public int defense;
  public String name;
  public int gold;
  public int block;
  
  public static Potion potion;
  public Weapon weapon;

  public Character (int str, int max, int def, String nam)
  {
    this.strength = str;
    this.maxHealth = max;
    this.defense = def;
    this.HP = max;
    this.name = nam;
    this.gold = 50;
    this.weapon = new Weapon();
  }

  public String getName()
  {
    //Default methods, overriden in subclasses
    return "None";
  }
  
  public String getInfo()
  {
      //Returns the information about the player
      //We must perform initial checks to see if the player has a potion
      String potionOutput;
      if (potion != null)
      {
          potionOutput = ("Potion: " + potion.description());
      } else 
      {
          potionOutput = "Potion: No potion currently equipped";
      }

      return (
      this.name + " the " + this.getName() + "\n" +
        "Health: " + HP + "/" + maxHealth + "\n" +
        "Strength: " + strength + "\n" +
        "Defense: " + defense + "\n" +
        potionOutput + "\n" +
        "Gold: " + gold + "\n\n\n" + 
        "---WEAPON STATS---" +
        "\nName: " + weapon.name +
        "\nDamage: " + weapon.damage +
        "\nDefense: " + weapon.defense);
  }
  
  public String moveSet()
  {
      //Default methods, overriden in subclasses
      return("");
  }
  
  public String buy(int price, Potion p)
  {
      //This method can be used to buy something
      //Will subtract money and define the potion variable
        if (potion != null) 
        {
            return "You already have a potion greedy!!!";
        } else if (gold < price)
        {
            return "Come back when you're a little... MMMMMMM... Richer!";
        } else 
        {
            potion = p;
            gold -= price;
            return "THANK U 4 UR SERVIICCE!!!";
        }
  }
  
  public String takeDamage(int damage)
  {
      //Subtracts player health and returns the amount of damage they took
      damage -= block;
      if (damage < 0)
      {
          damage = 0;
      }
      HP -= damage;
      block = 0;
      return ("You took " + damage + " damage");
  }
  
  public int attack(String attackName)
  {
      //Returns the amount of damage the player does dependent on the attack they performed
      return 0;
  }    
}





