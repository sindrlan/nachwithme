package test.core;

import core.java.User;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void getAddress() {
        User user = new User("Sindre", "test@gmail.com", "Wonderland 12", 23);
        assertEquals("Wonderland 12", user.getAddress());
    }

    @Test
    public void getName() {
        User user = new User("Aleksander", "test@hotmail.com", "Boogieland 42", 21);
        assertEquals("Aleksander", user.getName());
    }

    @Test
    public void testToString() {
        User user = new User("Per", "test@yahoo.com", "Neverland 69", 22);
        assertEquals("Per 22, Neverland 69", user.toString());
    }
}