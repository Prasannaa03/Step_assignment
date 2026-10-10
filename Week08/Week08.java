import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Week08 {
    interface BillRule { double calculate(); String label(); }
    static class CanteenBill implements BillRule {
        String type; double amount;
        CanteenBill(String type,double amount){this.type=type;this.amount=amount;}
        public double calculate(){switch(type){case "STUDENT":return amount*0.90;case "STAFF":return amount*0.95;default:return amount+10;}}
        public String label(){return type;}
    }
    static class Parking implements BillRule {
        String type; int hours;
        Parking(String type,int hours){this.type=type;this.hours=hours;}
        public double calculate(){switch(type){case "BIKE":return hours*10.0;case "CAR":return 30.0+(hours-1)*20.0;default:return Math.max(100.0,hours*50.0);}}
        public String label(){return type;}
    }
    static class RoomBill implements BillRule {
        String type; int units, occupants;
        RoomBill(String type,int units,int occupants){this.type=type;this.units=units;this.occupants=occupants;}
        public double calculate(){switch(type){case "SINGLE":return units*8.0;case "SHARED":return units*6.0/occupants;default:return units*10.0+200.0;}}
        public String label(){return type;}
    }
    static class EmployeeBonus implements BillRule {
        String type,name; double salary;
        EmployeeBonus(String type,String name,double salary){this.type=type;this.name=name;this.salary=salary;}
        public double calculate(){if(type.equals("FULLTIME"))return salary*0.10;if(type.equals("PARTTIME"))return salary*0.05;return 2000.0;}
        public String label(){return name;}
    }
    static class Renewal implements BillRule {
        String type,name; LocalDate start;
        Renewal(String type,String name,LocalDate start){this.type=type;this.name=name;this.start=start;}
        public double calculate(){return 0;}
        LocalDate renewalDate(){int days=type.equals("BASIC")?30:type.equals("STANDARD")?90:365;return start.plusDays(days);}
        public String label(){return name;}
    }
    static void printBills(List<? extends BillRule> bills) {
        double total=0;
        for(BillRule b:bills){double value=b.calculate();System.out.printf("%s: %.2f%n",b.label(),value);total+=value;}
        System.out.printf("Total: %.2f%n",total);
    }
    public static void main(String[] args) {
        printBills(Arrays.asList(new CanteenBill("STUDENT",200),new CanteenBill("STAFF",300),new CanteenBill("GUEST",150)));
        printBills(Arrays.asList(new Parking("BIKE",3),new Parking("CAR",4),new Parking("TRUCK",1),new Parking("CAR",1)));
        printBills(Arrays.asList(new RoomBill("SINGLE",120,1),new RoomBill("SHARED",150,3),new RoomBill("AC",100,1)));
        printBills(Arrays.asList(new EmployeeBonus("FULLTIME","Asha",50000),new EmployeeBonus("PARTTIME","Ravi",30000),new EmployeeBonus("INTERN","Neha",15000)));
        DateTimeFormatter f=DateTimeFormatter.ISO_LOCAL_DATE;
        for(Renewal r:Arrays.asList(new Renewal("BASIC","Asha",LocalDate.parse("2024-01-15")),new Renewal("STANDARD","Ravi",LocalDate.parse("2024-02-01")),new Renewal("PREMIUM","Neha",LocalDate.parse("2024-03-10")),new Renewal("BASIC","Kiran",LocalDate.parse("2024-12-20"))))
            System.out.println(r.label()+": "+r.renewalDate().format(f));
    }
}
