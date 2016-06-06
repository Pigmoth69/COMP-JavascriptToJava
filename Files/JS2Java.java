public final class JS2Java {
    private int x = 2;

    private int iterations = 0;

    public static void main(String[] args) {
        System.out.println(num + "!: " + rFact(5));
        System.out.println("Iterations: " + iterations);
    }

    public int rFact(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * rFact(num - 1);
        }
    }
}
