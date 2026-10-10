import java.util.*;
public class Problem1 {
    interface Bill { String type(); double finalAmount(); }
    static class StudentBill implements Bill { double amount; StudentBill(double a){amount=a;} public String type(){return "STUDENT";} public double finalAmount(){return amount*.90;} }
    static class StaffBill implements Bill { double amount; StaffBill(double a){amount=a;} public String type(){return "STAFF";} public double finalAmount(){return amount*.95;} }
    static class GuestBill implements Bill { double amount; GuestBill(double a){amount=a;} public String type(){return "GUEST";} public double finalAmount(){return amount+10;} }
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();double amount=sc.nextDouble();Bill b;switch(type){case "STUDENT":b=new StudentBill(amount);break;case "STAFF":b=new StaffBill(amount);break;default:b=new GuestBill(amount);}double value=b.finalAmount();System.out.printf("%s: %.2f%n",b.type(),value);total+=value;}System.out.printf("Total: %.2f%n",total);}
}