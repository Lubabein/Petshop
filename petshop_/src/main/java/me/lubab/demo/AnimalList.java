package me.lubab.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalList extends JpaRepository<Animal, Integer> {

    List<Animal> findAllByKind(@Param("kind") String kind);
    List<Animal> findAllByNameContaining(@Param("name") String name);
}
