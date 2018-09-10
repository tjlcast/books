
public class ThenRunExample {

    public static void main(String[] args) {
        System.out.println("[4] Example 4 - Using thenRun");
        CompletableFuture<Void> future2 = CompletableFuture.runAsync( () -> {
            for (int i=0; i < 1_000_000_000; i++) {
                if (i % 1_000_000_000 == 0) {
                    System.out.println('2');
                }
                System.out.println("[2] DONE");
            }
        }).thenRun(() -> System.out.println("[4] Future 4 is DONE")) ;

        future2.join(); // necessary because default pool is ForkJoinPool which uses daemon threads.
    }
}