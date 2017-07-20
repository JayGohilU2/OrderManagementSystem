package uk.co.ksl.oms.service.restendpoints;


import org.springframework.web.bind.annotation.RestController;
import uk.co.ksl.oms.service.domain.LiveQuote;
import uk.co.ksl.oms.service.domain.LiveQuoteDAO;
import uk.co.ksl.oms.service.domain.Product;

import java.util.Map;

    public class TradeableProductsRestEndpoint {


    private final LiveQuoteDAO liveQuoteDao;

    public TradeableProductsRestEndpoint(final LiveQuoteDAO liveQuoteDao) {
        this.liveQuoteDao = liveQuoteDao;
    }


    public Map<Product, LiveQuote> liveProducts() {
        return liveQuoteDao.getQuotesForAllProducts();
    }

}
