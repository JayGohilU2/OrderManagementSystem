package uk.co.ksl.oms.service.restendpoints;

import uk.co.ksl.oms.service.domain.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

public class UserRequestsEndpoint {
    public UserRequestsEndpoint(OrderDAO orderDAO, LiveQuoteDAO liveQuoteDAO, ProductDAO productDAO) {
        this.orderDAO = orderDAO;
        this.liveQuoteDAO = liveQuoteDAO;
        this.productDAO = productDAO;
    }

    private final OrderDAO orderDAO;
    private final LiveQuoteDAO liveQuoteDAO;
    private final ProductDAO productDAO;


    public List<Order> findOrderForUser(final String username, final String company) {
        User user = new User(username, company);
        return orderDAO.findOrders(user);
    }

    public boolean makeOffer(final String username, final String company, final String productName, final String buyOrSellStr, final double offer) {
        Optional<Product> productOpt = productDAO.findProduct(productName);
        if (!productOpt.isPresent()) {
            return false;
        }

        Product product = productOpt.get();
        Optional<LiveQuote> liveQuote = liveQuoteDAO.findLiveQuote(productOpt.get());

        if (!liveQuote.isPresent()) {
            return false;
        }

        BuyOrSell buyOrSell = BuyOrSell.valueOf(buyOrSellStr);
        if (liveQuote.get().makeOffer(buyOrSell, offer)) {
            User user = new User(username, company);
            Order order = new Order(user, product, buyOrSell, liveQuote.get().getPrice(buyOrSell), LocalDateTime.now(), ZoneId
                    .systemDefault());
            orderDAO.addOrder(order);
            return true;
        }
        return false;
    }
}
