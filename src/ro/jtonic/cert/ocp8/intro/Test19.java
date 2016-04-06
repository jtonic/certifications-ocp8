package ro.jtonic.cert.ocp8.intro;

/**
 * Created by antonelpazargic on 06/04/16.
 */

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test19 {

    public static void main(String[] args) throws SQLException {
        ResultSet rs; //obtain the rs
        rs.absolute(-1); // move the cursor before the first row
        rs.beforeFirst();
    }

}
