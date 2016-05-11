package ro.jtonic.cert.ocp8.ch5.localization;

import java.util.*;

/**
 * Created by antonelpazargic on 11/05/16.
 */
public class Zoo_de extends ListResourceBundle {

    protected Object[][] getContents() {
        return new Object[][] {
                {"hello", "Hallo"},
                {"open", "Öffnungszeiten"},
                {"ticket_price", new Integer(100)}
        };
    }
}
