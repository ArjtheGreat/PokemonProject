# PokemonProject
 
## Pokemon Battle Simulator Designed by Arjun Maitra and Nico Aviles

Classes and Methods: Pokémon, Item, Attack, Main 

-All Classes contain Accessors and Mutators

Main: <br />
create enum menuState() { battle, attack, bag, pokemon } which will keep track off which state the menu is. the enum is defaulted to battle.
userSelection() - gives prompts to user about what they wanna do
print() - prints out the battlefield


Pokémon <br />
int level, int HP, String name

Attack <br />
int damage, String name, Effect effect

Item <br />
String name, Effect effect

Effect <br />
int numEffect, Effect[] effectArr

