Student name: Jamal Haruna
Student number: 200503130

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called Character

This superclass is extended into at least two subclasses called Barbarian and Knight

For each of the named subclasses complete the following...

Barbarian.

Subclass Barbarian extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are extraWeapon, storeWeapon and switchWeapon.

These new properties are used by the subclass in the following way: extraWeapon allows for the barbarian to hold to weapons. storeWeapon is used when swapping the main weapon and the extra.
Can be found on line 60 in Barbarian.java 

Subclass Barbarian extends the superclass by overriding the following methods (there must be at least one): getName() and getInfo() are overriden methods. These are found on lines 15 and 21
respectfully within the Barbarian.java class.

These overridden methods are used in the working code in the following places: Main.java line 20 and line 70.

Knight.

Subclass Knight extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are extraMoney. Found on line 4 and 20 within the Knight class.

This new properties is used by the subclass in the following way: It is used to give the knight class more money than the other classes. 
It is found on line 19 and 20 of the knight class.

Subclass Knight extends the superclass by overriding the following methods (there must be at least one): The knight class overrides the getName() and buy() method. getName() returns the name of the 
class and buy() gives the knight a 10% discount on items. These methods can be found on line 23 and 35 within the Knight.java class.

These overridden methods are used in the working code in the following places: This methods are called within Main.java on lines 70 and 135.


LEVEL TWO

Polymorphism consists of the use of the Substitution principle and Late Dynamic binding.

In my code, polymorphism is implemented in at least two places…

Example 1.

The substitution principle can be seen in use in the Main.java script on lines 57, 60 and 63. 
The name of the superclass used in this example is Character and the subclasses used are Barbarian, Knight and Juggernaut.

Late dynamic binding can be seen in Main.java on line 70.

-This example of polymorphism is required as it is unknown which character type the player will choose, therefore when the player variable is created, it is made ambigious. 
-When the player selects a class to play as, the ambigous Character variable can utilise polymorphism to create the specific class. 
-Late dynamic binding is required for the overriden methods within the subclasses such as getName().

Example 2.

The substitution principle can be seen in use in Character.java on line 69 (Technically takes an argument from line 135 called within Main.java ). 
The name of the superclass used in this example is Potion and the subclasses used are DefensePotion, StrengthPotion, MaxPotion and HealPotion.

Late dynamic binding can be seen in Main.java on line 87.

-Polymorphism is required here as the player can hold any one of the four potions.
-The Potion variable can be defined by any four of these potions, all of which have different effects.
-Using polymorphism means I do not have to define 4 seperate slots to hold potions as they can all be contained within the single Potion variable. 
