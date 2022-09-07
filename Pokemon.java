// Pokémon Project - Pokémon Class
// by Arjun Maitra and Nico Aviles
// September 2022

public class Pokemon {

    Main.Type Type1;
    Main.Type Type2;
    int LVL;
    int HP;
    int attack;
    int defense;
    String name;

    public Pokemon(Main.Type Type1, Main.Type Type2, int LVL, int HPBase, int attackBase, int defenseBase, String name){
        this.Type1 = Type1;
        this.Type2 = Type2;
        this.LVL = LVL;
        this.name = name;
        double HPCalc = LVL*(1+(HPBase/10)) + HPBase;
        double attackCalc = LVL*(1+(attackBase/10)) + attackBase;
        double defenseCalc = LVL*(1+(defenseBase/30)) + defenseBase;
        this.HP = (int) HPCalc;
        this.attack = (int) attackCalc;
        this.defense = (int) defenseCalc;
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

    public String toString() {
        String str = name + " Level: " + LVL;

        return str;
    }
}
