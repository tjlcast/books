
public class ThenAcceptExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        System.out.println("[5] Example 5 - Using thenAccept and other ExecutorService");
        CompletableFuture.supplyAsync( () -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i < 1_000_000_000; i++) {
                if (i % 1_000_000_000 == 0) {
                    System.out.println("5");
                    stringBuilder.append((char)(new Random().nextInt(26) + 'A'));
                }
            }
            System.out.println("[5] DONE");
            return stringBuilder.toString();
        }, service).thenAccept(result -> System.out.println("[5] Future 5 is DONE. Result is: " + result));

        service.shutdown();
    }
}