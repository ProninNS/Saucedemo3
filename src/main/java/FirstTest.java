public class FirstTest {
    String name = "David3";

    public void check() {
        String name = "David4";
    }
    public void check2() {
        name = "D";
    }
    public static void main(String[] args) {
        int age;
        boolean isVisible;

        String name = "David";
        String name2 = "David";
        String name3 = new String("David");
        String name4 = new String("David2");



        System.out.println(name == name2);
        System.out.println(name == name3);
        System.out.println(name.equals(name3));
        System.out.println(name.equals(name4));
        System.out.println(name2.equals(name4));


    }

}
