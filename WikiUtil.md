# Utils 

* MyPreferences (*deprecated!*)
* RootUtil

* ClickGuard   

```kotlin
ClickGuard.guardView(view, delay, object : DoGuardTask {
            override fun onGuard(view: View) {
                 //do your work
            }
        })
```

* MyDataStore   

```kotlin

 
// Write in Data Store.

  lifecycleScope.launch {
            MyDataStore(context).writeString("key-string", "hello i am test")
            MyDataStore(context).writeBoolean("key-boolean", true)
            MyDataStore(contexth).writeFloat("key-float", 46f)
            MyDataStore(context).writeInteger("key-integer", 25)
            MyDataStore(context).writeLong("key-long", 365L)
        }
        
        
// Read from Data Store.    

        lifecycleScope.launch {
            val value1 = MyDataStore(context).readString("key-string")
            val value2 = MyDataStore(context).readFloat("key-float")
            val value3 = MyDataStore(context).readInteger("key-integer")
            val value4 = MyDataStore(context).readLong("key-long")
            val value5 = MyDataStore(context).readBoolean("key-boolean")
        }
        
// Clear all data of Data Store.  
    
    lifecycleScope.launch {
            MyDataStore(this@ActivitySplash).clearAll()
        }
    
```



* CounterDown  

```kotlin
    ClickGuard.guardView(textview, delay, object : DoGuardTask {
            override fun onGuard(view: View) {
                CounterDown.printer(duration, interval, textview, Color.Disable, Color.Enable, "Retry Text",isFarsiDigit:Boolean)
            }
        })
```


* SensorUtility
```kotlin

SensorUtility.getTypeAmbientTemperatureSensor(this, object : TemperatureSensorCallback {
            override fun sensorNotAvailable(message: String) {
                Log.d("TAG", "sensorNotAvailable: $message")
            }

            override fun sensorAvailable(message: String) {
                Log.d("TAG", "sensorAvailable: $message")
            }

            override fun onSensorChanged(value: Float) {
                Log.d("TAG", "onSensorChanged: $value")
            }
        })

SensorUtility.getTypeTemperatureSensor(this,object :TemperatureSensorCallback{
            override fun sensorNotAvailable(message: String) {
                Log.d("TAG", "sensorNotAvailable: $message")
            }

            override fun sensorAvailable(message: String) {
                Log.d("TAG", "sensorAvailable: $message")
            }

            override fun onSensorChanged(value: Float) {
                Log.d("TAG", "onSensorChanged: $value")
            }
        })


```




