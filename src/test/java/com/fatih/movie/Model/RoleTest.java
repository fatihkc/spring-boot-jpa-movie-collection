package com.fatih.movie.Model;

import com.fatih.movie.model.Role;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleTest {

    @Test
    public void NameGetter() {
        Role role = new Role("TestRole");
        assertThat(role.getName()).isEqualTo("TestRole");
    }

    @Test
    public void NameSetter(){
        Role role = new Role("TestRole");
        role.setName("TestRole2");
        assertThat(role.getName()).isEqualTo("TestRole2");
    }

    @Test
    public void IdGetterSetter()
    {
        Role role = new Role("TestRole");
        role.setId(1);
        assertThat(role.getId()).isEqualTo(1);
    }

    @Test
    public void toStringTest(){
        Role role = new Role("TestRole");
        role.setId(1);
        role.setName("test");
        assertThat(role.toString()).isEqualTo("Role{" +
                "id=" + "1" +
                ", name='" + "test" + '\'' +
                '}');
    }
}
