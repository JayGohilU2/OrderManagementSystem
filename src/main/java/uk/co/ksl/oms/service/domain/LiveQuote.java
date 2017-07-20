package uk.co.ksl.oms.service.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static uk.co.ksl.oms.service.domain.BuyOrSell.BUY;

public class LiveQuote {
    private final Product product;
    private final double buyPrice;
    private final double sellPrice;
    private final LocalDateTime timeOfQuote;
    private final ZoneId timeZoneOfQuote;

    public LiveQuote(Product product, double buyPrice, double sellPrice, LocalDateTime timeOfQuote, ZoneId timeZoneOfQuote) {
        this.product = product;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.timeOfQuote = timeOfQuote;
        this.timeZoneOfQuote = timeZoneOfQuote;
    }

    public boolean makeOffer(BuyOrSell buyOrSell, double offer) {
        if (buyOrSell == BUY) {
            return makeOfferForBuy(offer);
        }
        else {
            return makeOfferForSell(offer);
        }
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice(BuyOrSell buyOrSell) {
        if (buyOrSell == BUY) {
            return buyPrice;
        }
        else {
            return sellPrice;
        }
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public LocalDateTime getTimeOfQuote() {
        return timeOfQuote;
    }

    public ZoneId getTimeZoneOfQuote() {
        return timeZoneOfQuote;
    }

    private boolean makeOfferForBuy(double offer) {
        return (offer >= buyPrice);
    }


    private boolean makeOfferForSell(double offer) {
        return (offer <= sellPrice);
    }

}
