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
}
