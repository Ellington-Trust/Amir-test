package com.example.demo;

import com.example.demo.Controller.UserController;
import com.example.demo.Entity.User;
import com.example.demo.Service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ShopControllerTest {

    @Mock
    private ShopService shopService;

    @InjectMocks
    private UserController userController;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(1, "John", "Doe", 30, "john@example.com", "123 Test St");
    }

    @Test
    void testAddUser() {
        when(shopService.findUserById(1)).thenReturn(Optional.empty());

        ResponseEntity<String> response = userController.addUser(testUser);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("User added successfully", response.getBody());
        verify(shopService).addUser(1, "John", "Doe", 30, "john@example.com", "123 Test St");
    }

    @Test
    void testFindUser() {
        when(shopService.findUserById(1)).thenReturn(Optional.of(testUser));

        ResponseEntity<String> response = userController.findUser(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User found " + testUser, response.getBody());
    }

    @Test
    void testFindUserNotFound() {
        when(shopService.findUserById(1)).thenReturn(Optional.empty());

        ResponseEntity<String> response = userController.findUser(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User not found", response.getBody());
    }

    @Test
    void testDeleteUser() {
        doNothing().when(shopService).deleteUserById(1);

        ResponseEntity<String> response = userController.deleteUser(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User deleted successfully", response.getBody());
        verify(shopService).deleteUserById(1);
    }

    @Test
    void testFindUserByFirstName() {
        ResponseEntity<String> response = userController.findUserByFirstName("John");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Search completed", response.getBody());
        verify(shopService).findUserByFirstName("John");
    }
}