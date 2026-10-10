package Week09;
import java.util.*;
public class Problem3 {
    static abstract class Student {final String name;static final double BUS_FEE=12000;Student(String n){name=n;}abstract double baseFee();boolean usesBus(){return false;}double total(){return baseFee()+(usesBus()?BUS_FEE:0);} }
    static class DayScholar extends Student {DayScholar(String n){super(n);}double baseFee(){return 40000;}boolean usesBus(){return true;}}
    static class Hosteller extends Student {Hosteller(String n){super(n);}double baseFee(){return 100000;}}
    static class Scholar extends Student {Scholar(String n){super(n);}double baseFee(){return 20000;}boolean usesBus(){return true;}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next(),name=sc.next();Student s;switch(type){case "DAY_SCHOLAR":s=new DayScholar(name);break;case "HOSTELLER":s=new Hosteller(name);break;default:s=new Scholar(name);}System.out.printf("%s: %.2f%n",s.name,s.total());total+=s.total();}System.out.printf("Total Collected: %.2f%n",total);}
}