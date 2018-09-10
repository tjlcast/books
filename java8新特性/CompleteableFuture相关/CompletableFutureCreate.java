
public class CompletableFutureCreate {

    static ThreadFactory threadFactory(String nameFactory) {
        return new ThreadFactoryBuilder().setNameFormat(nameFormat + "-%d").build();
    }

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(10, threadFactory("Custom"));

        final CompletableFuture<Integer> answer = CompletableFuture.completedFuture(42);

        final int fortyTwo = answer.get(); // does not block.
        System.out.println("Answer: " + fortyTwo);

        final CompletableFuture<Integer> answer1 = new CompletableFuture();

        answer1.complete(10);
        System.out.println("Answer: " + answer1.get());

        final CompletableFuture<String> java = CompletableFuture.supplyAync( () ->
                {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "java";
                }
        );
        System.out.prinln("Found: " + java.get());

        final CompleteableFuture<String> java2 = CompletableFuture.supplyAsync( () ->
                {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "java2";
                }, executorService
        );
        System.out.println("Found2: " + java2.get());
    }
}