# Android-SDK  


[![](https://jitpack.io/v/faramarzaf/Android-SDK.svg)](https://jitpack.io/#faramarzaf/Android-SDK)




Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  

Step 2. Add the dependency

	dependencies {
	   implementation 'com.github.faramarzaf:Android-SDK:1.0.17'
	}





* Be aware that always put this scripts to your `app/build.gradle`  file


```gradle

android {
. . . 
 compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}


```
