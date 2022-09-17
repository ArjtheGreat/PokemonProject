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
    public void removeFromBag(Item item) {
        item.consumeItem(pokemons[0]);
        item.setQuantity(item.quantity - 1);
        if(item.getQuantity() == 0){items.remove(item);}
    }

    public Pokemon getCurrentPokemon() {
        return pokemons[0];
    }

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

    public String getPlayerName() {
        return playerName;
    }

    public boolean isInPokemonArray(String inPokieName) {
        for(int i = 0; i<pokemons.length; i++) {
            if(pokemons[i].getName().equals(inPokieName)) {
                return true;
            }
        }
        return false;
    }
}
