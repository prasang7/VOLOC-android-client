# VOLOC-Android-Client
This repository contains the android client of VOLOC. 

## Development Setup
1. Go to the project repo and click the `Fork` button
2. Clone your forked repository : `https://github.com/VOLOC/VOLOC-android-client.git`
3. Move to android project folder `cd source-code`
4. Open the project with Android Studio

## How to build
All dependencies are defined in ```source-code/app/build.gradle```. Import the project in Android Studio or use Gradle in command line:
```
./gradlew assembleRelease
```
The result apk file will be placed in ```source-code/app/build/outputs/apk/```.
