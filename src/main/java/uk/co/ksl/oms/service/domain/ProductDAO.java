package uk.co.ksl.oms.service.domain;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductDAO {
    private Map<String, Product> productMap = Maps.newHashMap();


    public ProductDAO() {
        Product product1 = new Product("Ford Fiesta");
        Product product2 = new Product( "Ferrari");
        productMap.put(product1.getName(), product1);
        productMap.put(product2.getName(), product2);
    }

    public Map<String,Product> getAllProducts() {
        return Maps.newHashMap(productMap);
    }

    public Optional<Product> findProduct(final String name) {
        return Optional.ofNullable(productMap.get(name));

    }
}
