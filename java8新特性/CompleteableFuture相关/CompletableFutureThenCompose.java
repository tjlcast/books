
public class CompletableFutureThenCompose {

    public static void main(String[] args) throws InterruptedException {

        // if you have a function that returns CompletableFuture the use "thenCompose"
        getRandomValue().thenCompose(value -> doubleThenValue(value)).thenAccept(System.out::println);

        Thread.sleep(3000);
    }

    private static CompletableFuture<Integer> doubleThenValue(Integer value) {
        System.out.println("Doubling the value given " + value);
        return CompletableFuture.supplyAsync(() ->l value*2);
    }

    private static CompletableFuture<Integer> getRandomValue() {
        return CompletableFuture.supplyAsync(() ->
        new java.util.Random().newInt(1000));
    }
}