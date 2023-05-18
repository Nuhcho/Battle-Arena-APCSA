import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

class Main {
  static ArrayList<Weapons> weapons;
  static ArrayList<Monsters> monsters;
  static Inventory inventory;
  static Character character;
  static double characterHealth;
  static int characterAttack;
  static int characterDefense;
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    character = new Character();
    inventory = new Inventory();
    weapons = new ArrayList<Weapons>();
    weapons.add(new Weapons("Royal's Broadsword"));
    weapons.add(new Weapons("Soldier's Broadsword"));
    weapons.add(new Weapons("Traveler's Broadsword"));
    weapons.add(new Weapons("Commoner's Broadsword"));
    weapons.add(new Weapons("Royal Elite's Broadsword"));

    monsters = new ArrayList<Monsters>();
    monsters.add(new Monsters("Goblin", 5, 5, 6));
    monsters.add(new Monsters("Golem", 300, 20, 100));
    monsters.add(new Monsters("Goblin King", 150, 50, 50));
    monsters.add(new Monsters("Troll", 15, 10, 7));
    monsters.add(new Monsters("Rat", 1, 1, 1));
    monsters.add(new Monsters("Rat King", 10, 10, 10));
    


    
    System.out.println("----------------------------");
    System.out.println("Welcome to the Battle Arena!");
    System.out.println("----------------------------");
    System.out.println(" Create Your Character [C]  ");
    System.out.println("        Exit [E]            ");
    System.out.println("----------------------------");
    String response = in.nextLine();

    if(response.equals("E")) {
      System.out.println("Are you sure? (Y/N)");
      String exit = in.nextLine();
      if(exit.equals("Y")) {
        System.out.println("Thank you for playing!");
        System.exit(0);
      }
      if(exit.equals("N")) {
        System.out.println("Thank you for deciding to stay");
      }
    }

    if(response.equals("C")) {
      System.out.println("----------------------");
      System.out.println("Create Your Character!");
      System.out.println("----------------------");
      
      System.out.println("What is your name, hero?");
      System.out.println("----------------------");
      String name = in.nextLine();
      System.out.println("----------------------");
      character.setName(name);
      System.out.println("It is a pleasure to meet you " + character.getName() + "!");
      System.out.println("----------------------");
      System.out.println("Please select your stats!");
      
      for(int i = 10; i > 0; i--) {
        System.out.println("----------------------");
        System.out.println("      Points: " + i + "      ");
        System.out.println("----------------------");
        System.out.println("  Choose Your Stats!  ");
        System.out.println("----------------------");
        System.out.println("       Attack [A]     ");
        System.out.println("----------------------");
        System.out.println("      Defense [D]     ");
        System.out.println("----------------------");
        System.out.println("       Health [H]     ");
        System.out.println("----------------------");
        String usePoints = in.nextLine();

        if(usePoints.equals("A")) {
          character.setAttack();
          System.out.println("Attack: " + character.getAttack());
          System.out.println("");
        }

        else if(usePoints.equals("D")) {
          character.setDefense();
          System.out.println("Defense: " + character.getDefense());
          System.out.println("");
        }

        else if(usePoints.equals("H")) {
          character.setHealth();
          System.out.println("Health: " + character.getHealth());
          System.out.println("");
        }
        else {
            System.out.println("That is not a valid choice");
            System.out.println("");
            i +=1;
        }
      }

      System.out.println("Your character has successfully been created");
      System.out.println("Name: " + character.getName() + "\nHealth: " + character.getHealth() + "\nAttack: " + character.getAttack() + "\nDefense: " + character.getDefense() + "\nPoints: " + character.getPoints());
    }

    characterHealth = character.getHealth();
    characterAttack = character.getAttack();
    characterDefense = character.getDefense();

    System.out.println("----------------------");
    System.out.println("Welcome to the Battle Arena");
    System.out.println("Press H for a list of commands.");
    while(characterHealth > 0) {
      System.out.println(game());
    }
    System.out.println("Thanks for playing!");

    
  }

  public static String game() {
    Scanner in = new Scanner(System.in);
    System.out.println("Press B to begin your next battle.");
    String button = in.nextLine();
    if(button.equals("H")) {
      System.out.println("----------------------");
      System.out.println("Here are the commands");
      System.out.println("H : Help\nB : Battle\nI : Inventory\nD: Drop\nA : Armor\nW : Weapon\n F : Food\nE: Exit\nU : Use");
    }
    if(button.equals("B")) {
      int random = (int) (Math.random()  * monsters.size());
      int monsterDefense = monsters.get(random).getDefense();
      int monsterAttack = monsters.get(random).getAttack();
      double monsterHealth = monsters.get(random).getHealth();
      System.out.println("Your opponent is: " + monsters.get(random).getName());
      System.out.println(monsterHealth + "  " + characterHealth);
      while(monsterHealth > 0 && characterHealth > 0) {
        System.out.println("A : Attack    G : Guard      U : Use Item");
        String battleChoice = in.nextLine();
        if(battleChoice.equals("A")) {
            System.out.println("Attacking...");
            if(characterAttack - monsterDefense > 0) {
                monsterHealth -= (((2 * characterAttack - monsterDefense) * 0.5) + characterAttack);
            }
            else {
                monsterHealth -= characterAttack;
            }
            if((monsterAttack - (characterDefense * 5)) > 0) {
                characterHealth -= ((monsterAttack - (characterDefense * 5)));
            }
            else {
                characterHealth -= 2;
            }
        }
        if(battleChoice.equals("G")) {
            characterHealth -= 1;
        }
        if(battleChoice.equals("U")) {
            inventory.getInventory();
            System.out.println("");
        }
      }
      if(characterHealth <= 0) {
        System.out.println("You Died... Thanks for playing!");
        System.exit(0);
      }

      else {
        System.out.println("Monster Defeated!");
      }
    }

    
    
    return "";
  }
}
