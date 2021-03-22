package com.pm.app;

import com.pm.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        ProductManager pm = ProductManager.getInstance();

        AtomicInteger clientCount = new AtomicInteger();
        Callable<String> client = () -> {
            String clientId = "Client "+ clientCount.incrementAndGet();
            String threadName = Thread.currentThread().getName();
            int productId = ThreadLocalRandom.current().nextInt(63)+101;
            String languageTag = ProductManager.getSupportedLocales()
                    .stream()
                    .skip(ThreadLocalRandom.current().nextInt(4))
                    .findFirst().get();
            StringBuilder log = new StringBuilder();
            log.append(clientId+" "+threadName+"\n-\tstart of log\t-\n");
            log.append(pm.getDiscounts(languageTag)
            .entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + "\t" + entry.getValue())
                    .collect(Collectors.joining("\n"))
            );
            Product product = pm.reviewProduct(productId, Rating.FOUR_STAR, "Yet another review");
            log.append((product != null) ? "\nProduct "+productId+" reviewed\n" : "\nProduct "+productId" not reviewed\n");
            pm.printProductReport(productId, languageTag, clientId);
            log.append(clientId+" generated report for "+productId+" product");
            log.append("\n-\tend of log\t-\n");
            return log.toString();
        };

        List<Callable<String>> clients = Stream.generate(()-> client).limit(5).collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(3);

//        pm.printProductReport(101, "en-US");
//        pm.printProductReport(103, "en-GB");

//        pm.createProduct(164,"Kombucha",BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.reviewProduct(164, Rating.TWO_STAR, "Looks like tea but is it?");
//        pm.reviewProduct(164, Rating.FOUR_STAR, "Fine tea");
//        pm.reviewProduct(164, Rating.FOUR_STAR, "This is not a tea");
//        pm.reviewProduct(164, Rating.FIVE_STAR, "Perfect");
//        pm.printProductReport(164);
//        pm.dumpData();
//        pm.restoreData();
//        pm.printProductReport(105);
//        pm.printProductReport(164);
//        pm.printProducts(p -> p.getPrice().floatValue() < 2,
//                (p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
//        pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating + "\t" + discount));



//        pm.createProduct(101,"Tea",BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
//        pm.parseProduct("D,101,Tea,1.99,0");

//        pm.printProductReport(101);

//        pm.parseReview("101,4,Nice hot cup of tea");
//        pm.parseReview("101,2,Rather weak tea");
//        pm.parseReview("101,4,Fine tea");
//        pm.parseReview("101,4,Good tea");
//        pm.parseReview("101,5,Perfect tea");
//        pm.parseReview("101,3,Just add some lemon");

        /*pm.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
        pm.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
        pm.reviewProduct(101, Rating.FOUR_STAR, "Good tea");
        pm.reviewProduct(101, Rating.FIVE_STAR, "Perfect tea");
        pm.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");*/
//        pm.printProductReport(101);

//        pm.parseProduct("F,103,Cake,3.99,0,2019-09-19");
//        pm.printProductReport(103);


//
////        pm.changeLocale("ru-RU");
//
//        pm.createProduct(102,"Coffee",BigDecimal.valueOf(1.99), Rating.NOT_RATED);
////        pm.printProductReport(102);
//        pm.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
//        pm.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?");
//        pm.reviewProduct(102, Rating.FIVE_STAR, "It is perfect with ten spoons of sugar!");
////        pm.printProductReport(102);
//
//        pm.createProduct(103,"Cake",BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
////        pm.printProductReport(103);
//        pm.reviewProduct(103, Rating.FIVE_STAR, "Very nice cake");
//        pm.reviewProduct(103, Rating.FOUR_STAR, "It good, but I´ve expected more chocolate");
//        pm.reviewProduct(103, Rating.FIVE_STAR, "This cake is perfect!");
////        pm.printProductReport(103);
//
//        pm.createProduct(104,"Cookie",BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now());
////        pm.printProductReport(104);
//        pm.reviewProduct(104, Rating.THREE_STAR, "Just another cookie");
//        pm.reviewProduct(104, Rating.THREE_STAR, "Ok");
////        pm.printProductReport(104);
//
//        pm.createProduct(105,"Hot Chocolate",BigDecimal.valueOf(2.50), Rating.NOT_RATED, LocalDate.now());
////        pm.printProductReport(105);
//        pm.reviewProduct(105, Rating.FOUR_STAR, "Tasty!");
//        pm.reviewProduct(105, Rating.FOUR_STAR, "No bad at all");
////        pm.printProductReport(105);
//
//        pm.createProduct(106,"Chocolate",BigDecimal.valueOf(2.50), Rating.NOT_RATED, LocalDate.now().plusDays(3));
////        pm.printProductReport(106);
//        pm.reviewProduct(106, Rating.TWO_STAR, "Too sweet");
//        pm.reviewProduct(106, Rating.THREE_STAR, "Better then cookie");
//        pm.reviewProduct(106, Rating.TWO_STAR, "Too bitter");
//        pm.reviewProduct(106, Rating.ONE_STAR, "I do not get it!");
//        pm.printProductReport(106);
//
//        pm.printProducts(p->p.getPrice().floatValue() < 2, (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
//
//        pm.getDiscounts().forEach((rating, discount) ->System.out.println(rating+"\t"+discount));
//
//        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
//        Comparator<Product> priceSorter = (p1,p2) -> p2.getPrice().compareTo(p1.getPrice());
//        pm.printProducts(ratingSorter.thenComparing(priceSorter));
//        pm.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
//        pm.printProducts(ratingSorter);
//        pm.printProducts(priceSorter);
//        pm.printProducts((p1,p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
//        pm.printProducts((p1,p2) -> p2.getPrice().compareTo(p1.getPrice()));


        /*Product p2 = pm.createProduct(102,"Coffee",BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = pm.createProduct(103,"Cake",BigDecimal.valueOf(1.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = pm.createProduct(105,"Cookie",BigDecimal.valueOf(1.99), Rating.TWO_STAR, LocalDate.now());
        Product p5 = p3.applyRating(Rating.THREE_STAR);
        Product p6 = pm.createProduct(104,"Chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR);
        Product p7 = pm.createProduct(104,"Chocolate",BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p8 = p4.applyRating(Rating.FIVE_STAR);
        Product p9 = p1.applyRating(Rating.TWO_STAR);
        System.out.println(p6.equals(p7));*/

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
        /*System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);*/
    }
}
