/***************************
Knight Class
Overrides buy and getName method 
from the character class.
Has extraMoney variable and money method that 
gives the player more money.
***************************/


class Knight extends Character
{
  public String name;
  public int extraMoney = 10;
  public Boolean moneyRecieved = false;
  public Knight (String nam)
  {
    super(2, 100, 2, nam);
    this.gold = extraMoney + 50;
  }

  @Override
  public String getName()
  {
    return "Knight";
  }
  
  
  public void money()
  {
      gold += extraMoney;
  }
  
  @Override
  public String buy(int price, Potion p)
  {
        price -= (price * 0.1);
        //This method can be used to buy something
        //Will subtract money and define the potion variable
        //The knight overrides as they have a discount on potions
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
  
  @Override
  public int attack(String attackName)
  {
      //Returns the amount of damage the player does dependent on the attack they performed
      switch (attackName)
      {
          case "Attack":
            return (weapon.damage * strength);
          case "Coin Toss":
            gold -= 20;
            if (gold < 0)
            {
                gold = 0;
            }
            return gold;
          case "Empower":
            strength += 1;
            return -1;
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
      "Coin Toss: Does damage equal to your gold. Removes 20 gold\n\n" +
      "Empower: Increases your strength for the rest of combat\n\n" +
      "Block: Reduces incoming damage by " + (weapon.defense * defense) 
      );
  }
}