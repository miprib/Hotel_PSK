package usecases;

import services.Service;

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
    Service service;

    private Future<String> miningTask = null;

    public String mine() {
        miningTask = service.doWork();

        return "mine.xhtml?faces-redirect=true";
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
        System.out.println("Cryptocurrency mining completed");

        return miningTask.get();
    }
}