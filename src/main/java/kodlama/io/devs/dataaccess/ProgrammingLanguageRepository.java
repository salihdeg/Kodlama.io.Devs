package kodlama.io.devs.dataaccess;

import kodlama.io.devs.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Long> {
    Optional<ProgrammingLanguage> findById(Long id);
    boolean existsByName(String name);
}
