package christmas.vo;

public class TotalAmount {
    private final int amount;

    private TotalAmount(int amount) {
        this.amount = amount;
    }

    public static TotalAmount from(int amount) {
        return new TotalAmount(amount);
    }

    public int getAmount() {
        return amount;
    }
}
