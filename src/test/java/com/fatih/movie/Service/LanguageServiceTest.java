package com.fatih.movie.Service;

import com.fatih.movie.model.Language;
import com.fatih.movie.repository.LanguageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LanguageServiceTest {

    @Mock
    private LanguageRepository languageRepository;

    @Test
    public void getAllLanguage() {
        Language language1 = new Language();
        language1.setId(1);
        language1.setLanguageName("TestLanguage1");
        Language language2 = new Language();
        language2.setId(2);
        language2.setLanguageName("TestLanguage2");

        when(languageRepository.findOne(1)).thenReturn(language1);
        when(languageRepository.findOne(2)).thenReturn(language2);

        assertThat(language1.getLanguageName()).hasToString("TestLanguage1");
        assertThat(language2.getLanguageName()).hasToString("TestLanguage2");
    }
}
