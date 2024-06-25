package cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.domain.*;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    List<Fruit> findByNameContaining(String name);
}