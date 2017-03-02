package com.fanyafeng.brokenlineview.model;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/9.
 * email:peng.wangjt@ikang.com
 * explain:
 */

public class HealthData {


    /**
     * 一般检查项 : {"体重指数":{"abscissaNum":3,"coordinateValues":[{"checkResult":18.42,"checkUnit":"mmHg","regDate":"2015-04-05"},{"checkResult":24.42,"checkUnit":"mmHg","regDate":"2016-07-16"}],"itemName":"体重指数","itemNormalMax":23.99,"itemNormalMin":18.5,"itemNormalValue":"18.55 -- 23.50","itemUnit":"mmHG","ordinateMax":24.42,"ordinateMin":18.5,"showValueType":1}}
     */

    private NormalBean normal;

    public NormalBean getNormal() {
        return normal;
    }

    public void setNormal(NormalBean normal) {
        this.normal = normal;
    }


}
