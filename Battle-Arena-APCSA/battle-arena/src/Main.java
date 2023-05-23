import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

class Main {
  static ArrayList<Weapons> weapons;
  static ArrayList<Monsters> monsters;
  static ArrayList<Item> items;
  static ArrayList<Armor> armor;
  static Inventory inventory;
  static Character character;
  static double characterHealth;
  static int characterAttack;
  static int characterDefense;
  static int roundsSurvived;
  static String[] wornArmor;
  static Weapons heldWeapon;
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    character = new Character();
    inventory = new Inventory();
    wornArmor = new String[4];

    armor = new ArrayList<Armor>();
    armor.add(new Armor("Leather Helmet", 5));
    armor.add(new Armor("Leather Chestplate" , 8));
    armor.add(new Armor("Leather Pants", 7));
    armor.add(new Armor("Leather Boots", 4));
    armor.add(new Armor("Gold Helmet", 10));
    armor.add(new Armor("Gold Chestplate" , 16));
    armor.add(new Armor("Gold Pants", 14));
    armor.add(new Armor("Gold Boots", 8));
    armor.add(new Armor("Steel Helmet", 20));
    armor.add(new Armor("Steel Chestplate" , 32));
    armor.add(new Armor("Steel Pants", 28));
    armor.add(new Armor("Steel Boots", 16));

    items = new ArrayList<Item>();
    items.add(new Item("Red Healing Potion", "Health", 5));
    items.add(new Item("Blue Healing Potion", "Health", 20));
    items.add(new Item("Green Healing Potion", "Health", 20));
    items.add(new Item("Red Attack Buff", "Attack", 5));
    items.add(new Item("Blue Attack Buff", "Attack", 20));
    items.add(new Item("Green Attack Buff", "Attack", 20));
    items.add(new Item("Red Defense Buff", "Defense", 5));
    items.add(new Item("Blue Defense Buff", "Defense", 20));
    items.add(new Item("Green Defense Buff", "Defense", 20));


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
    
    roundsSurvived = 0;

    
    System.out.println("----------------------------");
    System.out.println("Welcome to the Battle Arena!");
    System.out.println("----------------------------");
    System.out.println(" Create Your Character [C]  ");
    System.out.println("        Exit [E]            ");
    System.out.println("----------------------------");
    String response = in.nextLine();

