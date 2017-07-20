package uk.co.ksl.oms.service.domain;

import java.util.Objects;

public class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object thatObj) {
       if (thatObj == null) {
           return false;
       }

       if (this == thatObj) {
           return true;
       }

       if (thatObj.getClass() != Product.class) {
           return false;
       }

       Product that = (Product)thatObj;
       return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
