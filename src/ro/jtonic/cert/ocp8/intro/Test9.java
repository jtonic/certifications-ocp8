package ro.jtonic.cert.ocp8.intro;

import java.sql.*;

/**
 * Created by antonelpazargic on 04/04/16.
 */
public class Test9 {

    public static void main(String[] args) {

    }

    public void stmt(Connection conn, int a) {
        Statement stmt = conn.createStatement(a, ResultSet.CONCUR_UPDATABLE);
    }

}
