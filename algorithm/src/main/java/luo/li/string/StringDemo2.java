package luo.li.string;

public class StringDemo2 {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String []arry = str.split(",");
        System.out.println(arry.length);
    }
}
