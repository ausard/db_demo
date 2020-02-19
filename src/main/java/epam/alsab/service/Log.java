package epam.alsab.service;

public class Log {
    public static void log(String str, Throwable th) {
        System.out.println(str+": "+th.getMessage());
    }
}
