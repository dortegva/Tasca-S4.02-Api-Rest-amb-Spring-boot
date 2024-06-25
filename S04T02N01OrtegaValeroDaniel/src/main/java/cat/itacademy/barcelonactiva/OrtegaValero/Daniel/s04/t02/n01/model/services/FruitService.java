package cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.services;
import cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitService implements FruitServiceInterface {

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit createFruit(Fruit fruit){
        if (fruit.getName().isEmpty() || fruit.getQuantity() <= 0) {

        } else {
            return fruitRepository.save(fruit);
        }

        return fruit;
    }

    @Override
    public void deleteFruit(int id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if (optionalFruit.isEmpty()){
        }else{
            fruitRepository.deleteById(id);
        }
    }

    @Override
    public Optional getFruitById(int id) {
        return fruitRepository.findById(id);
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
    @Override
    public Fruit updateFruit (int id, String newName, int newKg){
        Optional<Fruit> frutaBuscada = fruitRepository.findById(id);

        if(frutaBuscada.isPresent()){
            Fruit fruit = frutaBuscada.get();
            fruit.setName(newName);
            fruit.setQuantity(newKg);
            return fruitRepository.save(fruit);

        } else {
            return null;
        }
    }

}