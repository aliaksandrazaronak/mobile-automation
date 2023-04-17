package utils;

public class ThreadUtils {

    private static volatile int nextID = 0;

    private static class ThreadLocalID extends ThreadLocal<Integer> {
        protected synchronized Integer initialValue() {
            return nextID++;
        }
    }

    private static ThreadLocalID threadID = new ThreadLocalID();

    public static int getThreadId() {
        return threadID.get();
    }

    public static void setThreadID(int index) {
        threadID.set(index);
    }
}
