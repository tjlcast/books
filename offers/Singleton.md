使用双重检查

<code>
public class Singleton {
    private Singleton() {}
    
    private static Singleton single = null; 
    
    private static Singleton getInstance() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton(); 
                }
            }
        }
        return single; 
    }
}
 </code>