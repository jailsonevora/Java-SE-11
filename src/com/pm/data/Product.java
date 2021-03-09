package com.pm.data;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

/**
 * {@code Product} class represents properties and behaviours of
 * product objects in the PMS
 * <br>
 *     Each product has a discount, calculated based on a
 *     {@link DISCOUNT_RATE discount rate}
 * @version 4.0
 * @author Sangha
 */
public class Product {

    /**
     * A constant that defines a
     * {@link java.math.BigDecimal BigDecimal} value of discount rate
     * <br>
     *     Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Calculates discount based on a product price and
     * {@link DISCOUNT_RATE discount rate}
     *
     * return a {@link java.math.BigDecimal BigDecimal} value of the discount
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    /**
     *
     */
    public Rating getRating() {
        return rating;
    }
}
