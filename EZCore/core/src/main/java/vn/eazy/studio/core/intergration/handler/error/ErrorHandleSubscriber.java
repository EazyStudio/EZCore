package vn.eazy.studio.core.intergration.handler.error;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by harryle on 6/23/17.
 */

public class ErrorHandleSubscriber<T> implements Subscriber<T> {
    private ErrorHandlerFactory mHandlerFactory;

    public ErrorHandleSubscriber(RxErrorHandler rxErrorHandler) {
        this.mHandlerFactory = rxErrorHandler.getHandlerFactory();
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        mHandlerFactory.handleError(t);
    }

    @Override
    public void onComplete() {

    }
}
