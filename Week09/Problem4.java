package Week09;
import java.util.*;
public class Problem4 {
    interface NightService { double nightFare(double fare); }
    static abstract class Cab {final double km;Cab(double k){km=k;}abstract String type();abstract double rate();double dayFare(){return Math.max(100,km*rate());}}
    static class Mini extends Cab {Mini(double k){super(k);}String type(){return "MINI";}double rate(){return 10;}}
    static class Sedan extends Cab implements NightService {Sedan(double k){super(k);}String type(){return "SEDAN";}double rate(){return 14;}public double nightFare(double f){return f*1.2;}}
    static class SUV extends Cab implements NightService {SUV(double k){super(k);}String type(){return "SUV";}double rate(){return 18;}public double nightFare(double f){return f*1.2;}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();double km=sc.nextDouble();String time=sc.next();Cab c;switch(type){case "MINI":c=new Mini(km);break;case "SEDAN":c=new Sedan(km);break;default:c=new SUV(km);}if(time.equals("NIGHT")&&!(c instanceof NightService)){System.out.println(c.type()+": night service not available");continue;}double fare=c.dayFare();if(time.equals("NIGHT"))fare=((NightService)c).nightFare(fare);System.out.printf("%s: %.2f%n",c.type(),fare);total+=fare;}System.out.printf("Total: %.2f%n",total);}
}