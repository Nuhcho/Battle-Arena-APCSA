public class Item {
    private String name;
    private String use;
    private int amount;

    public Item(String name, String use, int amount) {
        this.name = name;
        this.use = use;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getUse() {
        return use;
    }

    public int getAmount() {
        return amount;
    }
}
