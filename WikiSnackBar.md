# Wiki SnackBar


* Simple SnackBar

```kotlin

SimpleSnackbar.show(rootView,"textSnackBar",backgroundColor,textColor,isShortTime)

```  


```kotlin

SimpleSnackbar.show(context, rootView, "textSnackBar", "font.ttf", backgroundColor, textColor, isShortTime)

```


```kotlin
SimpleSnackbar.show(rootView, "textSnackBar", "textAction", backgroundColor, textColor, textActionColor, isShortTime, object : CallbackSnackBar {
                override fun onActionClick() {
                   // do your work
                }
            })
```



```kotlin

  SimpleSnackbar.show(context,rootView, "textSnackBar", "textAction", backgroundColor, textColor, textActionColor, "font.ttf",false, object : CallbackSnackBar {
                override fun onActionClick() {
                      // do your work
                }
            })
            
```
