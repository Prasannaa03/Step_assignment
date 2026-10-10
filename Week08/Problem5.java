import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Problem5 {
    interface Plan { String name(); LocalDate renewal(); }
    static class Subscription implements Plan { String subscriber;LocalDate start;int days;Subscription(String n,LocalDate s,int d){subscriber=n;start=s;days=d;}public String name(){return subscriber;}public LocalDate renewal(){return start.plusDays(days);} }
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();DateTimeFormatter fmt=DateTimeFormatter.ISO_LOCAL_DATE;for(int i=0;i<n;i++){String type=sc.next(),name=sc.next();LocalDate date=LocalDate.parse(sc.next(),fmt);int days=type.equals("BASIC")?30:type.equals("STANDARD")?90:365;Plan p=new Subscription(name,date,days);System.out.println(p.name()+": "+p.renewal().format(fmt));}}
}