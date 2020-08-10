package database;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DatabaseAccessTest {
    @Mock
    private Database database;
    private Credentials credentials = new Credentials("admin", "admin");

    @Test
    void testUserSuccessfulLogin() {
       when(database.login(credentials)).thenReturn(true);
        Credentials sameCredentials = new Credentials("admin", "admin");
        assertTrue(database.login(sameCredentials));
    }

    @Test
    void testUserFailed(){
        Credentials otherCredentials = new Credentials("user","User");
        otherCredentials.setUsername("OtherUSer");
        otherCredentials.setPassword("OtherPasswd");
        assertNotEquals(credentials.getUsername(),otherCredentials.getUsername());
        assertNotEquals(credentials.getPassword(),otherCredentials.getPassword());
        assertNotEquals(credentials.hashCode(),otherCredentials.hashCode());
        assertFalse(database.login(otherCredentials));
    }

}