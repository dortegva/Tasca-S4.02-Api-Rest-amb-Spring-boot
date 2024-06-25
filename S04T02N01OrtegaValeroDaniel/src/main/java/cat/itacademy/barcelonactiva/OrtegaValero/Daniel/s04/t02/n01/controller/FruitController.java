package cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.controller;
import cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        try {
            Fruit newFruit = fruitService.createFruit(fruit);
            return new ResponseEntity<>(newFruit, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFruit(@PathVariable int id, @RequestBody Fruit fruit) {
        Optional<Fruit> fruitch = fruitService.getFruitById(id);

        if(fruitch.isEmpty())
            return new ResponseEntity<>("fruit not found " + id, HttpStatus.NOT_FOUND);
        else {
            Fruit frutaUpdate = fruitService.updateFruit(id, fruit.getName(), fruit.getQuantity());
            return new ResponseEntity<>(frutaUpdate,HttpStatus.OK);
        }


    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruit(@PathVariable int id) {
        try {
            fruitService.deleteFruit(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        HashMap<String, Boolean> fruitDeletedState = new HashMap<String, Boolean>();
        fruitDeletedState.put("Deleted", true);

        return ResponseEntity.ok(fruitDeletedState);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitById(@PathVariable int id) {
        Optional<Fruit> fruitch = fruitService.getFruitById(id);

        if(fruitch.isEmpty())
            return new ResponseEntity<>("Fruit not found " + id, HttpStatus.NOT_FOUND);
        else {
            return new ResponseEntity<>(fruitch,HttpStatus.OK);
        }


    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        try {
            return ResponseEntity.ok(fruitService.getAllFruits());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}