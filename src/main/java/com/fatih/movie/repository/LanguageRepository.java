package com.fatih.movie.repository;

import com.fatih.movie.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Language findByLanguageName(String name);
}
