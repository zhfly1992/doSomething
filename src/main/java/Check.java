public class Check {

    static String res = "^^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*_-]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*_-]+$)" +
            "(?![\\d!@#$%^&*_-]+$)[a-zA-Z\\d!@#$%^&*_-]+$";

    public static void main(String[] args) {
        String password = "1111aaaa";
        System.out.println( password.matches(res)? 1:0);
    }
}
