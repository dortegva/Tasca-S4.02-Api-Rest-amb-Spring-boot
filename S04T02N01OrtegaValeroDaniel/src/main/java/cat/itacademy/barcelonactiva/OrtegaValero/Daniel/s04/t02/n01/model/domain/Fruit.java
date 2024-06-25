package cat.itacademy.barcelonactiva.OrtegaValero.Daniel.s04.t02.n01.model.domain;
import jakarta.persistence.*;

import lombok.Getter;

@Getter
@Entity
@Table(name = "fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String name;

    @Column(name = "description")
    private int quantity;

    public Fruit(){

    }

    public Fruit (String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}