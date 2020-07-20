package com.faramarzaf.sdk.af_android_sdk.core.enums;

import com.google.android.material.snackbar.Snackbar;

public enum EnumSnackBar {

    SHORT("Snackbar.LENGTH_SHORT", Snackbar.LENGTH_SHORT),
    LONG("Snackbar.LENGTH_LONG", Snackbar.LENGTH_LONG);

    private String valueString;
    private Integer value;

    EnumSnackBar(String valueString, Integer value) {
        this.valueString = valueString;
        this.value = value;
    }

    public static EnumSnackBar get(String value) {
        if (value == null) {
            return SHORT;
        }
        EnumSnackBar[] arr$ = values();
        for (EnumSnackBar val : arr$) {
            if (val.valueString.equalsIgnoreCase(value.trim())) {
                return val;
            }
        }
        return SHORT;

    }

    public static EnumSnackBar get(Integer value) {
        if (value == null) {
            return SHORT;
        }

        EnumSnackBar[] arr$ = values();
        for (EnumSnackBar val : arr$) {
            if (val.value == value) {
                return val;
            }
        }

        return SHORT;
    }


    public String getValueStr() {
        return valueString;
    }

    public Integer getValue() {
        return value;
    }

    public void setValueStr(String valueStr) {
        this.valueString = valueStr;
    }

}
