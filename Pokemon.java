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
    Effect statusEffect;

    public Pokemon(Main.Type Type1, Main.Type Type2, int LVL, int HPBase, int attackBase, int defenseBase, String name, Attack[] attacks){
        this.Type1 = Type1;
        this.Type2 = Type2;
        this.LVL = LVL;
        this.name = name;
        double HPCalc = LVL*(1+(HPBase/10)) + HPBase;
        double attackCalc = LVL*(1+(attackBase/10)) + attackBase;
        double defenseCalc = LVL*(1+(defenseBase/30)) + defenseBase;
        this.startingHP = (int) HPCalc;
        HP = startingHP;
        this.attack = (int) attackCalc;
        this.defense = (int) defenseCalc;
        this.attacks = attacks;
    }
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
    public void setHP(int HP){
        this.HP = HP;
    }
    public String getName() {
        return name;
    }
    
    public Attack[] getAttack() {
        return attacks;
    }

    public void setStatusEffect(Pokemon pokemon, Effect effect){
        statusEffect = effect;
    }

    public void effectTick(){
        if(statusEffect.equals(Effect.allEffects.poison)){
            HP -= startingHP/6;
        }
        if(statusEffect.equals(Effect.allEffects.burn)){
            HP -= startingHP/4;
        }
        if(statusEffect.equals(Effect.allEffects.heal20)){
            HP += 20;
            statusEffect = null;
        }
        if(statusEffect.equals(Effect.allEffects.heal50)){
            HP += 50;
            statusEffect = null;
        }
        if(statusEffect.equals(Effect.allEffects.heal100)){
            HP += 100;
            statusEffect = null;
        }
        if(statusEffect.equals(Effect.allEffects.attackUp)){
            attack += attack / 4;
            statusEffect = null;
        }
        if(statusEffect.equals(Effect.allEffects.defenseUp)){
            defense += defense / 4;
            statusEffect = null;
        }
    }



    public String toString() {
        String str = name + " Level: " + LVL;

        return str;
    }

    public void setStatusEffect(Effect effect) {
        this.statusEffect = effect;
    }
}
