import java.util.*;

public class Week06 {
    static class BookInventory {
        String title, author; int copiesAvailable;
        BookInventory(String title, String author, int copiesAvailable) { this.title=title; this.author=author; this.copiesAvailable=copiesAvailable; }
        void printEntry() { System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available"); }
    }
    static class PayrollAccount {
        private double basicSalary, bonus;
        PayrollAccount(double openingSalary) {
            if (openingSalary < 0) { System.out.println("Warning: negative salary replaced with 0"); basicSalary=0; }
            else basicSalary=openingSalary;
        }
        void creditBonus(double amount) { if (amount <= 0) System.out.println("Bonus rejected"); else { bonus += amount; System.out.println("Bonus credited: Rs " + amount); } }
        void deductTax(double percent) {
            if (percent < 0 || percent > 100) System.out.println("Invalid tax percentage");
            else { basicSalary -= basicSalary * percent / 100.0; System.out.println("Tax deducted: " + percent + "%"); }
        }
        double getNetSalary() { return basicSalary + bonus; }
    }
    static class EmployeeProfile {
        String empId, empName; double salary; boolean isIntern;
        EmployeeProfile(String id, String name, double salary) { this.empId=id; empName=name; this.salary=salary; isIntern=false; }
        EmployeeProfile(String id, String name) { this(id,name,0); isIntern=true; }
        void printProfile() { System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern); }
    }
    static class HallTicket {
        String studentName; int seatNumber;
        HallTicket(String name,int seat) { studentName=name; seatNumber=seat; }
    }
    static class CompanyEmployee {
        String empName; double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;
        CompanyEmployee(String name,double salary) { empName=name; this.salary=salary; employeeCount++; }
        static void printCompanyInfo() { System.out.println(companyName + "\nEmployees on record: " + employeeCount); }
    }

    public static void main(String[] args) {
        BookInventory[] books = {new BookInventory("Clean Code","Robert C. Martin",3),new BookInventory("Effective Java","Joshua Bloch",5),new BookInventory("Refactoring","Martin Fowler",0),new BookInventory("Design Patterns","GoF",2)};
        for (BookInventory b : books) b.printEntry();
        PayrollAccount account = new PayrollAccount(50000); account.creditBonus(5000); account.deductTax(10); System.out.println("Net salary: Rs " + account.getNetSalary());
        new EmployeeProfile("E-101","Divya",65000).printProfile(); new EmployeeProfile("E-102","Arjun").printProfile();
        HallTicket priya = new HallTicket("Priya",0), copy = priya; copy.seatNumber=45; HallTicket separate = new HallTicket("Priya",45);
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya)); System.out.println("separate == priya: " + (separate == priya));
        new CompanyEmployee("Asha",50000); new CompanyEmployee("Ravi",40000); new CompanyEmployee("Neha",30000); CompanyEmployee.printCompanyInfo();
    }
}
