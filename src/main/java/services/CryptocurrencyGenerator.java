package services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class CryptocurrencyGenerator {

    public int generate(int min, int max){
        //random with between -> nextInt((max - min) + 1) + min;
        return new Random().nextInt((max - min) + 1) + min;
    }
}
