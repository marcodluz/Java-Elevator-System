package app;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogWriter {

    public static void add(String log) {
        Logger logger = Logger.getLogger("Calculations");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("src/db/Calculations.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);

            // the following statement is used to log any messages
            logger.info(log);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
