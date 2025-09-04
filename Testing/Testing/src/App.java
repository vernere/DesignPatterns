public class App {
    public static int degreeChecker(String degree) {
        switch (degree) {
            case "BSc":
                return 3;
            case "MSc":
                return 5;
            case "PhD":
                return 6;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(degreeChecker("BSc"));
        System.out.println(degreeChecker("MSc"));
        System.out.println(degreeChecker("PhD"));

    }

}
