# Wiki   


**Progress Dialog**

```kotlin

private var progressDialog: ProgressDialogCustom? = null


 fun showProgressDialog() {
        try {
            if (progressDialog == null) {
                 progressDialog = ProgressDialogCustom(this,R.layout.layout_dialog_progress,R.drawable.imgdialog, false)
            }
            progressDialog!!.show()

        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    fun hideProgressDialog() {
        try {
            if (progressDialog != null) {
                progressDialog!!.dismiss()
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

```

**Simple Dialog**

```kotlin  

        SimpleDialog(this)
            .cancelable(true)
            .setNegativeButton("Text_Negative")
            .setPositiveButton("Text_Positive")
            .setText("This is a title")
            .showDialog()
            .setTitleColor(Color.YELLOW)
            .setTypeface(this, "assetFont.ttf")
            .setTextSize(28f, 12f)
            .setImageDialogBackground(R.drawable.ic_launcher_foreground)
            .setDialogBackground(R.drawable.shape1)
            .setPositiveBackground(R.drawable.shape_2, Color.RED)
            .setNegativeBackground(R.drawable.shape_3, Color.rgb(255, 255, 255))
            .setCallBack(object : DialogCallback {
                override fun onPositiveButtonClicked() {
                    // do your work
                }

                override fun onNegativeButtonClicked() {
                    // do your work
                }
            })
            
```


**Menu**



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
