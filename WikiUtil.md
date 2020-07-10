# Utils 

* MyPreferences    

* TempConverter    

* ClickGuard   


* CounterDown  


```kotlin
    ClickGuard.guardView(textview, delay, object : DoGuardTask {
            override fun onGuard(view: View) {
                CounterDown.printer(duration, interval, textview, Color.Disable, Color.Enable, "Retry Text",isFarsiDigit:Boolean)
            }
        })
```
