package kodlama.io.devs.webapi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.ProgrammingLanguage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
    private final ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping
    public List<ProgrammingLanguage> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable Long id){
        return programmingLanguageService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ProgrammingLanguage programmingLanguage){
        programmingLanguageService.create(programmingLanguage);
    }

    @PutMapping
    public void update(@RequestBody ProgrammingLanguage programmingLanguage){
        programmingLanguageService.update(programmingLanguage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        programmingLanguageService.delete(id);
    }
}
