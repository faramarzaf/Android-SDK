# Wiki Notification





* Simple Notification

```kotlin
     
     NotificationProvider.simpleNotification(context,"Title","Body","Channel",R.drawable.icon,Color.RED)

```



* Expand Notification

```kotlin
        val changes = arrayOfNulls<String>(5)
        changes[0] = "Delete option"
        changes[1] = "Update option"
        changes[2] = "Share option"
        changes[3] = "Introduction option"
        NotificationProvider.expandNotification(context, "This is title", "This is body","This is channel", "This is big content",changes, R.drawable.icon, Color.RED)

```

