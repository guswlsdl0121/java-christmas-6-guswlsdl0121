package christmas.vo.order;

public record TotalAmount(int amount) {

    public boolean isEqualOrGreater(int threshold) {
        return this.amount >= threshold;
    }

    public int divideBy(int divisor) {
        return amount / divisor;
    }

    public int calculateDiscountedAmount(int discountSum) {
        return amount - discountSum;
    }
}
