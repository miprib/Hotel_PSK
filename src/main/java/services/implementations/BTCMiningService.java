package services.implementations;

import org.apache.deltaspike.core.api.future.Futureable;
import services.CryptocurrencyGenerator;
import services.Service;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
public class BTCMiningService implements Serializable, Service {

    @Inject
    CryptocurrencyGenerator generator;

    @Futureable
    public Future<String> doWork() {
        System.out.println("BTC mining started");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // This is fine :)
        }

        int minedBTC = generator.generate(1000, 2000);
        String message = "BTC mined: " + minedBTC;

        return new AsyncResult<>(message);
    }

}
