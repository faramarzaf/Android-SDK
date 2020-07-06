# Wiki   


**Progress Dialog**

```kotlin

private var progressDialog: ProgressDialogCustom? = null


 fun showProgressDialog() {
        try {
            if (progressDialog == null) {
                progressDialog = ProgressDialogCustom(this, R.drawable.imgdialog, true)  
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
