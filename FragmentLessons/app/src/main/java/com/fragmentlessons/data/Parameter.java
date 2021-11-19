package com.fragmentlessons.data;

public class Parameter {
    private final String    parameterName;
    private String          parameterValue;
    private final String    parameterAbout;
    private final int       parameterIco;
    private final int       parameterProgress;
    private final int       parameterMaxValue;
    private final int       parameterMinValue;

    public Parameter(String name, String about, String value, int img, int progress, int minValue, int maxValue) {
        this.parameterName = name;
        this.parameterAbout = about;
        this.parameterValue = value;
        this.parameterIco = img;
        this.parameterProgress = progress;
        this.parameterMaxValue = maxValue;
        this.parameterMinValue = minValue;
    }

    public String getParameterName() { return parameterName; }
    public String getParameterAbout() { return parameterAbout; }
    public String getParameterValue() { return parameterValue; }
    public void setParameterValue(String parameterValue) { this.parameterValue = parameterValue; }

    public int getParameterIco() { return parameterIco; }
    public int getParameterMaxValue() { return parameterMaxValue; }
    public int getParameterMinValue() { return parameterMinValue; }
    public int getParameterProgress() { return parameterProgress; }
}
