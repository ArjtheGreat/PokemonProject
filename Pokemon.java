// Pokémon Project - Pokémon Class
// by Arjun Maitra and Nico Aviles
// September 2022

public class Pokemon {

    Main.Type Type1;
    Main.Type Type2;
    int LVL;
    int startingHP;
    int HP;
    int attack;
    int defense;
    String name;
    Attack[] attacks;
    Effect.allEffects statusEffect;

    public Pokemon(Main.Type Type1, Main.Type Type2, int LVL, int HPBase, int attackBase, int defenseBase, String name, Attack[] attacks){
        this.Type1 = Type1;
        this.Type2 = Type2;
        this.LVL = LVL;
        this.name = name;
        double HPCalc = LVL*(1+(HPBase/10)) + HPBase;
        double attackCalc = LVL*(1+(attackBase/10)) + attackBase;
        double defenseCalc = LVL*(1+(defenseBase/30)) + defenseBase;
        this.startingHP = (int) HPCalc;
        this.HP = (int) HPCalc;
        this.attack = (int) attackCalc;
        this.defense = (int) defenseCalc;
        this.attacks = attacks;
    }

    // Accessors
    public Main.Type getType1(){
        return Type1;
    }
    public Main.Type getType2(){
        return Type2;
    }
    public int getLVL() {
        return LVL;
    }

    public int getHP() {
        return HP;
    }
    
    public String getName() {
        return name;
    }
    
    public Attack[] getAttack() {
        return attacks;
    }

    // Mutators
    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Code by Nico
    // Sets the effect for the target Pokemon
    public void setStatusEffect(Pokemon pokemon, Effect.allEffects effect){
        statusEffect = effect;
    }

    // Effect Tick for multi-turn effects
    public void effectTick(){
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.poison)){
            HP -= startingHP/6;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.burn)){
            HP -= startingHP/4;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.heal20)){
            HP += 20;
            if(HP > startingHP){HP = startingHP;}
            statusEffect = null;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.heal50)){
            HP += 50;
            if(HP > startingHP){HP = startingHP;}
            statusEffect = null;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.heal100)){
            HP += 100;
            if(HP > startingHP){HP = startingHP;}
            statusEffect = null;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.attackUp)){
            attack += attack / 4;
            statusEffect = null;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.defenseUp)){
            defense += defense / 4;
            statusEffect = null;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.attackDown)){
            attack -= attack / 4;
            statusEffect = null;
        }
        if(statusEffect != null && statusEffect.equals(Effect.allEffects.defenseDown)){
            defense -= defense / 4;
            statusEffect = null;
        }
    }


    // Prints Out Pokemon
    public String toString() {
        String str = name + " Level: " + LVL;

        return str;
    }

    public void setStatusEffect(Effect.allEffects effect) {
        this.statusEffect = effect;
    }
}
