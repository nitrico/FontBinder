[![Download](https://api.bintray.com/packages/moreno/maven/fontbinder/images/download.svg)](https://bintray.com/moreno/maven/fontbinder/_latestVersion)
[![License](https://img.shields.io/:License-Apache-orange.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

# FontBinder

Kotlin fork of **Lisa Wray**'s [fontbinding](https://github.com/lisawray/fontbinding) available in JCenter.

## Usage

Add your font files to the `assets\fonts\` directory and In your **Application** class:

```java
// if using Java
@Override public void onCreate() {
    super.onCreate();
    FontBinder.INSTANCE.init(this);
}
```
```kotlin
// if using Kotlin
override fun onCreate() {
    super.onCreate()
    FontBinder.init(this)
}
```

Then, in your layout add ```app:font='@{"YourFont"}'```

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
