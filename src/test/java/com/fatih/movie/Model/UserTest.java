package com.fatih.movie.Model;

import com.fatih.movie.model.User;
import com.fatih.movie.model.Role;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void IdGetterSetter(){
        User user = new User();
        user.setId(1);
        assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    public void UsernameGetterSetter() {
        User user = new User();
        user.setUsername("TestUsername");
        assertThat(user.getUsername()).isEqualTo("TestUsername");
    }

    @Test
    public void EmailGetterSetter(){
        User user = new User();
        user.setEmail("TestEmail");
        assertThat(user.getEmail()).isEqualTo("TestEmail");
    }

    @Test
    public void PasswordGetterSetter(){
        User user = new User();
        user.setPassword("TestPassword");
        assertThat(user.getPassword()).isEqualTo("TestPassword");
    }

    @Test
    public void RolesGetterSetter(){
        User user = new User();
        Collection<Role> role = new HashSet<>();
        user.setRoles(role);
        assertThat(user.getRoles()).isEqualTo(role);


    }

    @Test
    public void toStringTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("TestUsername");
        user.setPassword("TestPassword");
        user.setEmail("TestEmail");
        Collection<Role> role = new HashSet<>();
        user.setRoles(role);
        assertThat(user.toString()).isEqualTo( "User{" +
                "id=" + 1 +
                ", username='" + "TestUsername" + '\'' +
                ", email='" + "TestEmail" + '\'' +
                ", password='" + "TestPassword" + '\'' +
                ", roles=" + user.getRoles() +
                '}');
    }
}
