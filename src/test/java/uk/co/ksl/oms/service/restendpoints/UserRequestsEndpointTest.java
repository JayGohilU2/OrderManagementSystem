package uk.co.ksl.oms.service.restendpoints;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.ksl.oms.service.domain.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static uk.co.ksl.oms.service.domain.BuyOrSell.BUY;

@RunWith(MockitoJUnitRunner.class)
public class UserRequestsEndpointTest {

    @Mock OrderDAO orderDAO;
    @Mock LiveQuoteDAO liveQuoteDAO;
    @Mock ProductDAO productDAO;
    private UserRequestsEndpoint unit;
    private final Product ferrari = new Product("Ferrari");



    @Before
    public void beforeEachTest() {
        unit = new UserRequestsEndpoint(orderDAO, liveQuoteDAO, productDAO);
    }


    @Test
    public void testOfferAccepted() {
        when(productDAO.findProduct("Ferrari")).thenReturn(Optional.of(ferrari));
        LiveQuote ferrariQuote = new LiveQuote(ferrari, 35.0, 25.0,
                    LocalDateTime.now(), ZoneId.systemDefault());

        when(liveQuoteDAO.findLiveQuote(ferrari)).thenReturn(Optional.of(ferrariQuote));


        boolean wasOfferAccepted = unit.makeOffer("adam clayton", "U2", "Ferrari", "BUY", 40.00);
        assertTrue(wasOfferAccepted);

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderDAO).addOrder(orderCaptor.capture());

        Order order = orderCaptor.getValue();
        assertThat(order.getBuyOrSell(), is(BUY));
        assertThat(order.getProduct(), is(ferrari));
        assertThat(order.getTradedPrice(), is(ferrariQuote.getBuyPrice()));
    }

}