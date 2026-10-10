import java.util.Arrays;

public class Week07 {
    static class Character {
        private int health; private final int maxHealth;
        Character(int maxHealth) { if (maxHealth < 0) throw new IllegalArgumentException("Maximum health cannot be negative"); this.maxHealth=maxHealth; health=maxHealth; }
        void takeDamage(int amount) { if (amount > 0) health=Math.max(0, health-amount); }
        void heal(int amount) { if (amount > 0) health=Math.min(maxHealth, health+amount); }
        int getHealth() { return health; }
    }
    static class Playlist {
        private final String[] songs; private int count;
        Playlist(int capacity) { songs=new String[capacity]; }
        void addSong(String song) { if (count == songs.length) throw new IllegalStateException("Playlist is full"); songs[count++]=song; }
        String[] getSongs() { return Arrays.copyOf(songs,count); }
        int getSongCount() { return count; }
    }
    static class PasswordChecker {
        private final String password;
        PasswordChecker(String password) { this.password=password; }
        String getStrength() { int n=password.length(); return n < 6 ? "Weak" : n <= 9 ? "Medium" : "Strong"; }
    }
    static class TrafficLight {
        private String color = "RED"; private final String id;
        TrafficLight(String id) { this.id=id; }
        void next() { if (color.equals("RED")) color="GREEN"; else if (color.equals("GREEN")) color="YELLOW"; else color="RED"; }
        String getColor() { return color; }
        String getId() { return id; }
    }
    static class Cart {
        private final double[] prices; private int count; private final String cartId;
        Cart(String id,int capacity) { cartId=id; prices=new double[capacity]; }
        void addItem(double price) { if (price < 0) throw new IllegalArgumentException("Price cannot be negative"); if (count==prices.length) throw new IllegalStateException("Cart is full"); prices[count++]=price; }
        double getTotal() { double total=0; for (int i=0;i<count;i++) total+=prices[i]; return total; }
        int getItemCount() { return count; }
        String getCartId() { return cartId; }
    }
    public static void main(String[] args) {
        Character c=new Character(100); c.takeDamage(30); System.out.println(c.getHealth()); c.heal(50); System.out.println(c.getHealth()); c.takeDamage(150); System.out.println(c.getHealth());
        Playlist p=new Playlist(10); p.addSong("Song A"); p.addSong("Song B"); String[] copy=p.getSongs(); copy[0]="Hacked"; System.out.println(Arrays.toString(p.getSongs()));
        System.out.println(new PasswordChecker("abcdefghij").getStrength());
        TrafficLight t=new TrafficLight("TL-9"); System.out.println(t.getColor()); t.next(); System.out.println(t.getColor()); t.next(); System.out.println(t.getColor());
        Cart cart=new Cart("CART-5",20); cart.addItem(250); cart.addItem(99); cart.addItem(151); System.out.println(cart.getTotal()); System.out.println(cart.getItemCount());
    }
}
