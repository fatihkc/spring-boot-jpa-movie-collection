package com.fatih.movie.Repository;

import com.fatih.movie.model.User;
import com.fatih.movie.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//Testing the initial database which is configured in /resources/db.migration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void TestfindByEmail(){

        User user = new User();
        user.setId(2);
        User findByEmail = userRepository.findOne(user.getId());
        //In database we already have an genre with id=2 and email=mail@fatihkoc.net
        assertThat(findByEmail).hasFieldOrPropertyWithValue("email","mail@fatihkoc.net");
    }
}
