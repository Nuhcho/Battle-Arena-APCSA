public class Inventory {
    private String[][] inventory;
    private int row;
    private int column;
  
    public Inventory() {
      inventory = new String[9][9];
      row = 0;
      column = 0;
    }
  
    public void setInventory(Weapons weapon) {
      if(column >= inventory[0].length) {
        column = 0;
        row += 1;
        inventory[row][column] = weapon.getName();
      }
  
      if(row >= inventory.length) {
        System.out.println("Inventory is full.");
        System.out.println("Please drop an item.");
      }
  
      else {
        inventory[row][column] = weapon.getName();
      }
    }

    public void getInventory() {
        for(int i = 0; i < inventory.length; i++) {
            System.out.println("");
            for(int j = 0; j < inventory[0].length; j++) {
                System.out.print("{ " + inventory[i][j] + " } ");
            }
        }
    }
  }
