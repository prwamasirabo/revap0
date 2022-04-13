package dev.rwamasirabo.connectiontests;

import dev.rwamasirabo.utilities.jdbcConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class Connectiontests {
    @Test
    void can_connect(){
        Connection conn = jdbcConnection.getConnection();
        Assertions.assertNotNull(conn);
    }
}

