package com.fanyafeng.brokenlineview.view;

/**
 * Created by wangpeng on 2017/2/20.
 * email:peng.wangjt@ikang.com
 * explain:
 */

public class CoordinateValue {

    public CoordinateValue(double checkResult, String regDate) {
        this.regDate = regDate;
        this.checkResult = checkResult;
    }

    public String regDate;// 体检时间
    public Double checkResult;// 检查结果
    public String checkUnit;//检查单位

}
