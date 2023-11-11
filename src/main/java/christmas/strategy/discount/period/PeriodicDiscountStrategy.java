package christmas.strategy.discount.period;

import christmas.constant.event.DiscountType;
import christmas.domain.order.Orders;
import christmas.strategy.discount.DiscountStrategy;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import java.time.LocalDate;
import java.util.Optional;

/**
 * 주기적으로 적용되는 할인 전략을 위한 추상 클래스.
 */
public abstract class PeriodicDiscountStrategy implements DiscountStrategy {

    protected LocalDate discountDate; // 할인 적용 기간을 정의하는 날짜

    public PeriodicDiscountStrategy(LocalDate discountDate) {
        this.discountDate = discountDate;
    }

    /**
     * 주어진 주문과 날짜에 대해 할인을 계산한다.
     *
     * @param orders 주문 객체
     * @return 할인이 적용된 경우, Optional<Discount> 객체를 반환한다.
     */
    public Optional<Discount> evaluateDiscount(Orders orders) {
        return Optional.of(discountDate)
                .filter(this::isApplicable)
                .map(date -> calculateDiscount(orders, date))
                .map(amount -> createDiscount(amount, getDiscountType()));
    }

    @Override
    public abstract boolean isApplicable(LocalDate date);

    /**
     * 주어진 주문과 날짜에 따라 할인 금액을 계산한다.
     */
    protected abstract int calculateDiscount(Orders orders, LocalDate date);

    /**
     * 할인 금액과 유형을 바탕으로 Discount 객체를 생성한다.
     */
    protected Discount createDiscount(int discountAmount, DiscountType discountType) {
        return new Discount(discountType, new DiscountAmount(discountAmount));
    }

    /**
     * 할인 유형을 반환한다.
     *
     * @return 할인 유형
     */
    protected abstract DiscountType getDiscountType();
}
