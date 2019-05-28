package services.implementations;

import org.apache.deltaspike.core.api.future.Futureable;
import services.CryptocurrencyGenerator;
import services.Service;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
// alternative version of the bean is used by the application only if that version is declared in the beans.xml file
@Alternative
public class ETHMiningService implements Serializable, Service {

    @Inject
    CryptocurrencyGenerator generator;

    @Futureable
    public Future<String> doWork() {
        System.out.println("ETH mining started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // This is fine :)
        }

        int minedBTC = generator.generate(1, 1000);
        String message = "ETH mined: " + minedBTC;

        return new AsyncResult<>(message);
    }
}
