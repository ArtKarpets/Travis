package service;

import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserService();
    private static final String FIRST_NAME = "bob";
    private static final String SECOND_NAME = "dilan";
    private static final String PHONE = "1";
    private User user = new User(FIRST_NAME, SECOND_NAME, PHONE);

    @Test
    public void getAll() {
        assertFalse(userService.getAll().isEmpty());
    }

    @Test
    public void save() {
        userService.save(user);
        assertEquals(user, userService.getByPhone(PHONE));
    }

    @Test
    public void update() {
        userService.update(user);
        assertEquals(user, userService.getByPhone(PHONE));
    }

    @Test
    public void delete() {
        userService.save(user);
        userService.delete(user);
        assertTrue(userService.getByPhone(PHONE).isEmpty());
    }

    @Test
    public void getByPhone() {
        userService.getByPhone(PHONE);
        assertEquals(user, userService.getByPhone(PHONE));
    }

    @Test
    public void createNewUser() {
        userService.save(user);
        assertFalse(userService.getByPhone(PHONE).isEmpty());
    }
}