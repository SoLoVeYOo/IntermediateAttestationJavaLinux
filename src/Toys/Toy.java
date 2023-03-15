package Toys;

public abstract class Toy {
    protected Integer id;
    protected String name;
    protected Integer quantity;
    protected Integer winningСhance;

    public Toy(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.winningСhance = winningСhance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getWinningСhance() {
        return winningСhance;
    }

    public void setWinningСhance(Integer winningСhance) {
        this.winningСhance = winningСhance;
    }

    @Override
    public String toString() {
        return name;
    }

}
