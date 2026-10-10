package Week09;
import java.util.*;
public class Problem2 {
    interface Insurable { double insurance(); }
    static abstract class Parcel { final double weight,value;Parcel(double w,double v){weight=w;value=v;}abstract String type();abstract double charge();double insurance(){return 0;}double total(){return charge()+insurance();} }
    static class Standard extends Parcel {Standard(double w,double v){super(w,v);}String type(){return "STANDARD";}double charge(){return 40+10*weight;}}
    static class Express extends Parcel implements Insurable {Express(double w,double v){super(w,v);}String type(){return "EXPRESS";}double charge(){return 80+15*weight;}public double insurance(){return value*.02;}}
    static class Fragile extends Parcel implements Insurable {Fragile(double w,double v){super(w,v);}String type(){return "FRAGILE";}double charge(){return 40+10*weight+50;}public double insurance(){return value*.02;}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double grand=0;for(int i=0;i<n;i++){String type=sc.next();double w=sc.nextDouble(),v=sc.nextDouble();Parcel p;switch(type){case "STANDARD":p=new Standard(w,v);break;case "EXPRESS":p=new Express(w,v);break;default:p=new Fragile(w,v);}double ins=p instanceof Insurable?((Insurable)p).insurance():0;double total=p.charge()+ins;System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",p.type(),p.charge(),ins,total);grand+=total;}System.out.printf("Grand Total: %.2f%n",grand);}
}