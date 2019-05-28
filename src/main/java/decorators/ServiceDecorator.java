package decorators;

import services.Service;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.concurrent.Future;

@Decorator
//Interceptors for a method are called before decorators
//that apply to the method.
public abstract class ServiceDecorator implements Service {

    @Inject
    @Delegate
    @Any
    Service service;

    public Future<String> doWork() {
        System.out.println("ServiceDecorator decorated " + service.getClass().getName());
        return service.doWork();
    }

}