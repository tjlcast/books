

public class ThenApplyExample {

    public static void main(String[] args) throws InterruptedException, ExcutionException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        System.out.println("[6] Example 6 - Cascading thenApply + theAccept");
        TagOperations to = new TagOperations();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "text", service)
                .thenApply(s -> to.tag("p", s)) // <p>text</p>
                .thenApply(s -> s.concat("\n")) // <p>text</p>\n
                .thenApply(s -> "\n".concat(s)) // \n<p>text</p>\n
                .thenApply(s -> to.tag("div", s));

        future6.thenAccept(s -> System.out.println("[6] Future 6 result:\n" + s));

        System.out.println("\n[7] Example 7 - Asynchronous");

        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> "async-text", service)
                .thenApplyAsync(s -> to.tag("inner", s))
                .thenApplyAsync(s ->s.concat("\n"))
                .thenApplyAsync(s -> "\n".concat(s))
                .thenApplyAsync(s -> to.tag("outer", s));

        future7.thenAcceptAsync(s -> System.out.println"[7] Future 7 result:\n " + s);
    }
}