public class Inventory {
    private String[][] inventory;
  
    public Inventory() {
      inventory = new String[9][9];
    }

    public void printInventory() {
        for(int i = 0; i < inventory.length; i++) {
            System.out.println("");
            for(int j = 0; j < inventory[0].length; j++) {
                System.out.print("{ " + inventory[i][j] + " } ");
            }
        }
    }

    public String[][] getInventory() {
      return inventory;
    }
  }
