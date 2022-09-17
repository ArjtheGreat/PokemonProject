// Pokémon Project - Effect Class
// by Arjun Maitra and Nico Aviles (Code by Maitra)
// September 2022

public class Effect {
    int numEffect;
    enum allEffects { heal20, heal50, heal100, pokeballCatch, attackUp, defenseUp, attackDown, defenseDown, burn, poison, freeze};
                        //0      1       2           3           4           5          6          7         8      9      10
    public Effect(int numEffect){
        this.numEffect = numEffect;
    }   
    
    // Accessors
    public int getNumEffect() {
        return numEffect;
    }

    public Effect.allEffects getEffect(int numEffect) {
        return allEffects.values()[numEffect];
    }

}
