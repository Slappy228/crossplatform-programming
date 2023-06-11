package org.example.testing.task;

import org.junit.jupiter.api.Test;

import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.*;
class UserServiceTest {

    @Test
    public void getUser_withoutId_shouldThrowIllegalArgumentException() {
        UserService userService =new UserService();
        assertThrows(IllegalArgumentException.class, () -> userService.getUser(null));
    }
    @Test
    public void deleteUser_withoutId_shouldThrowIllegalArgumentException() {
        UserService userService=new UserService();
        assertThrows (IllegalArgumentException.class, () -> userService.deleteUser(null));
    }

    @Test

    void deleteUser_expectThrowIllegalArgumentException_whenItReceivesNullArgument() {

        Integer id = null;
        UserService userService=new UserService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.deleteUser(id));
        assertTrue(exception.getMessage().equals("userId could not be null"));
    }
    @Test
    public void createUser_withoutId_shouldThrowIllegalArgumentException() {
        User user =new User();
        UserService userService=new UserService();
        assertThrows(IllegalArgumentException.class, () -> userService.createUser(user));
    }

    @Test
    public void createUser_withoutAddress_shouldThrowIllegalArgumentException() {
        User user = new User();
        user.setUserId(1);
        UserService userService=new UserService();
        assertThrows(IllegalArgumentException.class, () -> userService.createUser(user));
    }

    @Test
    public void createUser_withoutAddressId_shouldThrowIllegalArgumentException() {
        Address address = new Address();
        User user = new User();
        user.setUserId(1);
        user.setAddress(address);
        UserService userService=new UserService();
        assertThrows(IllegalArgumentException.class, () -> userService.createUser(user));
    }
    @Test
    void validateAge_expectThrowIllegalArgumentException_whenItReceivesNullArgument() {

        Integer age = null;
        UserService userService=new UserService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.validateAge(age));
        assertTrue(exception.getMessage().equals("age could not be null"));
    }

    @Test
    void validateEmail_expectThrowIllegalArgumentException_whenItReceivesNullArgument() {
        String email = null;
        UserService userService=new UserService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.validateEmail(email));
        assertTrue(exception.getMessage().equals("email could not be null"));
    }

    @Test
    void validatePhone_expectThrowIllegalArgumentException_whenItReceivesNullArgument() {
        String phoneNumber = null;
        UserService userService=new UserService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.validatePhone(phoneNumber));
        assertTrue(exception.getMessage().equals("phoneNumber could not be null"));
    }

    @Test
    void validateName_expectThrowIllegalArgumentException_whenItReceivesNullArgument() {

        String name = null;
        UserService userService=new UserService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> userService.validateName(name));
        assertTrue(exception.getMessage().equals("name could not be null"));
    }




}
