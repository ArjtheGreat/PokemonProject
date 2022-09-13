// Pokémon Project - Main Class
// by Arjun Maitra and Nico Aviles
// September 2022

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public enum Type{None, Normal, Fire, Water, Grass, Flying, Fighting, Poison, Electric, Ground, Rock, Psychic, Ice, Bug, Ghost, Steel, Dragon, Dark, Fairy}

    // Enum Controls Menu State (code by Maitra)
    enum menuState {
        Battle, Attack, Bag, Pokemon;
    };

    public static void main(String[] args) {
        // Default Starts As Battle
        menuState menu = menuState.Battle;
        userSelection(menu);
    }

    // Runs the Main Menu (code by Maitra)
    public static void userSelection(menuState menu) {

        Scanner in = new Scanner(System.in);

        // Player Personality
        System.out.println("What is your name?");
        String name = in.nextLine();

        Pokemon[] pokies = new Pokemon[6];

        Attack[] attacks = new Attack[4];
        attacks[0] = new Attack(Type.Normal, 20, "Tackle");
        attacks[1] = new Attack(Type.Water, 40, "Aqua Jet");
        attacks[2] = new Attack(Type.Water, 60, "Water Pulse");
        attacks[3] = new Attack(Type.Water, 100, "Hydro Pump");


        pokies[0] = new Pokemon(Type.Water, Type.None, 3, 40, 10, 10, "Squirtle", attacks);
        pokies[1] = new Pokemon(Type.Fairy, Type.Normal, 10, 100, 20, 20, "Jigglypuff", attacks);
        pokies[2] = new Pokemon(Type.Flying, Type.Dragon, 100, 150, 100, 100, "Rayquaza", attacks);
        pokies[3] = new Pokemon(Type.Grass, Type.Steel, 40, 120, 30, 70, "Ferrothorn", attacks);
        pokies[4] = new Pokemon(Type.Ghost, Type.Fairy, 30, 90, 70, 40, "Pikachu", attacks);
        pokies[5] = new Pokemon(Type.Fire, Type.Fighting, 80, 130, 90, 80, "Infernape", attacks);

        pokies[0] = new Pokemon(Type.Fire, Type.Water, 3, 100, 10, 10, "Pikachu", attacks);
        pokies[1] = new Pokemon(Type.Fire, Type.Water, 3, 100, 10, 10, "Pichu", attacks);
        pokies[2] = new Pokemon(Type.Fire, Type.Water, 3, 100, 10, 10, "Daemon", attacks);
        pokies[3] = new Pokemon(Type.Fire, Type.Water, 3, 100, 10, 10, "Rhaenyra", attacks);
        pokies[4] = new Pokemon(Type.Fire, Type.Water, 3, 100, 10, 10, "Danaerys", attacks);
        pokies[5] = new Pokemon(Type.Fire, Type.Water, 3, 100, 10, 10, "Jon Snow", attacks);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Item 1", new Effect(3), 3));
        items.add(new Item("Item 2", new Effect(3), 3));
        items.add(new Item("Item 3", new Effect(3), 3));
        items.add(new Item("Item 4", new Effect(3), 3));

        Player player = new Player(name, pokies, items);        

        Pokemon[] newPokies = new Pokemon[6];
        newPokies[5] = new Pokemon(Type.Ghost, Type.Dragon, 3, 100, 10, 10, "Giratina", attacks);
        newPokies[4] = new Pokemon(Type.Dark, Type.Rock, 3, 100, 10, 10, "Tyranitar", attacks);
        newPokies[3] = new Pokemon(Type.Fire, Type.Flying, 3, 100, 10, 10, "Charizard", attacks);
        newPokies[2] = new Pokemon(Type.Fire, Type.None, 3, 100, 10, 10, "Charmander", attacks);
        newPokies[1] = new Pokemon(Type.Water, Type.None, 3, 100, 10, 10, "Kyogre", attacks);
        newPokies[0] = new Pokemon(Type.Grass, Type.Poison, 3, 100, 10, 10, "Bulbasaur", attacks);
        Player computer = new Player("computer", newPokies, items);

        int currentTurn = 0;
        while(true) {
            print(player,computer,menu, currentTurn);
            //menu = menuState.Battle;
            if(currentTurn % 2 == 0) {
                System.out.println(player.playerName + ", " + "What do you wanna do?");
                String line = in.nextLine();
                if (line.equals("battle")) {
                    System.out.println("What attack do you want?");
                    String attackIn = in.nextLine();
                    computer.getCurrentPokemon().setHP(computer.getCurrentPokemon().getHP()
                            - player.getCurrentPokemon().getAttack()[Integer.parseInt(attackIn)].power);
                }
                else if (line.equals("Pok")) {
                    menu = menuState.Pokemon;
                    print(player, computer, menu, currentTurn);
                    System.out.println("Name of Pokemon");
                    String pokemonIn = in.nextLine();
                    player.switchCurrentPokemon(pokemonIn);
                    menu = menuState.Battle;
                }
                else if (line.equals("Bag")) {
                    menu = menuState.Bag;
                    print(player, computer, menu, currentTurn);
                    System.out.println("What Item?");
                    String itemIn = in.nextLine();
                    player.addToBag(new Item(itemIn, new Effect(3), 1));;
                    menu = menuState.Battle;
                }
                else if (line.equals("Atk")) {
                    menu = menuState.Bag;
                    print(player, computer, menu, currentTurn);
                    System.out.println("What Attack?");
                    String attackIn = in.nextLine();
                    player.attack(attackIn, computer.getCurrentPokemon());;
                    ;
                    menu = menuState.Battle;
                }
                else if(line.equals("nothing")) {

                } 
                else {
                    System.exit(0);
                }
            }
            else {
                Random rand = new Random();
                int attackInt = rand.nextInt(computer.getPokemons()[0].getAttack().length);
                
                player.getCurrentPokemon().setHP(
                        player.getCurrentPokemon().getHP() - computer.getCurrentPokemon().getAttack()[attackInt].power);
                if (player.getCurrentPokemon().HP <= 0) {
                    player.switchCurrentPokemon("Pichu");
                }
            }
            print(player, computer, menu, currentTurn);
            currentTurn++;
        }

    }

    // Prints Out Current Menu State (Code by Nico)
    public static void print(Player player1, Player computer, menuState menu, int turn) {
        //Nico did this part
        
        if (menu == menuState.Battle) {
            String HP = "HP: "+computer.pokemons[0].HP;
            String spaces = "                             ";
            System.out.print("*****************************\n*");
            System.out.println(computer.pokemons[0].toString()+spaces.substring(computer.pokemons[0].toString().length()+2,spaces.length())+"*\n*"+HP+spaces.substring(HP.length()+2,spaces.length())+"*");
            System.out.print("*                     0     *\n*                    -|-    *\n*                    / \\    *\n*                           *\n*     0                     *\n");
            String spaces1 = spaces.substring(0,20-player1.pokemons[0].toString().length());
            String playerLevelLine = "*    -|-"+spaces1+player1.pokemons[0].toString()+"*";
            String spaces2 = spaces.substring(0,20-("HP: "+player1.pokemons[0].HP).length());
            System.out.print(playerLevelLine+"\n*    / \\"+spaces2+"HP: "+player1.pokemons[0].HP+"*\n*---------------------------*\n*");

        } 

        // By Maitra
        else if (menu == menuState.Attack) {
            String spaces = "                             ";
            System.out.print("*****************************\n*");
            //21
            System.out.print("Attack                     *" + "\n*---------------------------*" + "\n*" + player1.getCurrentPokemon().getAttack()[0].getName() + spaces.substring(0, 27-player1.getCurrentPokemon().getAttack()[0].getName().length()) + "*\n*" + player1.getCurrentPokemon().getAttack()[1].getName() + spaces.substring(0, 27-player1.getCurrentPokemon().getAttack()[1].getName().length()) + "*\n*" 
                    + player1
                            .getCurrentPokemon().getAttack()[2].getName()
                    + spaces.substring(0, 27 - player1.getCurrentPokemon().getAttack()[2].getName().length()) + "*\n*" + player1
                    .getCurrentPokemon().getAttack()[3].getName()
                    + spaces.substring(0, 27 - player1.getCurrentPokemon().getAttack()[3].getName().length()) + "*\n*");
            
            System.out.print("*****************************\n*");
            
        } 
        else if (menu == menuState.Bag) {
            String spaces = "                             ";
            System.out.print("*****************************\n*");
            // 21
            System.out.print("Bag                        *" + "\n*---------------------------*" + "\n*"
                    + player1.getItems().get(0).getName()
                    + spaces.substring(0, 27 - player1.getItems().get(0).getName().length()) + "*\n*"
                    + player1.getItems().get(1).getName()
                    + spaces.substring(0, 27 - player1.getItems().get(1).getName().length()) + "*\n*"
                    + player1
                            .getItems().get(2).getName()
                    + spaces.substring(0, 27 - player1.getItems().get(2).getName().length()) + "*\n*"
                    + player1
                            .getItems().get(3).getName()
                    + spaces.substring(0, 27 - player1.getItems().get(3).getName().length()) + "*\n*");

            System.out.print("*****************************\n*");
        } 
        else {
            String spaces = "                             ";
            System.out.print("*****************************\n*");
            // 21
            System.out.print("Pokemon                    *" + "\n*---------------------------*" + "\n*"
                    + player1.getPokemons()[0].getName()
                    + spaces.substring(0, 27 - player1.getPokemons()[0].getName().length()) + "*\n*"
                    + player1.getPokemons()[1].getName()
                    + spaces.substring(0, 27 - player1.getPokemons()[1].getName().length()) + "*\n*"
                    + player1
                            .getPokemons()[2].getName()
                    + spaces.substring(0, 27 - player1.getPokemons()[2].getName().length()) + "*\n*"
                    + player1
                            .getPokemons()[3].getName()
                    + spaces.substring(0, 27 - player1.getPokemons()[3].getName().length()) 
                    + "*\n*" + player1
                            .getPokemons()[4].getName()
                    + spaces.substring(0, 27 - player1.getPokemons()[4].getName().length()) + "*\n*" + player1
                            .getPokemons()[5].getName()
                    + spaces.substring(0, 27 - player1.getPokemons()[5].getName().length()) + "*\n*");
                    

            System.out.print("****************************\n*");
        }

    }
























    public static void attack(Pokemon pokemon, Pokemon attacker, Attack attack){
        double power = attack.power;

        Random r = new Random(); //Random Critical Hit Code
        int criticalOdds = r.nextInt(16);
        int critical = 1;
        if(criticalOdds == 0){
            critical = 2;
        }

        //Damage Equation
        double damage = (((((2*attacker.LVL*critical)/5)+2) * power * (attacker.attack / pokemon.defense))/50)+2;

        if((attack.type != Type.Ghost && attack.type != Type.Dragon && attack.type != Type.Normal && attack.type != Type.Bug && attack.type != Type.Flying
                && attack.type != Type.Fairy && attack.type != Type.Fighting && attack.type != Type.Rock && attack.type != Type.Ground) && (attack.type == pokemon.Type1 || attack.type == pokemon.Type2)){
            damage /= 2; //Type Resistance to itself applies to half of all types
        }   //Those that don't resist themselves include Ghost Dragon Normal Bug Flying Fairy Fighting Rock Ground

        if(attack.type == Type.Normal){ //Normal
            if(pokemon.Type1 == Type.Ghost || pokemon.Type2 == Type.Ghost){damage = 0;}

            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage /= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
        }
        else if(attack.type == Type.Fire){ //Fire
            if(pokemon.Type1 == Type.Bug || pokemon.Type2 == Type.Bug){damage *= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage *= 2;}
            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage *= 2;}
            if(pokemon.Type1 == Type.Ice || pokemon.Type2 == Type.Ice){damage *= 2;}

            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage /= 2;}
            if(pokemon.Type1 == Type.Water || pokemon.Type2 == Type.Water){damage /= 2;}
            if(pokemon.Type1 == Type.Dragon || pokemon.Type2 == Type.Dragon){damage /= 2;}
        }
        else if(attack.type == Type.Water){ //Water
            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage *= 2;}
            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage *= 2;}
            if(pokemon.Type1 == Type.Ground || pokemon.Type2 == Type.Ground){damage *= 2;}

            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage /= 2;}
            if(pokemon.Type1 == Type.Electric || pokemon.Type2 == Type.Electric){damage /= 2;}
        }
        else if(attack.type == Type.Grass){ //Grass
            if(pokemon.Type1 == Type.Water || pokemon.Type2 == Type.Water){damage *= 2;}
            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage *= 2;}
            if(pokemon.Type1 == Type.Ground || pokemon.Type2 == Type.Ground){damage *= 2;}

            if(pokemon.Type1 == Type.Flying || pokemon.Type2 == Type.Flying){damage /= 2;}
            if(pokemon.Type1 == Type.Poison || pokemon.Type2 == Type.Poison){damage /= 2;}
            if(pokemon.Type1 == Type.Bug || pokemon.Type2 == Type.Bug){damage /= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage /= 2;}
            if(pokemon.Type1 == Type.Dragon || pokemon.Type2 == Type.Dragon){damage /= 2;}
        }
        else if(attack.type == Type.Flying){ //Flying
            if(pokemon.Type1 == Type.Fighting || pokemon.Type2 == Type.Fighting){damage *= 2;}
            if(pokemon.Type1 == Type.Bug || pokemon.Type2 == Type.Bug){damage *= 2;}
            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage *= 2;}

            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage /= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
            if(pokemon.Type1 == Type.Electric || pokemon.Type2 == Type.Electric){damage /= 2;}
        }
        else if(attack.type == Type.Fighting){ //Fighting
            if(pokemon.Type1 == Type.Ghost || pokemon.Type2 == Type.Ghost){damage = 0;}

            if(pokemon.Type1 == Type.Normal || pokemon.Type2 == Type.Normal){damage *= 2;}
            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage *= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage *= 2;}
            if(pokemon.Type1 == Type.Ice || pokemon.Type2 == Type.Ice){damage *= 2;}
            if(pokemon.Type1 == Type.Dark || pokemon.Type2 == Type.Dark){damage *= 2;}

            if(pokemon.Type1 == Type.Flying || pokemon.Type2 == Type.Flying){damage /= 2;}
            if(pokemon.Type1 == Type.Poison || pokemon.Type2 == Type.Poison){damage /= 2;}
            if(pokemon.Type1 == Type.Bug || pokemon.Type2 == Type.Bug){damage /= 2;}
            if(pokemon.Type1 == Type.Psychic || pokemon.Type2 == Type.Psychic){damage /= 2;}
            if(pokemon.Type1 == Type.Fairy || pokemon.Type2 == Type.Fairy){damage /= 2;}
        }
        else if(attack.type == Type.Poison){ //Poison
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage = 0;}

            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage *= 2;}
            if(pokemon.Type1 == Type.Fairy || pokemon.Type2 == Type.Fairy){damage *= 2;}

            if(pokemon.Type1 == Type.Ground || pokemon.Type2 == Type.Ground){damage /= 2;}
            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage /= 2;}
            if(pokemon.Type1 == Type.Ghost || pokemon.Type2 == Type.Ghost){damage /= 2;}
        }
        else if(attack.type == Type.Electric){ //Electric
            if(pokemon.Type1 == Type.Ground || pokemon.Type2 == Type.Ground){damage = 0;}

            if(pokemon.Type1 == Type.Flying || pokemon.Type2 == Type.Flying){damage *= 2;}
            if(pokemon.Type1 == Type.Water || pokemon.Type2 == Type.Water){damage *= 2;}

            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage /= 2;}
            if(pokemon.Type1 == Type.Dragon || pokemon.Type2 == Type.Dragon){damage /= 2;}
        }
        else if(attack.type == Type.Ground){ //Ground
            if(pokemon.Type1 == Type.Flying || pokemon.Type2 == Type.Flying){damage = 0;}

            if(pokemon.Type1 == Type.Poison || pokemon.Type2 == Type.Poison){damage *= 2;}
            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage *= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage *= 2;}
            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage *= 2;}
            if(pokemon.Type1 == Type.Electric || pokemon.Type2 == Type.Electric){damage *= 2;}

            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage /= 2;}
            if(pokemon.Type1 == Type.Bug || pokemon.Type2 == Type.Bug){damage /= 2;}
        }
        else if(attack.type == Type.Rock){ //Rock
            if(pokemon.Type1 == Type.Flying || pokemon.Type2 == Type.Flying){damage *= 2;}
            if(pokemon.Type1 == Type.Bug || pokemon.Type2 == Type.Bug){damage *= 2;}
            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage *= 2;}
            if(pokemon.Type1 == Type.Ice || pokemon.Type2 == Type.Ice){damage *= 2;}

            if(pokemon.Type1 == Type.Fighting || pokemon.Type2 == Type.Fighting){damage /= 2;}
            if(pokemon.Type1 == Type.Ground || pokemon.Type2 == Type.Ground){damage /= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
        }
        else if(attack.type == Type.Psychic){ //Psychic
            if(pokemon.Type1 == Type.Dark || pokemon.Type2 == Type.Dark){damage = 0;}

            if(pokemon.Type1 == Type.Fighting || pokemon.Type2 == Type.Fighting){damage *= 2;}
            if(pokemon.Type1 == Type.Poison || pokemon.Type2 == Type.Poison){damage *= 2;}

            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
        }
        else if(attack.type == Type.Ice){ //Ice
            if(pokemon.Type1 == Type.Flying || pokemon.Type2 == Type.Flying){damage *= 2;}
            if(pokemon.Type1 == Type.Ground || pokemon.Type2 == Type.Ground){damage *= 2;}
            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage *= 2;}
            if(pokemon.Type1 == Type.Dragon || pokemon.Type2 == Type.Dragon){damage *= 2;}

            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage /= 2;}
            if(pokemon.Type1 == Type.Water || pokemon.Type2 == Type.Water){damage /= 2;}
        }
        else if(attack.type == Type.Bug){ //Bug
            if(pokemon.Type1 == Type.Grass || pokemon.Type2 == Type.Grass){damage *= 2;}
            if(pokemon.Type1 == Type.Psychic || pokemon.Type2 == Type.Psychic){damage *= 2;}
            if(pokemon.Type1 == Type.Dark || pokemon.Type2 == Type.Dark){damage *= 2;}

            if(pokemon.Type1 == Type.Fighting || pokemon.Type2 == Type.Fighting){damage /= 2;}
            if(pokemon.Type1 == Type.Flying || pokemon.Type2 == Type.Flying){damage /= 2;}
            if(pokemon.Type1 == Type.Poison || pokemon.Type2 == Type.Poison){damage /= 2;}
            if(pokemon.Type1 == Type.Ghost || pokemon.Type2 == Type.Ghost){damage /= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage /= 2;}
            if(pokemon.Type1 == Type.Fairy || pokemon.Type2 == Type.Fairy){damage /= 2;}
        }
        else if(attack.type == Type.Ghost){ //Ghost
            if(pokemon.Type1 == Type.Normal || pokemon.Type2 == Type.Normal){damage = 0;}

            if(pokemon.Type1 == Type.Ghost || pokemon.Type2 == Type.Ghost){damage *= 2;}
            if(pokemon.Type1 == Type.Psychic || pokemon.Type2 == Type.Psychic){damage *= 2;}

            if(pokemon.Type1 == Type.Dark || pokemon.Type2 == Type.Dark){damage /= 2;}
        }
        else if(attack.type == Type.Steel){ //Steel
            if(pokemon.Type1 == Type.Rock || pokemon.Type2 == Type.Rock){damage *= 2;}
            if(pokemon.Type1 == Type.Ice || pokemon.Type2 == Type.Ice){damage *= 2;}
            if(pokemon.Type1 == Type.Fairy || pokemon.Type2 == Type.Fairy){damage *= 2;}

            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage /= 2;}
            if(pokemon.Type1 == Type.Water || pokemon.Type2 == Type.Fairy){damage /= 2;}
            if(pokemon.Type1 == Type.Electric || pokemon.Type2 == Type.Steel){damage /= 2;}
        }
        else if(attack.type == Type.Dragon){ //Dragon
            if(pokemon.Type1 == Type.Fairy || pokemon.Type2 == Type.Fairy){damage = 0;}

            if(pokemon.Type1 == Type.Dragon || pokemon.Type2 == Type.Dragon){damage *= 2;}

            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
        }
        else if(attack.type == Type.Dark){ //Dark
            if(pokemon.Type1 == Type.Ghost || pokemon.Type2 == Type.Ghost){damage *= 2;}
            if(pokemon.Type1 == Type.Psychic || pokemon.Type2 == Type.Psychic){damage *= 2;}

            if(pokemon.Type1 == Type.Fighting || pokemon.Type2 == Type.Fighting){damage /= 2;}
            if(pokemon.Type1 == Type.Fairy || pokemon.Type2 == Type.Fairy){damage /= 2;}
        }
        else if(attack.type == Type.Fairy){ //Fairy
            if(pokemon.Type1 == Type.Fighting || pokemon.Type2 == Type.Fighting){damage *= 2;}
            if(pokemon.Type1 == Type.Dragon || pokemon.Type2 == Type.Dragon){damage *= 2;}
            if(pokemon.Type1 == Type.Dark || pokemon.Type2 == Type.Dark){damage *= 2;}

            if(pokemon.Type1 == Type.Poison || pokemon.Type2 == Type.Poison){damage /= 2;}
            if(pokemon.Type1 == Type.Steel || pokemon.Type2 == Type.Steel){damage /= 2;}
            if(pokemon.Type1 == Type.Fire || pokemon.Type2 == Type.Fire){damage /= 2;}
        }
        if(attack.type == attacker.Type1 || attack.type == attacker.Type2){
            damage += damage/2;
        }
        if(damage > 0){
            Random damageRandom = new Random();
            int posOrNeg = damageRandom.nextInt(10);
            if(posOrNeg > 4){
                posOrNeg -= 6;
            }
            damage += posOrNeg;}
        pokemon.setHP((int) (pokemon.HP - damage));
    }
}
