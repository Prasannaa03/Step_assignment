import java.util.*;
public class Problem3 {
    interface Room { String type(); double bill(); }
    static class Single implements Room { int units; Single(int u){units=u;} public String type(){return "SINGLE";} public double bill(){return units*8.0;} }
    static class Shared implements Room { int units,occupants; Shared(int u,int o){units=u;occupants=o;} public String type(){return "SHARED";} public double bill(){return units*6.0/occupants;} }
    static class AC implements Room { int units; AC(int u){units=u;} public String type(){return "AC";} public double bill(){return units*10.0+200.0;} }
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();int units=sc.nextInt();Room r;if(type.equals("SINGLE"))r=new Single(units);else if(type.equals("SHARED"))r=new Shared(units,sc.nextInt());else r=new AC(units);double value=r.bill();System.out.printf("%s: %.2f%n",r.type(),value);total+=value;}System.out.printf("Total: %.2f%n",total);}
}