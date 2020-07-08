# Dialog  


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

*Java usage*  
```java

              new SimpleDialog(this)
                        .cancelable(true)
                        .setNegativeButton("Text_Negative")
                        .setPositiveButton("Text_Positive")
                        .setText("This is a title")
                        .showDialog()
                        .setTitleColor(Color.YELLOW)
                        .setTypeface("font.ttf")
                        .setTextSize(28f, 12f)
                        .setImageDialogBackground(R.drawable.ic_launcher_foreground)
                        .setDialogBackground(R.drawable.bg)
                        .setPositiveBackground(R.drawable.bg, Color.RED)
                        .setNegativeBackground(R.drawable.bg, Color.rgb(255, 255, 255))
                        .setCallBack(new DialogCallback() {
                    @Override
                    public void onPositiveButtonClicked() {
                          // do your work
                    }

                    @Override
                    public void onNegativeButtonClicked() {
                         // do your work
                    }
                });

```

