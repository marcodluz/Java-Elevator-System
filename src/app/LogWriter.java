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

            // Define the Results log file
            fh = new FileHandler("src/db/Results.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);

            // Log any message
            logger.info(log);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
