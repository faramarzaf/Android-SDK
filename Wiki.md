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

        SimpleDialog(
            this, //context
            R.drawable.shapeA, // background of rootLayout
            R.drawable.shapeB, // background of positive button
            R.drawable.shapeC, // background of negative button
            R.drawable.ShapeD // image or background src of dialog
        )
            .setNegativeButton("Text_Negative").setPositiveButton("Text_Positive")
            .setText("This is a title")
            .setCallBack(object : DialogCallback {
                override fun onPositiveButtonClicked() {
                    Toast.makeText(applicationContext, "ok", Toast.LENGTH_SHORT).show()
                }

                override fun onNegativeButtonClicked() {
                    Toast.makeText(applicationContext, "no", Toast.LENGTH_SHORT).show()
                }
            }).showDialog()


```





