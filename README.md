[![Download](https://api.bintray.com/packages/moreno/maven/fontbinder/images/download.svg)](https://bintray.com/moreno/maven/fontbinder/_latestVersion)
[![License](https://img.shields.io/:License-Apache-orange.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

# FontBinder

Easy font usage in your XML layouts with Android Data Binding. 

It is a JCenter-added fork of **Lisa Wray**'s [**fontbinding**](https://github.com/lisawray/fontbinding) library written in [**Kotlin**](http://kotlinlang.org).

## Usage

Enable [Data Binding](https://developer.android.com/topic/libraries/data-binding/index.html) in your project and initialize the library in the onCreate method of your **Application** class:

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

Then, you can add `app:font='@{"FontFileNameWithoutExtension"}'` to your TextViews:

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
* Make sure you write the quotation marks in that same way
* Font files must be located in your `assets\fonts\` folder
* Use `DataBindingUtil.setContentView(...)` or `DataBindingUtil.inflate(...)` to inflate your layouts
* You might want to check [**LastAdapter**](https://github.com/nitrico/LastAdapter) to use it with RecyclerView
 

#### Programmatically

FontBinder **automatically caches used typefaces** to avoid repeating its creation in the future. To use it programmatically:

```java
// Java
mTextView.setTypeface(FontBinder.INSTANCE.get("FontFileNameWithoutExtension"));
```
```kotlin
// Kotlin
mTextView.typeface = FontBinder["FontFileNameWithoutExtension"]
```

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
