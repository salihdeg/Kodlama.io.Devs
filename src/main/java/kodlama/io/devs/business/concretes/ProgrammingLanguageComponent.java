package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataaccess.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageComponent implements ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageComponent(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public void create(ProgrammingLanguage programmingLanguage) {

        isNameEmpty(programmingLanguage.getName());
        isNameExist(programmingLanguage.getName());

        programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {

        isNameEmpty(programmingLanguage.getName());
        isNameExist(programmingLanguage.getName());

        if (!programmingLanguageRepository.existsById(programmingLanguage.getId()))
            throw new RuntimeException(programmingLanguage.getClass().getName() + " Not Found!");
        programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(Long id) {
        if (!programmingLanguageRepository.existsById(id))
            throw new RuntimeException(" Not Found!");
        programmingLanguageRepository.delete(programmingLanguageRepository.findById(id).get());
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.findAll();
    }

    @Override
    public ProgrammingLanguage getById(Long id) {
        return programmingLanguageRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    private void isNameEmpty(String name) {
        if (name.isBlank())
            throw new RuntimeException("Name cannot be null or empty!");
    }

    private void isNameExist(String name) {
        if (programmingLanguageRepository.existsByName(name)) {
            throw new RuntimeException("Name Exist!");
        }
    }
}
