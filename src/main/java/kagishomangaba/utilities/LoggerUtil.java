package kagishomangaba.utilities;

import java.util.logging.Logger;

public class LoggerUtil {




        // Create a logger for this class
        private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

        public static void info(String message) {
            logger.info(message);
        }

        public static void warning(String message) {
            logger.warning(message);
        }

        public static void severe(String message) {
            logger.severe(message);
        }


        public static void debug(String message) {
            logger.fine(message);
        }
    }




