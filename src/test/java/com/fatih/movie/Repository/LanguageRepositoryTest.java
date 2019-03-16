package com.fatih.movie.Repository;

import com.fatih.movie.model.Language;
import com.fatih.movie.repository.LanguageRepository;
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
public class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    @Test
    public void TestfindByLanguageName(){

        Language language = new Language();
        language.setId(1);
        Language findByLanguageName = languageRepository.findOne(language.getId());
        //In database we already have an genre with id=1 and languageName=English
        assertThat(findByLanguageName).hasFieldOrPropertyWithValue("languageName","English");
    }
}
