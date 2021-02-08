package com.saucedemo.entities;

import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private String postalCode;

    public Customer(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.postalCode = builder.postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(postalCode, customer.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, postalCode);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + firstName + '\'' +
                ", description='" + lastName + '\'' +
                ", price=" + postalCode +
                '}';
    }

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String postalCode;

        public Builder() {}

        public Builder (Customer origin) {
            this.firstName = origin.firstName;
            this.lastName = origin.lastName;
            this.postalCode = origin.postalCode;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
