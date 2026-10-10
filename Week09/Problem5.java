package Week09;
import java.util.*;
public class Problem5 {
    interface SaverMode { double save(double units); }
    static abstract class Appliance {final double hours;Appliance(double h){hours=h;}abstract String type();abstract double power();double units(){return power()*hours/1000;} }
    static class Fridge extends Appliance {Fridge(double h){super(h);}String type(){return "FRIDGE";}double power(){return 150;}}
    static class AC extends Appliance implements SaverMode {AC(double h){super(h);}String type(){return "AC";}double power(){return 1500;}public double save(double u){return u*.75;}}
    static class TV extends Appliance {TV(double h){super(h);}String type(){return "TV";}double power(){return 100;}}
    static class Washer extends Appliance implements SaverMode {Washer(double h){super(h);}String type(){return "WASHER";}double power(){return 500;}public double save(double u){return u*.75;}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=Integer.parseInt(sc.nextLine().trim());double total=0;for(int i=0;i<n;i++){String line=sc.nextLine().trim();String[] fields=line.split("\\s+");String type=fields[0];double hours=Double.parseDouble(fields[1]);boolean saver=fields.length>2&&fields[2].equals("SAVER");Appliance a;switch(type){case "FRIDGE":a=new Fridge(hours);break;case "AC":a=new AC(hours);break;case "TV":a=new TV(hours);break;default:a=new Washer(hours);}if(saver&&!(a instanceof SaverMode)){System.out.println(a.type()+": saver mode not supported");continue;}double units=a.units();if(saver)units=((SaverMode)a).save(units);double cost=units*8;System.out.printf("%s: Units=%.2f Cost=%.2f%n",a.type(),units,cost);total+=cost;}System.out.printf("Total Cost: %.2f%n",total);}
}