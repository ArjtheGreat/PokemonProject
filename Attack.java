// Pokémon Project - Attack Class
// by Arjun Maitra and Nico Aviles
// September 2022

public class Attack {

    Main.Type type;
    int power;
    String name;
    Effect.allEffects effect;

    public Attack(Main.Type type, int power, String name, Effect.allEffects effect){
        this.type = type;
        this.power = power;
        this.name = name;
        this.effect = effect;
    }

    // Accessors
    public Main.Type getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public Effect.allEffects getEffect(){
        return effect;
    }
}

