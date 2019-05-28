package services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.Random;

@ApplicationScoped
@Specializes
public class SpecializedCryptocurrentyGenerator extends CryptocurrencyGenerator{

    @Override
    public int generate(int min, int max){
        //random with between -> nextInt((max - min) + 1) + min;
        System.out.println("This is a specialized generation");
        return new Random().nextInt((max - min) + 1) + min;
    }
}