    if(!response.equals("E") && !response.equals("C")) {
      System.out.println("Please pick either C or E");
    }

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
      System.out.println("Name: " + character.getName() + "\nHealth: " + character.getHealth() + "\nAttack: " + character.getAttack() + "\nDefense: " + character.getDefense());
    }

    characterHealth = character.getHealth();
    characterAttack = character.getAttack();
    characterDefense = character.getDefense();

    System.out.println("----------------------");
    System.out.println("Welcome to the Battle Arena");
    while(characterHealth > 0) {
      System.out.println(game());
    }
    System.out.println("Thanks for playing!");
    System.out.println("You survived this many rounds: " + roundsSurvived);

    
  }

  public static String game() {
    Scanner in = new Scanner(System.in);
    System.out.println("Press H for a list of commands.");
    System.out.println("Press B to begin your next battle.");
    String button = in.nextLine();

    int armorCount = 0;
    int setcount = 0;
    for(int i = 0; i < inventory.getInventory().length; i++) {
      for(int j = 0; j < inventory.getInventory()[0].length; j++) {
        if(inventory.getInventory()[i][j] == null) {
          continue;
        }
        if(inventory.getInventory()[i][j].contains("Helmet")) {
          wornArmor[armorCount] = inventory.getInventory()[i][j];
          setcount++;
          armorCount++;
        }
        if(inventory.getInventory()[i][j].contains("Chestplate")) {
          wornArmor[armorCount] = inventory.getInventory()[i][j];
          setcount++;
          armorCount++;
        }
        if(inventory.getInventory()[i][j].contains("Pants")) {
          wornArmor[armorCount] = inventory.getInventory()[i][j];
          setcount++;
          armorCount++;
        }
        if(inventory.getInventory()[i][j].contains("Boots")) {
          wornArmor[armorCount] = inventory.getInventory()[i][j];
          setcount++;
          armorCount++;
        }
      }
      if(setcount == 4) {
        break;
      }
    }
  

    for(int i = 0; i < inventory.getInventory().length; i++) {
      for(int j = 0; j < inventory.getInventory()[0].length; j++) {
        if(inventory.getInventory()[i][j] == null) {
          continue;
        }
        if(inventory.getInventory()[i][j].contains("Broadsword")) {
          for(int a = 0; a < weapons.size(); a++) {
            if(weapons.get(a).getName().equals(inventory.getInventory()[i][j])) {
              heldWeapon = weapons.get(a);
              character.setAttack(heldWeapon.getDamage());
            }
          }
        }
      }
    }

    if(button.equals("H")) {
      System.out.println("----------------------");
      System.out.println("Here are the commands");
      System.out.println("H : Help\nB : Battle\nI : Inventory\nD: Drop\nA : Armor\nW : Weapon\nE: Exit\nU : Use");
    }

    if(button.equals("A")) {
      System.out.println("Your armor worn is considered the first of each type of armor in your inventory");
      System.out.println("Your current armor is: ");
      for(int i = 0; i < wornArmor.length; i++) {
        System.out.println(wornArmor[i]);
        for(int j = 0; j < armor.size(); j++) {
          if(wornArmor[i] == null) {
            continue;
          }
          if(wornArmor[i].equals(armor.get(j).getName())) {
            character.setDefense(armor.get(j).getDefense());
          }
        }
      }
    }

    if(button.equals("E")) {
      System.out.println("Are you sure that you want to quit? (Y/N)");
      String exitResponse = in.nextLine();
      if(exitResponse.equals("Y")) {
        System.exit(0);
      }
      else {
        System.out.println("Thanks for staying!");
      }
    }

    if(button.equals("W")) {
      System.out.println("Your weapon selected is the first weapon in your inventory");
      System.out.print("Your current weapon is: ");
      try {
        System.out.println(heldWeapon.getName());
      } catch (NullPointerException e) {
          System.out.println("None");
      }

    }

    if(button.equals("D")) {
      inventory.printInventory();
      System.out.println("Please select the row and column of the item you wish to drop (Start at 0 and 0)");
      String positionOfItemDrop = in.nextLine();
      positionOfItemDrop.trim();
      System.out.println("Are you sure you would like to drop this item. Once dropped it cannot be picked back up again. (Y/N)");
      String dropChoice = in.nextLine();
      if(dropChoice.equals("Y")) {
        inventory.getInventory()[Integer.valueOf(positionOfItemDrop.substring(0,1))][Integer.valueOf(positionOfItemDrop.substring(2,3))] = null;
      }
      else {
        System.out.println("No item has been dropped");
      }
    }

    if(button.equals("I")) {
      inventory.printInventory();
            System.out.println("");
            System.out.println("Would you like to edit your inventory? (Y/N)");
            String inventoryChoice = in.nextLine();
            if(inventoryChoice.equals("Y")) {
              System.out.println("Select the item you want to move or use (Row and Column Position)");
              String position = in.nextLine();
              position.trim();
              System.out.println("Select the spot that you want to replace it with");
              String newPosition = in.nextLine();
              newPosition.trim();
              String temp = inventory.getInventory()[Integer.valueOf(newPosition.substring(0,1))][Integer.valueOf(newPosition.substring(2,3))];
              inventory.getInventory()[Integer.valueOf(newPosition.substring(0, 1))][Integer.valueOf(newPosition.substring(2, 3))] = inventory.getInventory()[Integer.valueOf(position.substring(0,1))][Integer.valueOf(position.substring(2,3))];
              inventory.getInventory()[Integer.valueOf(position.substring(0,1))][Integer.valueOf(position.substring(2,3))] = temp;
            }
    }



    if(button.equals("B")) {
      int random = (int) (Math.random()  * monsters.size());
      int monsterDefense = monsters.get(random).getDefense();
      int monsterAttack = monsters.get(random).getAttack();
      double monsterHealth = monsters.get(random).getHealth();
      System.out.println("Your opponent is: " + monsters.get(random).getName());
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
            if(monsterHealth > 0) {
              if((monsterAttack - (characterDefense * 5)) > 0) {
                characterHealth -= ((monsterAttack - (characterDefense * 5)));
              }
              else {
                  characterHealth -= 2;
              }
            }
        }
        if(battleChoice.equals("G")) {
            characterHealth -= 1;
        }
        if(battleChoice.equals("U")) {
            inventory.printInventory();
            System.out.println("");
            System.out.println("Would you like to use an item? (Y/N)");
            String inventoryChoice = in.nextLine();
            if(inventoryChoice.equals("Y")) {
              System.out.println("Select the row and column position of the item you want to use starting at 0 0");
              String position = in.nextLine();
              position.trim();
              for(int i = 0; i < items.size(); i++) {
                if(items.get(i).getName().equals(inventory.getInventory()[Integer.valueOf(position.substring(0,1))][Integer.valueOf(position.substring(2,3))])) {
                  System.out.println("Using item");
                  if(items.get(i).getName().contains("Healing")) {
                    character.setHealth(items.get(i).getAmount());
                  }
                  else if(items.get(i).getName().contains("Attack")) {
                    character.setAttack(items.get(i).getAmount());
                  }
                  else {
                    character.setDefense(items.get(i).getAmount());
                  }
                }
                inventory.getInventory()[Integer.valueOf(position.substring(0,1))][Integer.valueOf(position.substring(2,3))] = null;
                break;
              }
            } 
        }
      }
      if(monsterHealth <= 0) {
        System.out.println("Monster Defeated!");
        roundsSurvived++;
        for(int a = 0; a < inventory.getInventory().length; a++) {
          for(int b = 0; b < inventory.getInventory()[0].length; b++) {
            if((inventory.getInventory()[a][b] == null)) {
              int randomType = (int) (Math.random() * 3);
              if(randomType == 0) {
                int randomPiece = (int) (Math.random() * items.size());
                Item actualPiece = items.get(randomPiece);
                inventory.getInventory()[a][b] = actualPiece.getName();
                break;
              }
              if(randomType == 1) {
                int randomPiece = (int) (Math.random() * armor.size());
                Armor actualPiece = armor.get(randomPiece);
                inventory.getInventory()[a][b] = actualPiece.getName();
                break;
              }
              else {
                int randomPiece = (int) (Math.random() * weapons.size());
                Weapons actualPiece = weapons.get(randomPiece);
                inventory.getInventory()[a][b] = actualPiece.getName();
                break;
              }

            }
          }
          break;
        }
      }

      
    } 


    return "";


  }



}
