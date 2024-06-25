package cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.services;
import cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.domain.Fruit;
import java.util.List;
import java.util.Optional;


public interface FruitServiceInterface {
    public Fruit createFruit (Fruit fruit);
    public void deleteFruit(int id) ;
    public Optional getFruitById(int id);
    public List<Fruit> getAllFruits() ;
    public Fruit updateFruit (int id, String newName, int newKg);
}