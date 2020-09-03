# Android-SDK  

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![](https://jitpack.io/v/faramarzaf/Android-SDK.svg)](https://jitpack.io/#faramarzaf/Android-SDK)

# What is the purpose of this project?
Today, as projects become larger and more complex, a new way of developing software has been adopted and is commonly known as modular programming. By doing so, the focus is more on module development. And so next time a new project will cost both less time and money. It is also much easier to ensure the performance of a small component than an oversized part. So the main purpose of this project is speed up your development with safe way. If you are looking for how to use this module, you can find the **Wiki** files in main page.


# Setup
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  

Step 2. Add the dependency

	dependencies {
	   implementation 'com.github.faramarzaf:Android-SDK:1.0.18'
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
