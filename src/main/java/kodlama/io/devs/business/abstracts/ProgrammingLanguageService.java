package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    void create(ProgrammingLanguage programmingLanguage);
    void update(ProgrammingLanguage programmingLanguage);
    void delete(Long id);
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getById(Long id);
}
