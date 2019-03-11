package com.fatih.movie;

import static org.assertj.core.api.Assertions.assertThat;

import com.fatih.movie.controller.MainController;
import com.fatih.movie.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private MainController mainController;

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(mainController).isNotNull();
        assertThat(userController).isNotNull();
    }

}
