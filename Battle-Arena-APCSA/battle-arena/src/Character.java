public class Character {
    private int health;
    private int attack;
    private int defense;
    private String name;
  
    public Character() {
      health = 5;
      attack = 5;
      defense = 5;
      name = "";
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public void setAttack() {
      attack++;
    }

    public void setAttack(int amount) {
      attack += amount;
    }

    public void setDefense(int amount) {
      defense += amount;
    }

    public void setHealth(int amount) {
      health += amount;
    }
  
    public void setDefense() {
      defense++;
    }
  
    public void setHealth() {
      health++;
    }
  
    public String getName() {
      return name;
    }
  
    public int getDefense() {
      return defense;
    }
  
    public int getAttack() {
      return attack;
    }
  
    public int getHealth() {
      return health;
    }

  
    public String getStats() {
      return "Name: " + name + "\nHealth: " + health + "\nAttack: " + attack + "\nDefense: " + defense;
    }
      
  }
