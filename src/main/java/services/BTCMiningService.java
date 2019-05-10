package services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
public class BTCMiningService implements Serializable {

    @Futureable
    public Future<Integer> mineBTC() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // This is fine :)
        }

        final Integer minedBTC = new Random().nextInt(1337);
        return new AsyncResult<>(minedBTC);
    }
}
