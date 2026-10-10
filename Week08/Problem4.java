import java.util.*;
public class Problem4 {
    interface Employee { String name(); double bonus(); }
    static class FullTime implements Employee { String n;double salary;FullTime(String n,double s){this.n=n;salary=s;}public String name(){return n;}public double bonus(){return salary*.10;} }
    static class PartTime implements Employee { String n;double salary;PartTime(String n,double s){this.n=n;salary=s;}public String name(){return n;}public double bonus(){return salary*.05;} }
    static class Intern implements Employee { String n;Intern(String n,double s){this.n=n;}public String name(){return n;}public double bonus(){return 2000.0;} }
    public static void main(String[] args){Scanner sc=new Scanner(System.in);int n=sc.nextInt();double total=0;for(int i=0;i<n;i++){String type=sc.next(),name=sc.next();double salary=sc.nextDouble();Employee e;switch(type){case "FULLTIME":e=new FullTime(name,salary);break;case "PARTTIME":e=new PartTime(name,salary);break;default:e=new Intern(name,salary);}double b=e.bonus();System.out.printf("%s: %.2f%n",e.name(),b);total+=b;}System.out.printf("Total Bonus: %.2f%n",total);}
}