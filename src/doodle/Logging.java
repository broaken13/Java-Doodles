/*
 *  License Overland West, Inc.  2016
 */

package doodle;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bjo
 */
public class Logging {

    
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.log(Level.SEVERE, "One: {0}\nTwo: {1}", new String[] {"Five", "Six"});
    }
}
