public class Weapons{
    private String name;
    private int durability;
    private int damage;
  
    public Weapons(String name) {
      this.name = name;
      if(name.contains("Knight")) {
        durability = 20;
        damage = 105;
      }
      else if(name.contains("Royal")) {
        durability = 80;
        damage = 80;
      }
  
      else if(name.contains("Soldier")) {
        durability = 60;
        damage = 65;
      }
  
      else if(name.contains("Traveler")) {
        durability = 30;
        damage = 35;
      }
  
      else if(name.contains("Commoner")) {
        durability = 10;
        damage = 20;
      }  
    }
  
    public int getDamage() {
      return damage;
    }
  
    public String getName() {
      return name;
    }
  
    public int getDurability() {
      return durability;
    }
  }
