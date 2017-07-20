package uk.co.ksl.oms.service.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Order {

    private final User user;
    private final Product product;
    private final BuyOrSell buyOrSell;
    private final double tradedPrice;
    private final LocalDateTime transactionTime;
    private final ZoneId timeZone;

    public Order(User user, Product product, BuyOrSell buyOrSell, double tradedPrice, LocalDateTime transactionTime,
                 ZoneId
            timeZone) {
        this.user = user;
        this.product = product;
        this.buyOrSell = buyOrSell;
        this.tradedPrice = tradedPrice;
        this.transactionTime = transactionTime;
        this.timeZone = timeZone;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public BuyOrSell getBuyOrSell() {
        return buyOrSell;
    }

    public double getTradedPrice() {
        return tradedPrice;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }
}
