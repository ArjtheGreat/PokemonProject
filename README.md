# PokemonProject
 
## Pokemon Battle Simulator Designed by Arjun Maitra and Nico Aviles

# Classes and Methods: <br />
Classes: Pokémon, Item, Attack, Main, Effect

-All Classes contain Constructors, Accessors, and Mutators

Main: <br />
create enum menuState() { battle, attack, bag, pokemon } which will keep track off which state the menu is. the enum is defaulted to battle.
public static void userSelection() - gives prompts to user about what they wanna do (central game loop) <br />
public static void print() - prints out the battlefield

Pokémon <br />
int level, int HP, String name

Attack <br />
int damage, String name, Effect effect

Item <br />
String name, Effect effect

Effect <br />
int numEffect, Effect[] effectArr

![pokeball](https://user-images.githubusercontent.com/33406133/188938588-bd730034-4acb-4670-b54f-a3fd94d855c1.png)
