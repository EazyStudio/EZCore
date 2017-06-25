# EZCore
Code base for Android

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e46a5082c247489c944efac4c26ed807)](https://www.codacy.com/app/harryle-fit/EZCore?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=harrylefit/EZCore&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/97cba1f2-14d3-42e8-9132-d39393d259b8)](https://codebeat.co/projects/github-com-harrylefit-ezcore-master)

Using :
- [ButterKnife](https://github.com/JakeWharton/butterknife)
- [EventBus](https://github.com/greenrobot/EventBus)
- [Dagger](https://github.com/google/dagger)
- [RxJava](https://github.com/ReactiveX/RxJava)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Retrofit](https://github.com/square/retrofit)
- [OkHttp](https://github.com/square/okhttp)
- [Glide](https://github.com    /bumptech/glide)
- [RxPermission](https://github.com/tbruyelle/RxPermissions)

- **Views :**
    - **EazyTextView :** code base for TextView
    - **EazyEditText :** code base for Edit Text
    - **EazyButton :** code base for Button

Example :

```java
public class BookerlyTextView extends EazyTextView{
    public BookerlyTextView(Context context) {
        super(context);
    }

    public BookerlyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BookerlyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected String createDefaultFont() {
        return "fonts/bookerly/bookerly_regular.ttf";
    }

    @Override
    protected String createLightFont() {
        return createDefaultFont();
    }

    @Override
    protected String createRegularFont() {
        return createDefaultFont();
    }

    @Override
    protected String createMediumFont() {
        return createDefaultFont();
    }

    @Override
    protected String createItalicFont() {
        return createDefaultFont();
    }

    @Override
    protected String createThinFont() {
        return createDefaultFont();
    }

    @Override
    protected String createBoldFont() {
        return "fonts/bookerly/bookerly_bold.ttf";
    }

    @Override
    protected String createBlackFont() {
        return createDefaultFont();
    }
}
```
- **MultiStateView :** Android View that displays different content based on its state.
  The four different states the view can be in are:
    - Content
    - Empty
    - Error
    - Loading
    
# Using MultiStateView
MultiStateView can be used the same as any other view by adding it as a layout file via XML
```xml
<vn.eazy.studio.core.state_view.MultiStateView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/lyMultiState"
    app:msv_emptyView="@layout/ez_empty_view"
    app:msv_loadingView="@layout/ez_loading_view"
    app:msv_errorView="@layout/ez_error_view"
    app:msv_viewState="content"
    tools:context="vn.eazy.studio.core.example.MainActivity">

    <vn.eazy.studio.core.example.widgets.BookerlyButton
        android:id="@+id/btStateView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="State View"
        android:layout_gravity="center"
       />
</vn.eazy.studio.core.state_view.MultiStateView>
```
The attributes to set for MultiStateView are
```xml
<attr name="msv_loadingView" format="reference" />
<attr name="msv_emptyView" format="reference" />
<attr name="msv_errorView" format="reference" />
<attr name="msv_viewState" format="enum">
<attr name="msv_animateViewChanges" format="boolean" />
```
To switch the state of MultiStateView, simply call
```java 
public void setViewState(@ViewState int state)
```

You can also get the View for the accompanying ViewState by calling
```java
public View getView(@ViewState int state)
```
- **ConfigModule :** Manage ActivityLifeCycles, FragmentLifeCycles, ApplicationLifeCycle. Configuration for Retrofit, Gson,... as quickly as possible.

Example : Create a class to handle configuration like this.
```java
public class GlobalConfiguration implements ConfigModule {
    private final String TAG = this.getClass().getSimpleName();
    @Override
    public void applyOptions(Context context, GlobalModule.Builder builder) {
        builder.baseUrl("http://github.com");
        builder.retrofitConfiguration(new ClientModule.RetrofitConfiguration() {
            @Override
            public void configRetrofit(Context context, Retrofit.Builder builder) {

            }
        });
        builder.okHttpConfiguration(new ClientModule.OkHttpConfiguration() {
            @Override
            public void configOkHttp(Context context, OkHttpClient.Builder builder) {

            }
        });
        builder.gsonConfiguration(new AppModule.GsonConfiguration() {
            @Override
            public void configGson(Context context, GsonBuilder builder) {

            }
        });
    }

    @Override
    public void registerComponents(Context context, IRepositoryManager repositoryManager) {

    }

    @Override
    public void injectAppLifeCycles(Context context, List<AppDelegate.LifeCycle> lifeCycles) {

        Log.d(TAG,"Inject App Lifecycle");
    }

    @Override
    public void injectActivityLifeCycles(Context context, List<Application.ActivityLifecycleCallbacks> activityLifeCycles) {
        Log.d(TAG,"Inject Activity Lifecycle");
    }

    @Override
    public void injectFragmentLifeCycles(Context context, List<FragmentManager.FragmentLifecycleCallbacks> fragmentLifecycleCallbacks) {

    }
}

```

  Add metadata into AndroidManifest like this:
  ```xml
  <meta-data
            android:name="vn.eazy.studio.core.example.base.GlobalConfiguration" // path to class
            android:value="ConfigModule" />
  ```



##Setup
This library is not yet released in Maven Central, until then you can add as a library module or use JitPack.io

In build.gradle (top-level)

Add remote maven url in

```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

```gradle
dependencies {
	implementation 'com.github.harrylefit:EZCore:v1.0'
        
    //network
    implementation(rootProject.ext.dependencies["retrofit"]) {
        exclude module: "okhttp"
    }
    implementation rootProject.ext.dependencies["retrofit-converter-gson"]
    implementation(rootProject.ext.dependencies["retrofit-adapter-rxjava2"]) {
        exclude module: "rxjava"
    }
    implementation rootProject.ext.dependencies["okhttp3"]
    implementation rootProject.ext.dependencies["okhttp-urlconnection"]
    implementation(rootProject.ext.dependencies["logging-interceptor"]) {
        exclude group: 'org.json', module: 'json'
    }
    implementation rootProject.ext.dependencies["glide"]

    //Reactive
    implementation rootProject.ext.dependencies["rxandroid2"]
    implementation rootProject.ext.dependencies["rxjava2"]

    //Eventbus
    implementation rootProject.ext.dependencies["event-bus"]

    //View
    implementation rootProject.ext.dependencies["butter-knife"]
    provided "javax.annotation:jsr250-api:1.0"
    annotationProcessor rootProject.ext.dependencies["butter-knife-compiler"]

    //Permissions
    implementation rootProject.ext.dependencies["rx-permissions"]

    //Dagger
    implementation rootProject.ext.dependencies["dagger"]
    annotationProcessor rootProject.ext.dependencies["dagger-compiler"]
}
```


#Licence

Apache License, Version 2.0


    Copyright (C) 2017, Harry Le

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
