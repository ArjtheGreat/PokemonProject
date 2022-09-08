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
}
