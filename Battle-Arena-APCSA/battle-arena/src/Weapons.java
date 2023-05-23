public class Weapons{
    private String name;
    private int damage;
  
    public Weapons(String name) {
      this.name = name;
      if(name.contains("Knight")) {
        damage = 105;
      }
      else if(name.contains("Royal")) {
        damage = 80;
      }
  
      else if(name.contains("Soldier")) {
        damage = 65;
      }
  
      else if(name.contains("Traveler")) {
        damage = 35;
      }
  
      else if(name.contains("Commoner")) {
        damage = 20;
      }  
    }
  
    public int getDamage() {
      return damage;
    }
  
    public String getName() {
      return name;
    }

  }
