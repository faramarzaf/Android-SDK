# Wiki Menu


* Simple Popup Menu


```kotlin
          val mylist = listOf("Title1", "Title1", "Title3")
            SimpleMenuInflater.showPopUpMenu(this, mylist, view, object : CallbackPopUpMenu {
                override fun onClick(title: String) {
                    Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
                }
            })

```
* Icon Popup Menu

```kotlin
 SimpleMenuInflater.iconPopUpMenu(this, view, R.menu.layoutpopup,
                object : CallbackPopUpMenu {
                    override fun onClick(title: String) {
                        Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
                    }
                })
```

 `R.menu.layoutpopup` 

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:id="@+id/menu"
        android:title="title"
        android:icon="@drawable/icon"

        />

</menu>
```
