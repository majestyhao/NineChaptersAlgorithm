package CodingInterview;

/**
 * Created by hao on 15-10-30.
 */
public class Singleton {
    /**
     * @return: The same instance of this class every time
     */
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
