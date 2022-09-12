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
Main.Type Type1, Main.Type Type2, int LVL, int HPBase, int attackBase, int defenseBase, String name  <br />
Main.Type getType1()  <br />
Main.Type getType2()  <br />
public int getLVL()  <br />
public int getHP()  <br />
public void setHP(int HP)  <br />
public String getName()  <br />
public String toString() - prints out the Pokemon in a specific way to suit the UI  <br />

Attack <br />
int damage, String name, Effect effect  <br />
public Main.Type getType()  <br />
public int getPower()  <br />
public String getName()  <br />

Item <br />
String name, Effect effect, int quantity
public Effect getEffect()
public int getQuantity()
public String getName()
public void setQuantity(int x)
String name, Effect effect  <br />
public Effect getEffect()  <br />
public int getQuantity()  <br />
public String getName()  <br />
public void setQuantity(int x)  <br />

Effect <br />,
int numEffect, enum allEffects { all effects go here }  <br />
public int getNumEffect()  <br />
public Effect.allEffects getEffect(int numEffect)  <br />

Player <br />
String playerName, Pokemon[] pokemons, ArrayList<Item> items  <br />
addToBag(Item item) - adds inputed Item to bag  <br />
switchCurrentPokemon(Pokemon inPokie) - puts the current pokemon being used at pokemons[0] and puts the old pokemons[0] in the old spot.  <br />

![pokeball](https://user-images.githubusercontent.com/33406133/188938588-bd730034-4acb-4670-b54f-a3fd94d855c1.png)  <br />

