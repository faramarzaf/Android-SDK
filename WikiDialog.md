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
            .setText("Description")
            .setPositiveButton("Yes")
            .setNegativeButton("no")
            .showDialog()
            .setTypeface("font.ttf")
            .setTitleColor(Color.rgb(0, 0, 0))
            .setTextSize(16f, 13f)
            .setPositiveBackground(R.drawable.shapeA, Color.WHITE)
            .setNegativeBackground(R.drawable.shapeA, Color.WHITE)
            .setImageDialogBackground(R.drawable.ic)
            .setDialogBackground(R.drawable.shape)
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

new SimpleDialog(tihs)
                        .cancelable(true)
                        .setText("Title")
                        .setPositiveButton("Yes")
                        .setNegativeButton("No")
                        .showDialog()
                        .setTypeface("font.ttf")
                        .setTitleColor(Color.rgb(0, 0, 0))
                        .setTextSize(16, 13)
                        .setPositiveBackground(R.drawable.shapeA, Color.WHITE)
                        .setNegativeBackground(R.drawable.shapeB, Color.WHITE)
                        .setImageDialogBackground(R.drawable.ic)
                        .setDialogBackground(R.drawable.shape)
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

**PublicDialog**    

```kotlin
            PublicDialog.yesNoDialog(context, "Title", "Message", "text_positive", "text_negative", R.drawable.icon, object : DialogCallback {
                override fun onPositiveButtonClicked() {
                    // do your work
                }

                override fun onNegativeButtonClicked() {
                    // do your work
                }
            })


```




