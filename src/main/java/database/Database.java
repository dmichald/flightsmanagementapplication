package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<String, String> registeredUsers = new HashMap<>();
    List<List<String>> queriedData = new ArrayList<>();

    public boolean login(Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        return registeredUsers.containsKey(username) &&
                registeredUsers.get(username).equals(password);
    }

    public List<List<String>> queryFlightDatabase() {
        return queriedData;
    }
}
