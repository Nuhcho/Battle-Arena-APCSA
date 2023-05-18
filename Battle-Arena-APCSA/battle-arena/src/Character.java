public class Character {
    private int health;
    private int level;
    private int attack;
    private int defense;
    private String name;
    private int points;
  
    public Character() {
      health = 5;
      attack = 5;
      level = 1;
      defense = 5;
      name = "";
      points = 0;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public void setAttack() {
      attack++;
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
  
    public void setPoints() {
      points++;
    }
  
    public int getPoints() {
      return points;
    }
  
    public int getLevel() {
      return level;
    }
  
    public String getStats() {
      return "Name: " + name + "\nLevel: " + level + "\nHealth: " + health + "\nPoints: " + points + "\nAttack: " + attack + "\nDefense: " + defense;
    }
      
  }
