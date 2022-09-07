import java.util.ArrayList;

public class Player {
    Pokemon[] pokemons;
    ArrayList<Item> items;

    public Player(Pokemon[] pokemons, ArrayList<Item> items) {
        this.pokemons = pokemons;
        this.items = items;
    }
}
