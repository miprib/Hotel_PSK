package usecases;

import services.BTCMiningService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Model
public class SimulateWork implements Serializable {
    @Inject
    BTCMiningService BTCMiningService;

    private Future<Integer> miningTask = null;

    public String mineBTC() {
        miningTask = BTCMiningService.mineBTC();

        return "mineBTC.xhtml?faces-redirect=true";
    }

    public boolean isMining() {
        return miningTask != null && !miningTask.isDone();
    }

    public String getMiningStatus() throws ExecutionException, InterruptedException {
        if (miningTask == null) {
            return null;
        } else if (isMining()) {
            return "Mining in progress";
        }
        return "BTC mined: " + miningTask.get();
    }
}