package me.lubab.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    AnimalList animals;

    @GetMapping("/")
    public List getAll() {
        return animals.findAll();
    }

    @PostMapping("/")
    public Animal create(@Valid @RequestBody Animal animal) {
        return animals.save(animal);
    }

    @GetMapping("/id={id}")
    public Animal getById(@PathVariable(value = "id") Integer id) throws AnimalError {
        return animals.findById(id)
                .orElseThrow(() -> new AnimalError(id));
    }

    @GetMapping("/kind={kind}")
    public List<Animal> getByKind(@PathVariable(value = "kind") String kind) {
        return animals.findAllByKind(kind);
    }

    @GetMapping("/name={name}")
    public List<Animal> getByName(@PathVariable(value = "name") String name) {
        return animals.findAllByNameContaining(name);
    }

    @PutMapping("/id={id}")
    public Animal update(@PathVariable(value = "id") Integer id,
                             @Valid @RequestBody Animal animalDetails) throws AnimalError {

        Animal animal = animals.findById(id)
                .orElseThrow(() -> new AnimalError(id));
        animal.setName(animalDetails.getName());
        animal.setKind(animalDetails.getKind());
        animal.setPrice(animalDetails.getPrice());
        Animal updatedAnimal = animals.save(animal);
        return updatedAnimal;
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) throws AnimalError {
        Animal animal = animals.findById(id)
                .orElseThrow(() -> new AnimalError(id));
        animals.delete(animal);
        return ResponseEntity.ok().build();
    }
}
