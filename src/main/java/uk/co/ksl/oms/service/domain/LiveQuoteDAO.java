package uk.co.ksl.oms.service.domain;

import com.google.common.collect.Maps;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;

public class LiveQuoteDAO {

    private final ProductDAO productDao;

    public LiveQuoteDAO(ProductDAO productDao) {
        this.productDao = productDao;
    }


    public Map<Product,LiveQuote> getQuotesForAllProducts() {
        Map<String, Product> productMap = productDao.getAllProducts();
        Product fiesta = productMap.get("Ford Fiesta");
        LiveQuote fiestaLiveQuote = new LiveQuote(fiesta, 10000.0, 9600.0, LocalDateTime.now(),
                ZoneId.systemDefault());

        Product ferrari = productMap.get("Ferrari");
        LiveQuote ferrariLiveQuote = new LiveQuote(ferrari, 100000.0, 950000.0, LocalDateTime.now(), ZoneId.systemDefault());

        Map<Product,LiveQuote> liveQuotes = Maps.newHashMap();
        liveQuotes.put(fiesta, fiestaLiveQuote);
        liveQuotes.put(ferrari, ferrariLiveQuote);
        return liveQuotes;
    }

    public Optional<LiveQuote> findLiveQuote(final Product product) {
        Map<Product, LiveQuote> quotesForAllProducts = getQuotesForAllProducts();
        return Optional.ofNullable(quotesForAllProducts.get(product));
    }

}
