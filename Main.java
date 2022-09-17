// Pokémon Project - Main Class
// by Arjun Maitra and Nico Aviles
// September 2022

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String textBox;
    public static String[] splitText = new String[2];
    public static String splitTextSpace = "                   ";
    public enum Type{None, Normal, Fire, Water, Grass, Flying, Fighting, Poison, Electric, Ground, Rock, Psychic, Ice, Bug, Ghost, Steel, Dragon, Dark, Fairy}

    // Enum Controls Menu State (code by Maitra)
    enum menuState {
        Battle, Attack, Bag, Pokemon;
    };

    public static void main(String[] args) {
        // Default Starts As Battle
        menuState menu = menuState.Battle;
        splitText[0] = "                   ";
        splitText[1] = "                   ";
        userSelection(menu);
    }

    // Runs the Main Menu (code by Maitra)
    public static void userSelection(menuState menu) {

        Scanner in = new Scanner(System.in);

        // Player Personality (Pokemons by Nico)
        System.out.println("What is your name?");
        String name = in.nextLine();

        Pokemon[] pokies = new Pokemon[6];
        Pokemon[] computerPokies = new Pokemon[6];

        
        // **All Human Pokemon Attacks**

        // Squirtle (GOAT) Attacks
        Attack[] attacks = new Attack[4];
        attacks[0] = new Attack(Type.Normal, 20, "Tackle", null);
        attacks[1] = new Attack(Type.Water, 40, "Aqua Jet", null);
        attacks[2] = new Attack(Type.Water, 60, "Water Pulse", null);
        attacks[3] = new Attack(Type.Water, 100, "Hydro Pump", null);

        // Jigglypuff Attacks
        Attack[] attacks2 = new Attack[4];
        attacks2[0] = new Attack(Type.Fairy, 20, "Sparkles", null);
        attacks2[1] = new Attack(Type.Poison, 10, "Poison", Effect.allEffects.poison);
        attacks2[2] = new Attack(Type.Dark, 50, "Dark Punch", null);
        attacks2[3] = new Attack(Type.Fighting, 70, "Punch", null);

        // Rayquaza Attacks
        Attack[] attacks3 = new Attack[4];
        attacks3[0] = new Attack(Type.Fighting, 50, "Strength", Effect.allEffects.attackUp);
        attacks3[1] = new Attack(Type.Poison, 10, "Poison", Effect.allEffects.poison);
        attacks3[2] = new Attack(Type.Fire, 60, "Dark Punch", Effect.allEffects.attackUp);
        attacks3[3] = new Attack(Type.Dragon, 80, "Dragon Punch", null);

        // Ferrothorn Attacks
        Attack[] attacks4 = new Attack[4];
        attacks4[0] = new Attack(Type.Rock, 80, "Boulder", null);
        attacks4[1] = new Attack(Type.Grass, 35, "Roots",null);
        attacks4[2] = new Attack(Type.Steel, 70,"Metal Punch",null);
        attacks4[3] = new Attack(Type.Normal, 20, "Stonewall", Effect.allEffects.defenseUp);

        // Pikachu Attacks
        Attack[] attacks5 = new Attack[4];
        attacks5[0] = new Attack(Type.Normal, 20, "Tackle", null);
        attacks5[1] = new Attack(Type.Electric, 50, "Shock", null);
        attacks5[2] = new Attack(Type.Electric, 70, "Zap", null);
        attacks5[3] = new Attack(Type.Electric, 100, "Shazam", null);

        // Infernape Attacks
        Attack[] attacks6 = new Attack[4];
        attacks6[0] = new Attack(Type.Normal, 20, "Tackle", null);
        attacks6[1] = new Attack(Type.Fire, 50, "Ember", Effect.allEffects.burn);
        attacks6[2] = new Attack(Type.Fighting, 70, "Punch", null);
        attacks6[3] = new Attack(Type.Electric, 100, "Shazam", null);

        // Enemy Attacks

        // Pichu Attacks
        Attack[] enemyAttacks = new Attack[4];
        enemyAttacks[0] = new Attack(Type.Normal, 20, "Tackle", null);
        enemyAttacks[1] = new Attack(Type.Electric, 50, "Shock", null);
        enemyAttacks[2] = new Attack(Type.Electric, 60, "Zip", null);
        enemyAttacks[3] = new Attack(Type.Electric, 70, "Zap", null);

        // Garbordor Attacks
        Attack[] enemyAttacks2 = new Attack[4];
        enemyAttacks2[0] = new Attack(Type.Normal, 30, "Trash", null);
        enemyAttacks2[1] = new Attack(Type.Normal, 40, "Trashier", null);
        enemyAttacks2[2] = new Attack(Type.Dark, 50, "Trashiest", null);
        enemyAttacks2[3] = new Attack(Type.Normal, 20, "Tackle", null);

        // Persian Attacks
        Attack[] enemyAttacks3 = new Attack[4];
        enemyAttacks3[0] = new Attack(Type.Dark, 50, "Evil Kick", null);
        enemyAttacks3[1] = new Attack(Type.Fighting, 80, "Drop Kick", null);
        enemyAttacks3[2] = new Attack(Type.Dark, 50, "Trashiest", null);
        enemyAttacks3[3] = new Attack(Type.Ground, 90, "Quake", null);

        // Shiinotic Attacks
        Attack[] enemyAttacks4 = new Attack[4];
        enemyAttacks4[0] = new Attack(Type.Fairy, 60, "Magic Kick", null);
        enemyAttacks4[1] = new Attack(Type.Fighting, 80, "Drop Kick", null);
        enemyAttacks4[2] = new Attack(Type.Grass, 40, "Quick Roots", null);
        enemyAttacks4[3] = new Attack(Type.Ground, 90, "Quake", null);

        // Golisopod Attacks
        Attack[] enemyAttacks5 = new Attack[4];
        enemyAttacks5[0] = new Attack(Type.Fairy, 60, "Magic Kick", null);
        enemyAttacks5[1] = new Attack(Type.Fighting, 80, "Drop Kick", null);
        enemyAttacks5[2] = new Attack(Type.Grass, 40, "Quick Roots", null);
        enemyAttacks5[3] = new Attack(Type.Ground, 90, "Quake", null);

        // Giratina Attacks
        Attack[] enemyAttacks6 = new Attack[4];
        enemyAttacks6[0] = new Attack(Type.Dark, 100, "Dark Hold", null);
        enemyAttacks6[1] = new Attack(Type.Ghost, 80, "The Voices", null);
        enemyAttacks6[2] = new Attack(Type.Ghost, 120, "The Haunt", null);
        enemyAttacks6[3] = new Attack(Type.Normal, 60, "Tackle Deluxe", null);

        // Human Pokemons
        pokies[0] = new Pokemon(Type.Water, Type.None, 3, 4, 10, 10, "Squirtle", attacks);
        pokies[1] = new Pokemon(Type.Fairy, Type.Normal, 20, 10, 10, 10, "Jigglypuff", attacks2);
        pokies[2] = new Pokemon(Type.Flying, Type.Dragon, 100, 15, 20, 20, "Rayquaza", attacks3);
        pokies[3] = new Pokemon(Type.Grass, Type.Steel, 40, 12, 15, 15, "Ferrothorn", attacks4);
        pokies[4] = new Pokemon(Type.Ghost, Type.Fairy, 30, 9, 10, 10, "Pikachu", attacks5);
        pokies[5] = new Pokemon(Type.Fire, Type.Fighting, 80, 13, 15, 15, "Infernape", attacks6);

        // Computer Pokemons
        computerPokies[0] = new Pokemon(Type.Water, Type.None, 60, 9, 10, 10, "Pichu", enemyAttacks);
        computerPokies[1] = new Pokemon(Type.Poison, Type.None, 38, 5, 10, 10, "Garbodor", enemyAttacks2);
        computerPokies[2] = new Pokemon(Type.Dark, Type.None, 52, 8, 10, 10, "Persian", enemyAttacks3);
        computerPokies[3] = new Pokemon(Type.Grass, Type.Fairy, 30, 2, 15, 15, "Shiinotic", enemyAttacks4);
        computerPokies[4] = new Pokemon(Type.Bug, Type.Water, 33, 3, 15, 15, "Golisopod", enemyAttacks5);
        computerPokies[5] = new Pokemon(Type.Ghost, Type.Dragon, 66, 18, 20, 20, "Giratina", enemyAttacks6);

        // Items
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Potion", Effect.allEffects.heal20, 3));
        items.add(new Item("Super Potion", Effect.allEffects.heal50, 2));
        items.add(new Item("MrBounds Potion", Effect.allEffects.heal100, 1));
        items.add(new Item("Pokeball", Effect.allEffects.pokeballCatch, 6));

        // Custom Player 
        Player player = new Player(name, pokies, items);

        // Computer Opponent
        Player computer = new Player("computer", computerPokies, items);

        int currentTurn = 0; // Player or Computer Turn

        // A Bunch of menus (Code by Maitra)
        while(true) {
            pokies[0].effectTick();
            String spaces = "                   ";
            print(player,computer,menu, currentTurn);
            //menu = menuState.Battle;
            if(currentTurn % 2 == 0) { // players turn
                System.out.println(player.playerName + ", " + "What do you wanna do?");
                String line = in.nextLine();

                // Select Attack Menu
                if (line.equals("Atk")) {
                    menu = menuState.Attack;
                    print(player, computer, menu, currentTurn);
                    System.out.println("What Attack?");
                    String attackIn = in.nextLine();
                    player.attack(attackIn, computer.getCurrentPokemon());
                    textBox = pokies[0].getName() + " used " + attackIn;
                    if(textBox.length() > 19){
                        splitText[0] = textBox.substring(0, 19);
                        splitText[1] = textBox.substring(19, textBox.length()) + spaces.substring(textBox.length()-19,spaces.length());}
                    else {splitText[0] = textBox.substring(0, textBox.length()) + spaces.substring(textBox.length(),spaces.length());}
                    menu = menuState.Battle;
                }

                // Select Pokemon Menu
                else if (line.equals("Pok")) {
                    menu = menuState.Pokemon;
                    print(player, computer, menu, currentTurn);

                    // Makes the player select a new VALID Pokemon. error handling be like
                    boolean hasChosenAPokemon = false;
                    while (!hasChosenAPokemon) {
                        System.out.println("Name of Pokemon");
                        String pokemonIn = in.nextLine();
                        if (!player.isInPokemonArray(pokemonIn)) {
                            System.out.println("Invalid Pokemon. Please Renter");
                            menu = menuState.Pokemon;
                            print(player, computer, menu, currentTurn);
                        }
                        else if (pokemonIn.contains("(Fainted)")) {
                            System.out.println("This Pokemon has Fainted. Select Another");
                            print(player, computer, menu, currentTurn);
                        } else {
                            player.switchCurrentPokemon(pokemonIn);
                            hasChosenAPokemon = true;
                        }
                        
                    }
                    menu = menuState.Battle;
                }

                // Select Bag Menu
                else if (line.equals("Bag")) {
                    menu = menuState.Bag;
                    print(player, computer, menu, currentTurn);
                    System.out.println("What item would you like to use?");
                    String itemIn = in.nextLine();
                    for(int i = 0;i < items.size();i++){
                        if(items.get(i).getName().equals(itemIn)){
                            player.removeFromBag(items.get(i));
                            textBox = player.getPlayerName() + " used " + items.get(i).getName();
                            if(textBox.length() > 19){
                                splitText[0] = textBox.substring(0, 19);
                                splitText[1] = textBox.substring(19, textBox.length()) + spaces.substring(textBox.length()-19,spaces.length());}
                            else {splitText[0] = textBox.substring(0, textBox.length()) + spaces.substring(textBox.length(),spaces.length());}
                        }
                    }
                    menu = menuState.Battle;
                }

                // End Game
                else if(line.equals("Run")) {
                    System.out.println("You ran away. Game over!");
                    System.exit(0);
                }
                // Test
                else if(line.equals("nothing")) {

                } 
                // Goodbye
                else {
                    System.exit(0);
                }
            }
            else {
                computerPokies[0].effectTick();
                // Selects New Pokemon For Computer. If All Pokemon Are Ded, End Game
                if(computer.getCurrentPokemon().getHP() <= 0) {
                    computer.getCurrentPokemon().setName(computer.getCurrentPokemon().getName() + " (Fainted)");
                    for(int i = 1; i <computer.getPokemons().length; i++) {
                        if(!computer.getPokemons()[i].getName().contains("(Fainted)")) {
                            computer.switchCurrentPokemon(computer.getPokemons()[i].getName());
                        }
                    }
                    if(computer.getPokemons()[0].getName().contains("(Fainted)")) {
                        System.out.println("YOU WON. COMPUTER LOST.");
                        System.exit(0);
                    }
                }

                // Computer's Turn
                System.out.println("Opponent's Turn: ");
                Random rand = new Random();
                int attackInt = rand.nextInt(computer.getPokemons()[0].getAttack().length);
                Attack computerAttack = computer.getPokemons()[0].getAttack()[attackInt];
                textBox = computer.getPokemons()[0].getName() + " used " + computerAttack.getName();
                if(textBox.length() > 19){
                    splitText[0] = textBox.substring(0, 19);
                    splitText[1] = textBox.substring(19, textBox.length()) + spaces.substring(textBox.length()-19,spaces.length());}
                else {splitText[0] = textBox.substring(0, textBox.length()) + spaces.substring(textBox.length(),spaces.length());}
                
                // Selects New Pokemon For Player If Fainted. Same Error Handling As Above
                player.getCurrentPokemon().setHP(
                        player.getCurrentPokemon().getHP() - computer.getCurrentPokemon().getAttack()[attackInt].power);
                if (player.getCurrentPokemon().getHP() <= 0) {
                    player.getCurrentPokemon().setName(player.getCurrentPokemon().getName() + " (Fainted)");
                    System.out.println("Your pokemon fainted");
                    boolean allPokemonFainted = true;
                    for(int i = 1; i <player.getPokemons().length; i++) {
                        if(!player.getPokemons()[i].getName().contains("(Fainted)")) {
                            allPokemonFainted = false;
                        }
                    }
                    if(allPokemonFainted) {
                        System.out.println("YOU LOST. COMPUTER WON.");
                        System.exit(0);
                    }
                    menu = menuState.Pokemon;
                    print(player, computer, menu, currentTurn);
                    boolean hasChosenAPokemon = false;
                    while(!hasChosenAPokemon) {
                        System.out.println("Name of Pokemon");
                        String pokemonIn = in.nextLine();
                        if(!player.isInPokemonArray(pokemonIn)) {
                            System.out.println("Invalid Pokemon. Please Renter");
                        }
                        else if(pokemonIn.contains("(Fainted)")) {
                            System.out.println("This Pokemon has Fainted");
                        }
                        else {
                            player.switchCurrentPokemon(pokemonIn);
                            hasChosenAPokemon = true;
                        }
                    }
                    
                    
                    menu = menuState.Battle;
                }
            }
            currentTurn++;
        }

    }

    // Prints Out Current Menu State (Code by Nico)
    public static void print(Player player1, Player computer, menuState menu, int turn) {
        //Nico did this part
        // Basically uses substring subtraction to make sure everything fits

        // Battle Menu
        if (menu == menuState.Battle) {

            // Part One of the Menu - Characters, Current Pokemon, HP and Players
            String HP = "HP: "+computer.pokemons[0].HP;
            String spaces = "                             ";
            System.out.print("*****************************\n*");
            System.out.println(computer.pokemons[0].toString()+spaces.substring(computer.pokemons[0].toString().length()+2,spaces.length())+"*\n*"+HP+spaces.substring(HP.length()+2,spaces.length())+"*");
            System.out.print("*                     0     *\n*                    -|-    *\n*                    / \\    *\n*                           *\n*     0                     *\n");
            String spaces1 = spaces.substring(0,20-player1.pokemons[0].toString().length());
            String playerLevelLine = "*    -|-"+spaces1+player1.pokemons[0].toString()+"*";
            String spaces2 = spaces.substring(0,20-("HP: "+player1.pokemons[0].HP).length());
            System.out.print(playerLevelLine+"\n*    / \\"+spaces2+"HP: "+player1.pokemons[0].HP+"*\n*---------------------------*\n");

            // Part Two of the Menu - Options for Moves, And Most Recent Move 
            System.out.println("*" +splitText[0]+"|Atk|Bag*");
            System.out.println("*"+splitText[1]+"|Pok|Run*");
            splitText[0] = "                   ";
            splitText[1] = "                   ";
            System.out.print("*****************************\n*");
        }

        // By Maitra But Using Nico's Code Base
        // Attack Menu (Atk)
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

        // Items Menu (Bag)
        else if (menu == menuState.Bag) {
            String spaces = "                             ";
            System.out.print("*****************************\n*");
            System.out.println("Items                      *" + "\n*---------------------------*");
            //  28
            for(int i = 0; i<player1.getItems().size(); i++) {
                String x = "*" +  player1.getItems().get(i).getQuantity() + "x " + player1.getItems().get(i).getName();
                System.out.println(x
                    + spaces.substring(0, 28 - x.length()) + "*");
            }
            System.out.print("*****************************\n*");
        } 

        // Pokemon Menu (Pok)
        else {
            String spaces = "                             ";
            System.out.print("*****************************\n*");
            System.out.println("Pokemon                    *" + "\n*---------------------------*");
            //  28
            for(int i = 0; i<player1.getPokemons().length; i++) {
                String x = "*LVL " + player1.getPokemons()[i].getLVL() + " " + player1.getPokemons()[i].getName();
                System.out.println(x
                    + spaces.substring(0, 28 - x.length()) + "*");
            }

            System.out.print("*****************************\n*");
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

        if((attack.getType() != Type.Ghost && attack.getType() != Type.Dragon && attack.getType() != Type.Normal && attack.getType() != Type.Bug && attack.getType() != Type.Flying
                && attack.getType() != Type.Fairy && attack.getType() != Type.Fighting && attack.getType() != Type.Rock && attack.getType() != Type.Ground) && (attack.getType() == pokemon.getType1() || attack.getType() == pokemon.getType2())){
            damage /= 2; //Type Resistance to itself applies to half of all types
        }   //Those that don't resist themselves include Ghost Dragon Normal Bug Flying Fairy Fighting Rock Ground

        if(attack.getType() == Type.Normal){ //Normal
            if(pokemon.getType1() == Type.Ghost || pokemon.getType2() == Type.Ghost){damage = 0;}

            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage /= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
        }
        else if(attack.getType() == Type.Fire){ //Fire
            if(pokemon.getType1() == Type.Bug || pokemon.getType2() == Type.Bug){damage *= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage *= 2;}
            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage *= 2;}
            if(pokemon.getType1() == Type.Ice || pokemon.getType2() == Type.Ice){damage *= 2;}

            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage /= 2;}
            if(pokemon.getType1() == Type.Water || pokemon.getType2() == Type.Water){damage /= 2;}
            if(pokemon.getType1() == Type.Dragon || pokemon.getType2() == Type.Dragon){damage /= 2;}
        }
        else if(attack.getType() == Type.Water){ //Water
            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage *= 2;}
            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage *= 2;}
            if(pokemon.getType1() == Type.Ground || pokemon.getType2() == Type.Ground){damage *= 2;}

            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage /= 2;}
            if(pokemon.getType1() == Type.Electric || pokemon.getType2() == Type.Electric){damage /= 2;}
        }
        else if(attack.getType() == Type.Grass){ //Grass
            if(pokemon.getType1() == Type.Water || pokemon.getType2() == Type.Water){damage *= 2;}
            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage *= 2;}
            if(pokemon.getType1() == Type.Ground || pokemon.getType2() == Type.Ground){damage *= 2;}

            if(pokemon.getType1() == Type.Flying || pokemon.getType2() == Type.Flying){damage /= 2;}
            if(pokemon.getType1() == Type.Poison || pokemon.getType2() == Type.Poison){damage /= 2;}
            if(pokemon.getType1() == Type.Bug || pokemon.getType2() == Type.Bug){damage /= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage /= 2;}
            if(pokemon.getType1() == Type.Dragon || pokemon.getType2() == Type.Dragon){damage /= 2;}
        }
        else if(attack.getType() == Type.Flying){ //Flying
            if(pokemon.getType1() == Type.Fighting || pokemon.getType2() == Type.Fighting){damage *= 2;}
            if(pokemon.getType1() == Type.Bug || pokemon.getType2() == Type.Bug){damage *= 2;}
            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage *= 2;}

            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage /= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
            if(pokemon.getType1() == Type.Electric || pokemon.getType2() == Type.Electric){damage /= 2;}
        }
        else if(attack.getType() == Type.Fighting){ //Fighting
            if(pokemon.getType1() == Type.Ghost || pokemon.getType2() == Type.Ghost){damage = 0;}

            if(pokemon.getType1() == Type.Normal || pokemon.getType2() == Type.Normal){damage *= 2;}
            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage *= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage *= 2;}
            if(pokemon.getType1() == Type.Ice || pokemon.getType2() == Type.Ice){damage *= 2;}
            if(pokemon.getType1() == Type.Dark || pokemon.getType2() == Type.Dark){damage *= 2;}

            if(pokemon.getType1() == Type.Flying || pokemon.getType2() == Type.Flying){damage /= 2;}
            if(pokemon.getType1() == Type.Poison || pokemon.getType2() == Type.Poison){damage /= 2;}
            if(pokemon.getType1() == Type.Bug || pokemon.getType2() == Type.Bug){damage /= 2;}
            if(pokemon.getType1() == Type.Psychic || pokemon.getType2() == Type.Psychic){damage /= 2;}
            if(pokemon.getType1() == Type.Fairy || pokemon.getType2() == Type.Fairy){damage /= 2;}
        }
        else if(attack.getType() == Type.Poison){ //Poison
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage = 0;}

            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage *= 2;}
            if(pokemon.getType1() == Type.Fairy || pokemon.getType2() == Type.Fairy){damage *= 2;}

            if(pokemon.getType1() == Type.Ground || pokemon.getType2() == Type.Ground){damage /= 2;}
            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage /= 2;}
            if(pokemon.getType1() == Type.Ghost || pokemon.getType2() == Type.Ghost){damage /= 2;}
        }
        else if(attack.getType() == Type.Electric){ //Electric
            if(pokemon.getType1() == Type.Ground || pokemon.getType2() == Type.Ground){damage = 0;}

            if(pokemon.getType1() == Type.Flying || pokemon.getType2() == Type.Flying){damage *= 2;}
            if(pokemon.getType1() == Type.Water || pokemon.getType2() == Type.Water){damage *= 2;}

            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage /= 2;}
            if(pokemon.getType1() == Type.Dragon || pokemon.getType2() == Type.Dragon){damage /= 2;}
        }
        else if(attack.getType() == Type.Ground){ //Ground
            if(pokemon.getType1() == Type.Flying || pokemon.getType2() == Type.Flying){damage = 0;}

            if(pokemon.getType1() == Type.Poison || pokemon.getType2() == Type.Poison){damage *= 2;}
            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage *= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage *= 2;}
            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage *= 2;}
            if(pokemon.getType1() == Type.Electric || pokemon.getType2() == Type.Electric){damage *= 2;}

            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage /= 2;}
            if(pokemon.getType1() == Type.Bug || pokemon.getType2() == Type.Bug){damage /= 2;}
        }
        else if(attack.getType() == Type.Rock){ //Rock
            if(pokemon.getType1() == Type.Flying || pokemon.getType2() == Type.Flying){damage *= 2;}
            if(pokemon.getType1() == Type.Bug || pokemon.getType2() == Type.Bug){damage *= 2;}
            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage *= 2;}
            if(pokemon.getType1() == Type.Ice || pokemon.getType2() == Type.Ice){damage *= 2;}

            if(pokemon.getType1() == Type.Fighting || pokemon.getType2() == Type.Fighting){damage /= 2;}
            if(pokemon.getType1() == Type.Ground || pokemon.getType2() == Type.Ground){damage /= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
        }
        else if(attack.getType() == Type.Psychic){ //Psychic
            if(pokemon.getType1() == Type.Dark || pokemon.getType2() == Type.Dark){damage = 0;}

            if(pokemon.getType1() == Type.Fighting || pokemon.getType2() == Type.Fighting){damage *= 2;}
            if(pokemon.getType1() == Type.Poison || pokemon.getType2() == Type.Poison){damage *= 2;}

            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
        }
        else if(attack.getType() == Type.Ice){ //Ice
            if(pokemon.getType1() == Type.Flying || pokemon.getType2() == Type.Flying){damage *= 2;}
            if(pokemon.getType1() == Type.Ground || pokemon.getType2() == Type.Ground){damage *= 2;}
            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage *= 2;}
            if(pokemon.getType1() == Type.Dragon || pokemon.getType2() == Type.Dragon){damage *= 2;}

            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage /= 2;}
            if(pokemon.getType1() == Type.Water || pokemon.getType2() == Type.Water){damage /= 2;}
        }
        else if(attack.getType() == Type.Bug){ //Bug
            if(pokemon.getType1() == Type.Grass || pokemon.getType2() == Type.Grass){damage *= 2;}
            if(pokemon.getType1() == Type.Psychic || pokemon.getType2() == Type.Psychic){damage *= 2;}
            if(pokemon.getType1() == Type.Dark || pokemon.getType2() == Type.Dark){damage *= 2;}

            if(pokemon.getType1() == Type.Fighting || pokemon.getType2() == Type.Fighting){damage /= 2;}
            if(pokemon.getType1() == Type.Flying || pokemon.getType2() == Type.Flying){damage /= 2;}
            if(pokemon.getType1() == Type.Poison || pokemon.getType2() == Type.Poison){damage /= 2;}
            if(pokemon.getType1() == Type.Ghost || pokemon.getType2() == Type.Ghost){damage /= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage /= 2;}
            if(pokemon.getType1() == Type.Fairy || pokemon.getType2() == Type.Fairy){damage /= 2;}
        }
        else if(attack.getType() == Type.Ghost){ //Ghost
            if(pokemon.getType1() == Type.Normal || pokemon.getType2() == Type.Normal){damage = 0;}

            if(pokemon.getType1() == Type.Ghost || pokemon.getType2() == Type.Ghost){damage *= 2;}
            if(pokemon.getType1() == Type.Psychic || pokemon.getType2() == Type.Psychic){damage *= 2;}

            if(pokemon.getType1() == Type.Dark || pokemon.getType2() == Type.Dark){damage /= 2;}
        }
        else if(attack.getType() == Type.Steel){ //Steel
            if(pokemon.getType1() == Type.Rock || pokemon.getType2() == Type.Rock){damage *= 2;}
            if(pokemon.getType1() == Type.Ice || pokemon.getType2() == Type.Ice){damage *= 2;}
            if(pokemon.getType1() == Type.Fairy || pokemon.getType2() == Type.Fairy){damage *= 2;}

            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage /= 2;}
            if(pokemon.getType1() == Type.Water || pokemon.getType2() == Type.Fairy){damage /= 2;}
            if(pokemon.getType1() == Type.Electric || pokemon.getType2() == Type.Steel){damage /= 2;}
        }
        else if(attack.getType() == Type.Dragon){ //Dragon
            if(pokemon.getType1() == Type.Fairy || pokemon.getType2() == Type.Fairy){damage = 0;}

            if(pokemon.getType1() == Type.Dragon || pokemon.getType2() == Type.Dragon){damage *= 2;}

            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
        }
        else if(attack.getType() == Type.Dark){ //Dark
            if(pokemon.getType1() == Type.Ghost || pokemon.getType2() == Type.Ghost){damage *= 2;}
            if(pokemon.getType1() == Type.Psychic || pokemon.getType2() == Type.Psychic){damage *= 2;}

            if(pokemon.getType1() == Type.Fighting || pokemon.getType2() == Type.Fighting){damage /= 2;}
            if(pokemon.getType1() == Type.Fairy || pokemon.getType2() == Type.Fairy){damage /= 2;}
        }
        else if(attack.getType() == Type.Fairy){ //Fairy
            if(pokemon.getType1() == Type.Fighting || pokemon.getType2() == Type.Fighting){damage *= 2;}
            if(pokemon.getType1() == Type.Dragon || pokemon.getType2() == Type.Dragon){damage *= 2;}
            if(pokemon.getType1() == Type.Dark || pokemon.getType2() == Type.Dark){damage *= 2;}

            if(pokemon.getType1() == Type.Poison || pokemon.getType2() == Type.Poison){damage /= 2;}
            if(pokemon.getType1() == Type.Steel || pokemon.getType2() == Type.Steel){damage /= 2;}
            if(pokemon.getType1() == Type.Fire || pokemon.getType2() == Type.Fire){damage /= 2;}
        }
        if(attack.getType() == attacker.Type1 || attack.getType() == attacker.Type2){
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