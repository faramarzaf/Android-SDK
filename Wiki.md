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
            .setImageDialogBackground(R.drawable.ic_launcher_foreground)
            .setNegativeBackground(R.drawable.shape_2, Color.RED)
            .setPositiveBackground(R.drawable.shape_1, Color.RED)
            .setDialogBackground(R.drawable.shape_round_corner_dialog)
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
                 new SimpleDialog(MainActivity.this,
                          R.drawable.shapeA,
                          R.drawable.shapeB,
                          R.drawable.shapeC,
                          R.drawable.shapeD)
                        .setText("Title")
                        .setPositiveButton("Text_Positive")
                        .setNegativeButton("Text_Negative")
                        .setCallBack(new DialogCallback() {
                            @Override
                            public void onPositiveButtonClicked() {
                              // do your work
                            }

                            @Override
                            public void onNegativeButtonClicked() {
                             // do your work
                            }
                        }).show();
```




