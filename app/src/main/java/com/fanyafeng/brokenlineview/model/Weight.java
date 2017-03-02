package com.fanyafeng.brokenlineview.model;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/9.
 * email:peng.wangjt@ikang.com
 * explain:
 */

public class Weight {

    private int abscissaNum;
    private String itemName;
    private double itemNormalMax;
    private double itemNormalMin;
    private String itemNormalValue;
    private String itemUnit;
    private double ordinateMax;
    private double ordinateMin;
    private int showValueType;
    private List<CoordinateValuesBean> coordinateValues;

    public int getAbscissaNum() {
        return abscissaNum;
    }

    public void setAbscissaNum(int abscissaNum) {
        this.abscissaNum = abscissaNum;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemNormalMax() {
        return itemNormalMax;
    }

    public void setItemNormalMax(double itemNormalMax) {
        this.itemNormalMax = itemNormalMax;
    }

    public double getItemNormalMin() {
        return itemNormalMin;
    }

    public void setItemNormalMin(double itemNormalMin) {
        this.itemNormalMin = itemNormalMin;
    }

    public String getItemNormalValue() {
        return itemNormalValue;
    }

    public void setItemNormalValue(String itemNormalValue) {
        this.itemNormalValue = itemNormalValue;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public double getOrdinateMax() {
        return ordinateMax;
    }

    public void setOrdinateMax(double ordinateMax) {
        this.ordinateMax = ordinateMax;
    }

    public double getOrdinateMin() {
        return ordinateMin;
    }

    public void setOrdinateMin(double ordinateMin) {
        this.ordinateMin = ordinateMin;
    }

    public int getShowValueType() {
        return showValueType;
    }

    public void setShowValueType(int showValueType) {
        this.showValueType = showValueType;
    }

    public List<CoordinateValuesBean> getCoordinateValues() {
        return coordinateValues;
    }

    public void setCoordinateValues(List<CoordinateValuesBean>  coordinateValues) {
        this.coordinateValues = coordinateValues;
    }
}
