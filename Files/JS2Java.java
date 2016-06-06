public final class JS2Java {
    private Integer x = 2;

    public static void main(String[] args) {
        System.out.println(num + "!: " + rFact(5));System.out.println("Iterations: " + iterations);
    }

    public void rFact(String num) {
        if (num == 0) {
            return 1;
        } else {
            return num * rFact(num - 1);
        }
    }
}
