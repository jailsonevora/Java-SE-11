package com.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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
public abstract class Product {

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

    Product(){
        this(0, "No name", BigDecimal.ZERO);
    }

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    public int getId() {
        return id;
    }
/*    public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

/*    public void setName(String name) {
        this.name = name;
    }*/

    public BigDecimal getPrice() {
        return price;
    }

/*    public void setPrice(BigDecimal price) {
        this.price = price;
    }*/

    /**
     * Calculates discount based on a product price and
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link java.math.BigDecimal BigDecimal} value of the discount
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    /**
     * Get the value of the best before date for the product
     *
     * @return the value of the bestBefore
     */
    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    public abstract Product applyingRating(Rating newRating);/*{
        return new Product(this.id, this.name, this.price, newRating);
    }*/

    @Override
    public String toString() {
        return id +
                ", " + name +
                ", " + price +
                ", " + getDiscount() +
                ", " + rating.getStars() +
                ", " + getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if(o instanceof Product){
            Product product = (Product) o;
            return id == product.id && Objects.equals(name, product.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
