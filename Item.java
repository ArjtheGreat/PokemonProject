// Pokémon Project - Item Class
// by Arjun Maitra and Nico Aviles
// September 2022

public class Item {

    String name;
    Effect.allEffects effect;
    int quantity;

    public Item(String name, Effect.allEffects effect, int quantity){
        this.name = name;
        this.effect = effect;
        this.quantity = quantity;
    }

    public void consumeItem(Pokemon pokemon){
        pokemon.setStatusEffect(effect);
    }

    // Accessors
    public Effect.allEffects getEffect() {
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
