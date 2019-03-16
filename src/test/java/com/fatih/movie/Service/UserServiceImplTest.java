package com.fatih.movie.Service;

import com.fatih.movie.model.User;
import com.fatih.movie.model.Role;
import com.fatih.movie.repository.UserRepository;
import com.fatih.movie.service.UserService;
import com.fatih.movie.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashSet;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    private UserService userService;

    @Test
    public void findByEmailTest(){
        UserServiceImpl userService = new UserServiceImpl(userRepository,passwordEncoder);

        User user = new User();
        user.setId(5);
        user.setUsername("TestUsername");
        user.setPassword("TestPassword");
        user.setEmail("TestEmail");
        Collection<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(2);
        role.setName("TestRoleName");
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);

        when(userRepository.findByEmail("TestEmail")).thenReturn(user);

        User user1 = userService.findByEmail("TestEmail");
        assertThat(user1).isEqualTo(user);
    }
}
