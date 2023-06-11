package org.example.testing.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;


    @Test
    public void saveUser_shouldSaveUser() throws Exception {
        User user = new User();
        userRepository.saveUser(user);
        verify(userRepository, times(1)).saveUser(user);
    }

    @Test
    public void updateUser_shouldUpdateUser() throws Exception {
        User user = new User();
        userRepository.updateUser(user);
        verify(userRepository, times(1)).updateUser(user);
    }

    @Test
    public void deleteUser_shouldDeleteUser() throws Exception {
        Integer userId = 1;
        userRepository.deleteUser(userId);
        verify(userRepository, times(1)).deleteUser(userId);
    }

}
