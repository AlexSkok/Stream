// Main.java
import app.Product;
import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 180.0),
                new Product("Computer", "Electronics", 150.0),
                new Product("Headphones", "Appliances", 153.0),
                new Product("SonyPS", "Electronics", 348.0),
                new Product("Mixer", "Appliances", 1100.0),
                new Product("TV", "Electronics", 501.0)
        );

        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        System.out.println("Результат: " + result.entrySet());

        Optional<Map.Entry<String, Double>> maxAverageValue = result.entrySet()
                .stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        System.out.println("Максимальна середня ціна " + maxAverageValue);

    }
}
