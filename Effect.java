// Pokémon Project - Effect Class
// by Arjun Maitra and Nico Aviles (Code by Maitra)
// September 2022


public class Effect {
    int numEffect;
    enum allEffects { fire, air, water, earth };

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
