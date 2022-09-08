// Pokémon Project - Item Class
// by Arjun Maitra and Nico Aviles
// September 2022

public class Item {

    String name;
    Effect effect;
    int quantity;

    public Item(String name, Effect effect, int quantity){
        this.name = name;
        this.effect = effect;
        this.quantity = quantity;
    }

    public void consumeItem(Pokemon pokemon){
        switch(effect.numEffect){
            case(0):
                pokemon.setHP(pokemon.HP + 20); break;
            case(1):
                pokemon.setHP(pokemon.HP + 50); break;
            case(2):
                pokemon.setHP(pokemon.HP + 100); break;
            case(3):
                System.out.println();

        }
        pokemon.setHP(pokemon.HP);
    }

    // Accessors
    public Effect getEffect() {
        return effect;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    // Mutators
    public void setQuantity(int x) {
        quantity = x;
    }
}
