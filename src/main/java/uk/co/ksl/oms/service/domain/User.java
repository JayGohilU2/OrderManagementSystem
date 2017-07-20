package uk.co.ksl.oms.service.domain;

import java.util.Objects;

public class User {
    private final String name;
    private final String company;

    public User(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object thatObj) {
        if (thatObj == null) {
            return false;
        }

        if (this == thatObj) {
            return true;
        }

        if (thatObj.getClass() != User.class) {
            return false;
        }

        User that = (User) thatObj;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.company, that.company);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }
}
