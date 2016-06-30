[![Download](https://api.bintray.com/packages/moreno/maven/fontbinder/images/download.svg)](https://bintray.com/moreno/maven/fontbinder/_latestVersion)
[![License](https://img.shields.io/:License-Apache-orange.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

# FontBinder

[**Kotlin**](http://kotlinlang.org/) fork of **Lisa Wray**'s [fontbinding](https://github.com/lisawray/fontbinding) available in JCenter.

## Usage

Enable Data Binding in your project, add your font files to the `assets\fonts\` directory and initialize the library in the onCreate method of your **Application** class:
```java
// Java
@Override public void onCreate() {
    super.onCreate();
    FontBinder.INSTANCE.init(this);
}
```
```kotlin
// Kotlin
override fun onCreate() {
    super.onCreate()
    FontBinder.init(this)
}
```

Then, you can add `app:font='@{"YourFontFileName"}'` to the TextViews in your layout:
```xml
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto" >

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="16dp" >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="32sp"
            android:text="Hello World!"
            app:font='@{"Alegreya-Bold"}' />

    </RelativeLayout>

</layout>
```

#### Notice:
* In your layouts, use font file names without extension
* Make sure you write the quotation marks in that same way
* Use `DataBindingUtil.setContentView(...)` or `DataBindingUtil.inflate(...)` to inflate your layouts

## Setup

#### Gradle

```gradle
android {
    ...
    dataBinding { 
        enabled true 
    }
}

dependencies {
    compile 'com.github.nitrico.fontbinder:fontbinder:1.0.0'
}
```

## License
```txt
Copyright 2016 Miguel Ángel Moreno
Copyright 2015 Lisa Wray

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
