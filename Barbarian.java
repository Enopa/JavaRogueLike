/***************************
Barbarian Class
Overrides getName and getInfo class 
as well as having its own switchWeapons method.
Also has to additional variables, secondWeapon and storeWeapon.
***************************/



class Barbarian extends Character
{
  public String name;
  public Weapon secondWeapon;
  public Weapon storeWeapon;
  public Barbarian (String nam)
  {
    super(5, 50, 1, nam);
    this.secondWeapon = new Weapon();
  }

  @Override
  public String getName()
  {
    return "Barbarian";
  }
  
  @Override
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
      super.name + " the " + this.getName() + "\n" +
        "Health: " + HP + "/" + maxHealth + "\n" +
        "Strength: " + strength + "\n" +
        "Defense: " + defense + "\n" +
        potionOutput + "\n" +
        "Gold: " + gold + "\n" + 
        "---WEAPON STATS---" +
        "\nName: " + weapon.name +
        "\nDamage: " + weapon.damage +
        "\nDefense: " + weapon.defense + 
        "\n---OFFHANDWEAPON STATS---" +
        "\nName: " + secondWeapon.name +
        "\nDamage: " + secondWeapon.damage +
        "\nDefense: " + secondWeapon.defense);
  }
  
  public String switchWeapons()
  {
      //Switches the main weapon to the offhand weapon
      storeWeapon = weapon;
      weapon = secondWeapon;
      secondWeapon = storeWeapon;
      return("Weapons Switched!");
  }
  
  
  @Override
  public int attack(String attackName)
  {
      //Returns the amount of damage the player does dependent on the attack they performed
      switch (attackName)
      {
          case "Attack":
            return (weapon.damage * strength);
          case "All Out":
            defense--;
            if (defense < 0)
            {
                defense = 0;
            }
            return (weapon.damage * (strength + 2));
          case "Swap Weapons":
            switchWeapons();
            return -5;
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
      "All Out: Lowers defence for rest of combat and deals " + (weapon.damage * (strength + 2)) + " damage\n\n" +
      "Swaps Weapons: Swaps your main and offhand weapons\n\n" +
      "Block: Reduces incoming damage by " + (weapon.defense * defense) 
      );
  }
}