package log;
import java.util.logging.*;
import java.io.IOException;
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try
        {
            FileHandler file = new FileHandler("log.txt");
            logger.addHandler(file);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Не удалось создать лог.", e);
        }
        for(int i = 0; i < 5; i++) {
            try {
                logger.log(Level.INFO,"result: " + divide(i));
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public static int divide(int x) {
        logger.log(Level.CONFIG,"divide method invoked; 2 / " + x);
        if(x == 0) {
            logger.log(Level.WARNING,"x = 0; exception may occur");
        }
        return 4 / x;
    }
}
