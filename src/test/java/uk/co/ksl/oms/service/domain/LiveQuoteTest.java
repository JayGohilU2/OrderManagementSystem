package uk.co.ksl.oms.service.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.*;

public class LiveQuoteTest {

    private LiveQuote unit;

    @Before
    public void beforeEachTest() {
        final Product ferrari = new Product("Ferrari");
        unit = new LiveQuote(ferrari, 100.0, 90.0, LocalDateTime.now(), ZoneId.systemDefault());
    }

    @Test
    public void testMakeOfferForBuyIsSuccessful() {
        assertTrue(unit.makeOffer(BuyOrSell.BUY, 110.0));
    }

    @Test
    public void testMakeOfferForBuyIsNotSuccessful() {
        assertFalse(unit.makeOffer(BuyOrSell.BUY, 50.0));
    }


    @Test
    public void testMakeOfferForSellIsSuccessful() {
        assertTrue(unit.makeOffer(BuyOrSell.SELL, 85.0));
    }

    @Test
    public void testMakeOfferForSellIsNotSuccessful() {
        assertFalse(unit.makeOffer(BuyOrSell.SELL, 95.0));
    }

}