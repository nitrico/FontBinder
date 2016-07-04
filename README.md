[![Download](https://api.bintray.com/packages/moreno/maven/fontbinder/images/download.svg)](https://bintray.com/moreno/maven/fontbinder/_latestVersion)
[![Size](https://img.shields.io/badge/Size-13 KB-e91e63.svg)](http://www.methodscount.com/?lib=com.github.nitrico.fontbinder%3Afontbinder%3A%2B)
[![License](https://img.shields.io/:License-Apache 2.0-orange.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

# FontBinder

Easy font usage in your XML layouts with Android Data Binding. 

It is a JCenter-added fork of **Lisa Wray**'s [**fontbinding**](https://github.com/lisawray/fontbinding) library written in [**Kotlin**](http://kotlinlang.org).

## Usage

Enable [Data Binding](https://developer.android.com/topic/libraries/data-binding/index.html) and add the dependency in your `build.gradle` file. 

Now, you can start using `android:font=...` in your TextViews:

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android" >

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent" >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello World!"
            android:font='@{"Alegreya-Bold"}' />

    </RelativeLayout>

</layout>
```

#### Notice:
* Make sure you use the `<layout>` tag and write the quotation marks in that same way
* Font files must be located in your `assets\fonts\` folder
* Use `DataBindingUtil.setContentView(...)` or `DataBindingUtil.inflate(...)` to inflate your layouts
* Android Studio may warn you in the `android:font` line with "unknown attribute". Don't worry
* You might want to check [**LastAdapter**](https://github.com/nitrico/LastAdapter) to use it with RecyclerView


#### Cache

FontBinder **automatically caches used typefaces** to avoid recreating them in the future. To use the cached fonts programmatically:

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
    compile 'com.github.nitrico.fontbinder:fontbinder:1.0.1'
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
