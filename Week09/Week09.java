import java.util.*;

public class Week09 {
    static abstract class Ticket {
        static final double CONVENIENCE_FEE=20.0;
        final int count;
        Ticket(int count){this.count=count;}
        abstract double price();
        double amount(){return count*(price()+CONVENIENCE_FEE);}
        abstract String type();
    }
    static class Regular extends Ticket { Regular(int n){super(n);} double price(){return 150;} String type(){return "REGULAR";} }
    static class Premium extends Ticket { Premium(int n){super(n);} double price(){return 250;} String type(){return "PREMIUM";} }
    static class Recliner extends Ticket { Recliner(int n){super(n);} double price(){return 400;} String type(){return "RECLINER";} }

    static abstract class Parcel {
        final double weight, declaredValue;
        Parcel(double w,double v){weight=w;declaredValue=v;}
        abstract double shippingCharge();
        double insurance(){return 0.0;}
        String type(){return getClass().getSimpleName().toUpperCase();}
        double total(){return shippingCharge()+insurance();}
    }
    interface Insurable { double insurance(); }
    static class StandardParcel extends Parcel { StandardParcel(double w,double v){super(w,v);} double shippingCharge(){return 40+10*weight;} String type(){return "STANDARD";} }
    static class ExpressParcel extends Parcel implements Insurable { ExpressParcel(double w,double v){super(w,v);} double shippingCharge(){return 80+15*weight;} public double insurance(){return declaredValue*0.02;} String type(){return "EXPRESS";} }
    static class FragileParcel extends Parcel implements Insurable { FragileParcel(double w,double v){super(w,v);} double shippingCharge(){return 40+10*weight+50;} public double insurance(){return declaredValue*0.02;} String type(){return "FRAGILE";} }

    static abstract class Student {
        final String name; static final double TRANSPORT_FEE=12000.0;
        Student(String name){this.name=name;}
        abstract double tuitionAndOtherFees();
        boolean usesBus(){return false;}
        double totalFee(){return tuitionAndOtherFees()+(usesBus()?TRANSPORT_FEE:0);}
    }
    static class DayScholar extends Student { DayScholar(String n){super(n);} double tuitionAndOtherFees(){return 40000;} boolean usesBus(){return true;} }
    static class Hosteller extends Student { Hosteller(String n){super(n);} double tuitionAndOtherFees(){return 40000+60000;} }
    static class Scholar extends Student { Scholar(String n){super(n);} double tuitionAndOtherFees(){return 20000;} boolean usesBus(){return true;} }

    interface NightService { double applyNightFare(double fare); }
    static abstract class Cab {
        final double km; Cab(double km){this.km=km;}
        abstract double rate();
        double fare(){return Math.max(100,km*rate());}
    }
    static class Mini extends Cab { Mini(double km){super(km);} double rate(){return 10;} }
    static class Sedan extends Cab implements NightService { Sedan(double km){super(km);} double rate(){return 14;} public double applyNightFare(double fare){return fare*1.2;} }
    static class SUV extends Cab implements NightService { SUV(double km){super(km);} double rate(){return 18;} public double applyNightFare(double fare){return fare*1.2;} }

    interface SaverMode { double saverUnits(double units); }
    static abstract class Appliance {
        final double hours; Appliance(double h){hours=h;}
        abstract double power();
        double units(){return power()*hours/1000.0;}
        double cost(){return units()*8.0;}
        String type(){return getClass().getSimpleName().toUpperCase();}
    }
    static class Fridge extends Appliance { Fridge(double h){super(h);} double power(){return 150;} }
    static class AC extends Appliance implements SaverMode { AC(double h){super(h);} double power(){return 1500;} public double saverUnits(double u){return u*0.75;} }
    static class TV extends Appliance { TV(double h){super(h);} double power(){return 100;} }
    static class Washer extends Appliance implements SaverMode { Washer(double h){super(h);} double power(){return 500;} public double saverUnits(double u){return u*0.75;} }

    public static void main(String[] args) {
        List<Ticket> tickets=Arrays.asList(new Regular(3),new Premium(2),new Recliner(1)); double ticketTotal=0;
        for(Ticket t:tickets){System.out.printf("%s: %.2f%n",t.type(),t.amount());ticketTotal+=t.amount();} System.out.printf("Total: %.2f%n",ticketTotal);

        List<Parcel> parcels=Arrays.asList(new StandardParcel(3,500),new ExpressParcel(2,1000),new FragileParcel(4,2000));double parcelTotal=0;
        for(Parcel p:parcels){double ins=p instanceof Insurable?((Insurable)p).insurance():0;System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",p.type(),p.shippingCharge(),ins,p.shippingCharge()+ins);parcelTotal+=p.shippingCharge()+ins;}System.out.printf("Grand Total: %.2f%n",parcelTotal);

        List<Student> students=Arrays.asList(new DayScholar("Asha"),new Hosteller("Ravi"),new Scholar("Neha"));double fees=0;
        for(Student s:students){System.out.printf("%s: %.2f%n",s.name,s.totalFee());fees+=s.totalFee();}System.out.printf("Total Collected: %.2f%n",fees);

        List<Cab> cabs=Arrays.asList(new Mini(8),new Sedan(10),new SUV(20));double cabTotal=0;
        for(Cab c:cabs){double f=c.fare();if(c instanceof NightService)f=((NightService)c).applyNightFare(f);System.out.printf("%s: %.2f%n",c.getClass().getSimpleName().toUpperCase(),f);cabTotal+=f;}System.out.printf("Total: %.2f%n",cabTotal);
        System.out.println("MINI: night service not available");

        List<Appliance> appliances=Arrays.asList(new Fridge(24),new AC(8),new TV(5),new Washer(2));double energyTotal=0;
        boolean[] saver={false,true,false,true};
        for(int i=0;i<appliances.size();i++){Appliance a=appliances.get(i);double u=a.units();if(saver[i]&&a instanceof SaverMode)u=((SaverMode)a).saverUnits(u);double cost=u*8;System.out.printf("%s: Units=%.2f Cost=%.2f%n",a.type(),u,cost);energyTotal+=cost;}System.out.printf("Total Cost: %.2f%n",energyTotal);
    }
}
