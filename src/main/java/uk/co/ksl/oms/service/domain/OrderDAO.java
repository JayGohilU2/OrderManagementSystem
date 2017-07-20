package uk.co.ksl.oms.service.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static uk.co.ksl.oms.service.domain.BuyOrSell.BUY;
import static uk.co.ksl.oms.service.domain.BuyOrSell.SELL;

public class OrderDAO {

    private final ProductDAO productDAO;
    private final List<Order> orders;

    public OrderDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
        this.orders = loadAllOrders();
    }

    public List<Order> findOrders(final User user) {
        return orders.stream().filter(order->order.getUser().equals(user)).collect(Collectors.toList());
    }


    public List<Order> loadAllOrders() {
        User bono = new User("Bono", "U2");
        User theEdge = new User("The Edge", "U2");

        Optional<Product> ferrari = productDAO.findProduct("Ferrari");
        Optional<Product> fiesta = productDAO.findProduct("Ford Fiesta");

        Order order1 = new Order(bono, ferrari.get(), BUY, 45.0, LocalDateTime.now(), ZoneId.systemDefault());
        Order order2 = new Order(bono, fiesta.get(), BuyOrSell.SELL, 15.0, LocalDateTime.now(), ZoneId.systemDefault());

        Order order3 = new Order(theEdge, ferrari.get(), BuyOrSell.BUY, 48.0, LocalDateTime.now(), ZoneId.systemDefault());
        Order order4 = new Order(theEdge, fiesta.get(), BuyOrSell.SELL, 17.0, LocalDateTime.now(), ZoneId.systemDefault());

        return ImmutableList.of(order1, order2, order3, order4);
    }

    public void addOrder(final Order order) {
        orders.add(order);
    }
}
