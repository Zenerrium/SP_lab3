import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicReference<String> lastWord = new AtomicReference<>("");
        Thread chicken = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Курица");
                lastWord.set("Курица");
                Thread.yield();
            }
        }, "ChickenThread");
        Thread egg = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйцо");
                lastWord.set("Яйцо");
                Thread.yield();
            }
        }, "EggThread");
        chicken.start();
        egg.start();
        chicken.join();
        egg.join();
        System.out.println();
        System.out.println("Последнее слово в споре: " + lastWord.get());
        System.out.println("Победитель: " + lastWord.get());
    }
}
