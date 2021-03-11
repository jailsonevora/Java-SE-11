package com.pm.app;

import com.pm.data.Drink;
import com.pm.data.Food;
import com.pm.data.Product;
import com.pm.data.Rating;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * {@code Shop} class represents an application that manages Products
 * @version 4.0
 * @author Sangha
 */
public class Shop {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args){

        Product p1 = new Drink(101,"Tea",BigDecimal.valueOf(1.99), Rating.THREE_STAR);
        Product p2 = new Drink(102,"Coffee",BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = new Food(103,"Cake",BigDecimal.valueOf(1.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = new Food(105,"Cookie",BigDecimal.valueOf(1.99), Rating.TWO_STAR, LocalDate.now());
        Product p5 = p3.applyingRating(Rating.THREE_STAR);
        Product p6 = new Drink(104,"Chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
        Product p7 = new Food(104,"Chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p8 = p4.applyingRating(Rating.FIVE_STAR);
        Product p9 = p1.applyingRating(Rating.TWO_STAR);
        System.out.println(p6.equals(p7));

       /* System.out.println(p1.getBestBefore());
        System.out.println(p3.getBestBefore());*/

        /*p1.setId(101);
        p1.setName("Tea");
        p1.setPrice(BigDecimal.valueOf(1.99));*/

        /*System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getPrice()+" "+p1.getDiscount()+" "+p1.getRating().getStars());
        System.out.println(p2.getId()+" "+p2.getName()+" "+p2.getPrice()+" "+p2.getDiscount()+" "+p2.getRating().getStars());
        System.out.println(p3.getId()+" "+p3.getName()+" "+p3.getPrice()+" "+p3.getDiscount()+" "+p3.getRating().getStars());
        System.out.println(p4.getId()+" "+p4.getName()+" "+p4.getPrice()+" "+p4.getDiscount()+" "+p4.getRating().getStars());
        System.out.println(p5.getId()+" "+p5.getName()+" "+p5.getPrice()+" "+p5.getDiscount()+" "+p5.getRating().getStars());
*/
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);
    }
}
