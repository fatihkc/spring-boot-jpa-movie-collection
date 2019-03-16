package com.fatih.movie.Model;


import com.fatih.movie.dto.UserRegistrationDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRegistrationDtoTest {

    @Test
    public void UsernameGetterSetter() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setUsername("TestUsername");
        assertThat(userRegistrationDto.getUsername()).isEqualTo("TestUsername");
    }

    @Test
    public void PasswordGetterSetter() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setPassword("TestPassword");
        assertThat(userRegistrationDto.getPassword()).isEqualTo("TestPassword");
    }

    @Test
    public void ConfirmPasswordGetterSetter() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setConfirmPassword("TestConfirmPassword");
        assertThat(userRegistrationDto.getConfirmPassword()).isEqualTo("TestConfirmPassword");
    }

    @Test
    public void EmailGetterSetter(){
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setEmail("TestEmail");
        assertThat(userRegistrationDto.getEmail()).isEqualTo("TestEmail");
    }
}
