# BatteryHelper  

```kotlin
val batteryHelper = BatteryHelper(this)
val percent =  batteryHelper.getBatteryLevel()
       
        batteryHelper.checkSaveMode(object : BatterySaveModeCallback {
            override fun saveModeOn() {
               // do your work
            }

            override fun saveModeOff() {
               // do your work
            }
        })

```
