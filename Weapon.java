/**********************
The weapon class.
When constructed, it will generate
a random name for the item and give
it a random strength and defense.
**********************/

import java.util.Random;

public class Weapon
{
  public String name;
  public int damage;
  public int defense;

  public Weapon()
  {
    Random rand = new Random();
    //Arrays of names for the weapon, the index of each will be randomissed
    String[] firstName = {"Golden", "Valzahar's", "Enchanted", "Scoundrel's", "Shadow", "Balrus'", "Psychic", "Demonic", "Great", "Shattered", "Light", "Thunderous"};
    String[] secondName = {"Axe", "Sword", "Hammer", "Knife", "Mace", "Katana", "Bow", "Staff", "Dagger", "Fists", "Spear", "Nunchuks", "Rapier", "Halberd"};
    String[] thirdName = {"Flame", "Darkness", "Greatness", "Destruction", "War", "Doom", "Thunder", "Hell", "Ice", "Wonder", "Foretelling", "Disappointment", "Life", "Death"};
    this.name = (firstName[rand.nextInt(12)] + " " + secondName[rand.nextInt(14)] + " of " + thirdName[rand.nextInt(14)]);
    this.damage = rand.nextInt(15);
    this.defense = rand.nextInt(15);
  }
  
  
  public String getInfo()
  {
      //Returns the information of a weapon
      return ("Name: " + name + "\n" +
      "Damage: " + damage + "\n" +
      "Defense: " + defense);
  }
}