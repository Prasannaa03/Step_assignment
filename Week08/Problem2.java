import java.util.*;
public class Problem2 {
    interface Vehicle { String type(); double charge(); }
    static class Bike implements Vehicle { int hours; Bike(int h){hours=h;} public String type(){return "BIKE";} public double charge(){return hours*10.0;} }
    static class Car implements Vehicle { int hours; Car(int h){hours=h;} public String type(){return "CAR";} public double charge(){return 30.0+(hours-1)*20.0;} }
    static class Truck implements Vehicle { int hours; Truck(int h){hours=h;} public String type(){return "TRUCK";} public double charge(){return Math.max(100.0,hours*50.0);} }
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();int hours=sc.nextInt();Vehicle v;switch(type){case "BIKE":v=new Bike(hours);break;case "CAR":v=new Car(hours);break;default:v=new Truck(hours);}double charge=v.charge();System.out.printf("%s: %.2f%n",v.type(),charge);total+=charge;}System.out.printf("Total: %.2f%n",total);}
}