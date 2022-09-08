# PokemonProject
 
## Pokemon Battle Simulator Designed by Arjun Maitra and Nico Aviles

# Classes and Methods: <br />
Classes: Pokémon, Item, Attack, Main, Effect

-All Classes contain Constructors

Main: <br />
create enum menuState() { battle, attack, bag, pokemon } which will keep track off which state the menu is. the enum is defaulted to battle.
create enum Type() { None, Normal, Fire, Water, Grass, Flying, Fighting, Poison, Electric, Ground, Rock, Psychic, Ice, Bug, Ghost, Steel, Dragon, Dark, Fairy } which contains all Pokemon types
public static void userSelection() - Scanner in prompts the user for their name. declare size six Pokemon[] pokies and an empty Item[] items. create a player with name in.nextLine(), pokies, items. Then 
                                     prompt the user about what they wanna do (central game loop) <br />
public static void print() - reads enum menuState and prints out the corresponding state.

Pokémon <br />
Main.Type Type1, Main.Type Type2, int LVL, int HPBase, int attackBase, int defenseBase, String name
Main.Type getType1()
Main.Type getType2()
public int getLVL()
public int getHP()
public void setHP(int HP)
public String getName()
public String toString() - prints out the Pokemon in a specific way to suit the UI

Attack <br />
int damage, String name, Effect effect
public Main.Type getType()
public int getPower()
public String getName()

Item <br />
String name, Effect effect, int quantity
public Effect getEffect()
public int getQuantity()
public String getName()
public void setQuantity(int x)

Effect <br />,
int numEffect, enum allEffects { all effects go here }
public int getNumEffect()
public Effect.allEffects getEffect(int numEffect)

Player <br />
String playerName, Pokemon[] pokemons, ArrayList<Item> items
addToBag(Item item) - adds inputed Item to bag
switchCurrentPokemon(Pokemon inPokie) - puts the current pokemon being used at pokemons[0] and puts the old pokemons[0] in the old spot.

![pokeball](https://user-images.githubusercontent.com/33406133/188938588-bd730034-4acb-4670-b54f-a3fd94d855c1.png)

