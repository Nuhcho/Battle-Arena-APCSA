public class Monsters {
    private int health;
    private String name;
    private int attack;
    private int defense;
  
    public Monsters(String name, int health, int attack, int defense) {
      this.health = health;
      this.name = name;
      this.attack = attack;
      this.defense = defense;
    }
  
    public String getName() {
      return name;
    }
  
    public int getAttack() {
      return attack;
    }
  
    public int getDefense() {
      return defense;
    }
  
    public int getHealth() {
      return health;
    }
    
  }
