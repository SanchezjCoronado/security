package com.example.DSJuQ_Actividad4.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private PersonaRepository repository;

    @GetMapping
    List<Persona> findAll(){
        return repository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    Persona newPersona(@RequestBody Persona newPersona) {
        return repository.save(newPersona);
    }

    @GetMapping("/{id}")
    Persona findOne(@PathVariable @Min(1) Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    Persona saveOrUpdate(@RequestBody Persona newPersona, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setnombre(newPersona.getnombre());
                    x.setapellido(newPersona.getapellido());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newPersona.setId(id);
                    return repository.save(newPersona);
                });
    }


    @DeleteMapping("/{id}")
    void deletePersona(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
