public class Week03 {
    static class Book { String title; double price; }
    static class ExamHall { String hallName; int seatsFilled; }
    static class Employee { String empName; double salary; boolean permanent; }
    static class Product {
        String productId, productName;
        Product(String productId, String productName) { this.productId = productId; this.productName = productName; }
    }
    static class Order {
        static int totalOrders = 0;
        Order() { totalOrders++; }
    }

    public static void main(String[] args) {
        Book book = new Book(); book.title = "Clean Code"; book.price = 650.0;
        System.out.println("Title: " + book.title + " | Price: Rs " + book.price);

        ExamHall hallA = new ExamHall(), hallB = new ExamHall();
        hallA.hallName = "Block-3 Hall A"; hallB.hallName = "Block-3 Hall B";
        hallA.seatsFilled++; hallA.seatsFilled++; hallA.seatsFilled++; hallA.seatsFilled++;
        System.out.println(hallA.hallName + " seatsFilled: " + hallA.seatsFilled);
        System.out.println(hallB.hallName + " seatsFilled: " + hallB.seatsFilled);

        Employee employee = new Employee();
        System.out.println("Name: " + employee.empName + "\nSalary: " + employee.salary + "\nPermanent: " + employee.permanent);

        Product p = new Product("P-1042", "Wireless Mouse");
        System.out.println(p.productId + " - " + p.productName);

        new Order(); new Order(); new Order(); new Order();
        System.out.println("Total orders: " + Order.totalOrders);
    }
}
