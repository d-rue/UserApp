package de.drue.UserApp.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HomeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class HomeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homeControllerHomeReturnsString() throws Exception {
        // Arrange

        // Act
        ResultActions response = mockMvc.perform(get("/"));

        // Assert
        response.andExpect(status().isOk())
                .andExpect(content().encoding("UTF-8"))
                .andExpect(content().string(containsString("Home")));
    }

    @Test
    public void homeControllerUserReturnsString() throws Exception {
        // Arrange

        // Act
        ResultActions response = mockMvc.perform(get("/user"));

        // Assert
        response.andExpect(status().isOk())
                .andExpect(content().encoding("UTF-8"))
                .andExpect(content().string(containsString("Hallo User")));
    }

    @Test
    public void homeControllerAdminReturnsString() throws Exception {
        // Arrange

        // Act
        ResultActions response = mockMvc.perform(get("/admin"));

        // Assert
        response.andExpect(status().isOk())
                .andExpect(content().encoding("UTF-8"))
                .andExpect(content().string(containsString("Hallo Admin")));
    }
}

