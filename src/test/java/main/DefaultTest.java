package main;

import main.entitys.User;
import main.repo.UserRepo;
import main.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultTest {
    @Autowired
    UserService userService;

    @Mock
    UserRepo userRepoMock;

    @Test
    public void testQuery() {
        assertNotNull(userRepoMock);
        when(userRepoMock.findAll()).thenReturn(new ArrayList<>() {{
            add(new User("Sergei", "Sh", "1@2.3"));
        }});
        assertEquals(1, userService.getUsers().size());
    }
}
