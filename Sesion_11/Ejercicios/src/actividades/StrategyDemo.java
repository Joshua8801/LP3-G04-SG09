package actividades;

//Interfaz Strategy
interface DiscountStrategy {
 double applyDiscount(double price);
}

//Estrategias concretas
class NoDiscount implements DiscountStrategy {
 public double applyDiscount(double price) {
     return price;
 }
}

class TenPercentDiscount implements DiscountStrategy {
 public double applyDiscount(double price) {
     return price * 0.9;
 }
}

class SpecialDiscount implements DiscountStrategy {
 public double applyDiscount(double price) {
     return price * 0.8;
 }
}

//Contexto
class PriceCalculator {
 private DiscountStrategy discountStrategy;

 public void setDiscountStrategy(DiscountStrategy discountStrategy) {
     this.discountStrategy = discountStrategy;
 }

 public double calculatePrice(double price) {
     return discountStrategy.applyDiscount(price);
 }
}

//Main para probar
public class StrategyDemo {
 public static void main(String[] args) {
     PriceCalculator calculator = new PriceCalculator();

     calculator.setDiscountStrategy(new NoDiscount());
     System.out.println("Precio sin descuento: " + calculator.calculatePrice(100));

     calculator.setDiscountStrategy(new TenPercentDiscount());
     System.out.println("Precio con 10% de descuento: " + calculator.calculatePrice(100));

     calculator.setDiscountStrategy(new SpecialDiscount());
     System.out.println("Precio con descuento especial: " + calculator.calculatePrice(100));
 }
}
