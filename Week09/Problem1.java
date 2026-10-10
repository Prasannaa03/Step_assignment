package Week09;
import java.util.*;
public class Problem1 {
    static abstract class Ticket { static final double CONVENIENCE_FEE=20;final int count;Ticket(int c){count=c;}abstract String type();abstract double price();double amount(){return count*(price()+CONVENIENCE_FEE);} }
    static class Regular extends Ticket {Regular(int c){super(c);}String type(){return "REGULAR";}double price(){return 150;}}
    static class Premium extends Ticket {Premium(int c){super(c);}String type(){return "PREMIUM";}double price(){return 250;}}
    static class Recliner extends Ticket {Recliner(int c){super(c);}String type(){return "RECLINER";}double price(){return 400;}}
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next();int count=sc.nextInt();Ticket t;switch(type){case "REGULAR":t=new Regular(count);break;case "PREMIUM":t=new Premium(count);break;default:t=new Recliner(count);}System.out.printf("%s: %.2f%n",t.type(),t.amount());total+=t.amount();}System.out.printf("Total: %.2f%n",total);}
}