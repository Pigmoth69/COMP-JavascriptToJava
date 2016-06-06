public final class JS2Java {
    private static int num = 2;

    private static int iterations = 0;

    public static void main(String[] args) {
        System.out.println(num + "!: " + rFact(5));
        System.out.println("Iterations: " + iterations);
    }

    public static int rFact(int num) {
        iterations++;
        if (num == 0) {
            return 1;
        } else {
            return num * rFact(num - 1);
        }
    }
}
