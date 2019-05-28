package services;

import java.util.concurrent.Future;

public interface Service {
    Future<String> doWork();
}
