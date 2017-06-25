package vn.eazy.studio.core.di.component;

import android.app.Application;

import com.google.gson.Gson;

import java.io.File;
import java.util.Map;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import vn.eazy.studio.core.delegate.AppDelegate;
import vn.eazy.studio.core.di.module.AppModule;
import vn.eazy.studio.core.di.module.ClientModule;
import vn.eazy.studio.core.di.module.GlobalModule;
import vn.eazy.studio.core.intergration.IRepositoryManager;
import vn.eazy.studio.core.intergration.handler.error.RxErrorHandler;


/**
 * Created by harryle on 6/17/17.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, GlobalModule.class})
public interface AppComponent {
    Application application();

    OkHttpClient okHttpClient();

    Gson gson();

    File cacheFile();

    Map<String, Object> extras();

    IRepositoryManager getIRepositoryManager();

    RxErrorHandler rxErrorHandler();

    Retrofit retrofit();

    void inject(AppDelegate appDelegate);
}
