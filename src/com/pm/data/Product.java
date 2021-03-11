package com.pm.data;

import java.math.BigDecimal;
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

    public Product(){
        this(0, "No name", BigDecimal.ZERO);
    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
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

    public Product applyingRating(Rating newRating){
        return new Product(this.id, this.name, this.price, newRating);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
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
