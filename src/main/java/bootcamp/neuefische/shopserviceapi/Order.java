package bootcamp.neuefische.shopserviceapi;

import java.time.ZonedDateTime;
import java.util.List;

public record Order(String id, List<Product> products, OrderStatus status, ZonedDateTime dateTime) {
}