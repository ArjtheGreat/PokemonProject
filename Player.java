// Pokémon Project - Pokémon Class
// by Arjun Maitra and Nico Aviles (code by Maitra)
// September 2022
import java.util.ArrayList;

public class Player {
    String playerName;
    Pokemon[] pokemons;
    ArrayList<Item> items;

    public Player(String playerName, Pokemon[] pokemons, ArrayList<Item> items) {
        this.playerName = playerName;
        this.pokemons = pokemons;
        this.items = items;
    }

    // Accessors
    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    // Adds New Item To Bag
    public void addToBag(Item item) {
        items.add(item);
    }

    public Pokemon getCurrentPokemon() {
        return pokemons[0];
    }

    // Swap Out Pokemon
    public void swapOutPokemon(int partySlot, Pokemon pokemon){
        pokemons[partySlot] = new Pokemon(pokemon.getType1(),pokemon.getType2(), pokemon.getLVL(),1,1,1,pokemon.getName(), pokemon.getAttacks());
        pokemons[partySlot].setAttack(pokemon.getPower());
        pokemons[partySlot].setDefense(pokemon.getDefense());
        pokemons[partySlot].setHP(pokemon.getHP());
        pokemons[partySlot].setStartingHP(pokemon.getHP());
    }

    public String getPlayerName() {
        return playerName;
    }

    // Removes Item From Bag
    public void removeFromBag(Item item) {
        item.consumeItem(pokemons[0]);
        item.setQuantity(item.quantity - 1);
        if(item.getQuantity() == 0){items.remove(item);}
    }

    

    // Attacks other Pokemon, updates the effects
    public void attack(String inAttack, Pokemon enemyPokemon) {
        int index = 0;
        for(int i = 0; i<getCurrentPokemon().getAttack().length; i++) {
            if(inAttack.equals(getCurrentPokemon().getAttack()[i].getName())) {
                index = i;
            }
        }
        Main.attack(enemyPokemon,pokemons[0],getCurrentPokemon().getAttack()[index]);
        enemyPokemon.setStatusEffect(enemyPokemon,getCurrentPokemon().getAttack()[index].getEffect());
    }

    // Will Move the Current Pokemon to Front of The Array ()
    public void switchCurrentPokemon(String inPokieName) {
        for(int i = 0; i<pokemons.length; i++) {
            if(pokemons[i].getName().equals(inPokieName)) {
                Pokemon pokieStorage = pokemons[0];
                pokemons[0] = pokemons[i];
                pokemons[i] = pokieStorage;
            }
        }
    }

   

    // Check if user input is a Pokemon in the array
    public boolean isInPokemonArray(String inPokieName) {
        for(int i = 0; i<pokemons.length; i++) {
            if(pokemons[i].getName().equals(inPokieName)) {
                return true;
            }
        }
        return false;
    }
}
