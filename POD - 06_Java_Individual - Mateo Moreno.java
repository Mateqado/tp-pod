package Tp;
import java.util.ArrayList;
import java.util.List;

// Clase base para el café
abstract class Coffee{
    protected List<Ingredient> ingredients = new ArrayList<>();

    public int basePrice(){
        return 15;
    }

    public int ingredientPrice(){
        return ingredients.stream().mapToInt(Ingredient::plusPrice).sum();
    }

    public abstract int sizePrice();

    public int price(){
        return basePrice() + sizePrice() + ingredientPrice();
    }

    public void add(Ingredient ingredient){
        ingredients.add(ingredient);
    }
}

// Tamaños de café con precios específicos
class SmallSizeCoffee extends Coffee{
	@Override
    public int sizePrice(){
        return 5;
    }
}

class MediumSizeCoffee extends Coffee{
    @Override
    public int sizePrice(){
        return 7;
    }
}

class LargeSizeCoffee extends Coffee{
    @Override
    public int sizePrice(){
        return 10;
    }
}

// Clase base para los ingredientes
abstract class Ingredient{
    public abstract int plusPrice();
}

// Ingredientes específicos con precios individuales
class Chocolate extends Ingredient{
    @Override
    public int plusPrice(){
        return 7;
    }
}

class Candy extends Ingredient{
    @Override
    public int plusPrice(){
        return 12;
    }
}

class Cream extends Ingredient{
    @Override
    public int plusPrice(){
        return 10;
    }
}

class Rocklets extends Ingredient{
    @Override
    public int plusPrice(){
        return 15;
    }
}

class Sugar extends Ingredient{
    @Override
    public int plusPrice(){
        return 1;
    }
}

// Ejemplo de uso
public class Tp6{
    public static void main(String[] args){
        Coffee coffee = new MediumSizeCoffee();
        coffee.add(new Chocolate());
        coffee.add(new Sugar());
        coffee.add(new Cream());

        System.out.println("Price of the coffee: " + coffee.price()); // 15(base) + 7(size) + 18(ingredients) = 40
    }
}

