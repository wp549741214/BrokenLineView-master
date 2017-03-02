package com.fanyafeng.brokenlineview.model;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/21.
 * email:peng.wangjt@ikang.com
 * explain:
 */

public class Result {

    /**
     * code : 1
     * errors :
     * message : 操作成功
     * results : [[{"className":"一般项目检查","itemDateDetail":[{"abscissaNum":0,"coordinateValues":[{"checkResult":1,"checkUnit":"Kg","regDate":"2016-07-11"},{"checkResult":70,"checkUnit":"Kg","regDate":"2016-07-12"},{"checkResult":48,"checkUnit":"Kg","regDate":"2016-07-06"}],"itemName":"体重","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"Kg","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":4,"coordinateValues":[{"checkResult":1,"checkUnit":"mmHg","regDate":"2016-07-11"},{"checkResult":80,"checkUnit":"mmHg","regDate":"2016-07-12"},{"checkResult":80,"checkUnit":"mmHg","regDate":"2016-07-06"}],"itemName":"收缩压","itemNormalMax":139,"itemNormalMin":90,"itemNormalValue":"90 -- 139","itemUnit":"mmHg","ordinateMax":0,"ordinateMin":0,"showValueType":1},{"abscissaNum":4,"coordinateValues":[{"checkResult":1,"checkUnit":"mmHg","regDate":"2016-07-11"},{"checkResult":90,"checkUnit":"mmHg","regDate":"2016-07-12"},{"checkResult":90,"checkUnit":"mmHg","regDate":"2016-07-06"}],"itemName":"舒张压","itemNormalMax":89,"itemNormalMin":60,"itemNormalValue":"60 -- 89","itemUnit":"mmHg","ordinateMax":0,"ordinateMin":0,"showValueType":1},{"abscissaNum":0,"coordinateValues":[{"checkResult":1,"checkUnit":"cm","regDate":"2016-07-11"},{"checkResult":178,"checkUnit":"cm","regDate":"2016-07-12"},{"checkResult":165,"checkUnit":"cm","regDate":"2016-07-06"}],"itemName":"身高","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"cm","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":4,"coordinateValues":[{"checkResult":1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":26,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":23,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"体重指数","itemNormalMax":23.99,"itemNormalMin":18.5,"itemNormalValue":"18.5 -- 23.99","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":1}]},{"className":"内科","itemDateDetail":[{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"脾脏触诊","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"肺部听诊","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"病史","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"心律","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"肾脏叩诊","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"次/分","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"次/分","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"次/分","regDate":"2016-07-06"}],"itemName":"心率","itemNormalMax":100,"itemNormalMin":60,"itemNormalValue":"60 -- 100","itemUnit":"次/分","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"肝脏触诊","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"内科其它","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"心音","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"家族史","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3}]},{"className":"血常规","itemDateDetail":[{"abscissaNum":0,"coordinateValues":[{"checkResult":3,"checkUnit":"10^9/L","regDate":"2016-07-06"}],"itemName":"中性粒细胞绝对值","itemNormalMax":7,"itemNormalMin":2,"itemNormalValue":"2.0 -- 7.0","itemUnit":"10^9/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":20,"checkUnit":"%","regDate":"2016-07-06"}],"itemName":"中间细胞百分比","itemNormalMax":15,"itemNormalMin":0,"itemNormalValue":"0 -- 15","itemUnit":"%","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":30,"checkUnit":"pg","regDate":"2016-07-06"}],"itemName":"平均红细胞血红蛋白含量","itemNormalMax":35,"itemNormalMin":25,"itemNormalValue":"25 -- 35","itemUnit":"pg","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":30,"checkUnit":"%","regDate":"2016-07-06"}],"itemName":"淋巴细胞百分比","itemNormalMax":40,"itemNormalMin":20,"itemNormalValue":"20 -- 40","itemUnit":"%","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":7,"checkUnit":"fL","regDate":"2016-07-06"}],"itemName":"平均血小板体积","itemNormalMax":13.6,"itemNormalMin":6.8,"itemNormalValue":"6.8 -- 13.6","itemUnit":"fL","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":5,"checkUnit":"10^9/L","regDate":"2016-07-06"}],"itemName":"白细胞计数","itemNormalMax":10,"itemNormalMin":4,"itemNormalValue":"4.0 -- 10.0","itemUnit":"10^9/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":80,"checkUnit":"%","regDate":"2016-07-06"}],"itemName":"中性粒细胞百分比","itemNormalMax":70,"itemNormalMin":50,"itemNormalValue":"50 -- 70","itemUnit":"%","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":0.2,"checkUnit":"10^9/L","regDate":"2016-07-06"}],"itemName":"中间细胞绝对值","itemNormalMax":1.1,"itemNormalMin":0.1,"itemNormalValue":"0.1 -- 1.1","itemUnit":"10^9/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":90,"checkUnit":"10^9/L","regDate":"2016-07-06"}],"itemName":"血小板计数","itemNormalMax":320,"itemNormalMin":85,"itemNormalValue":"85 -- 320","itemUnit":"10^9/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":120,"checkUnit":"g/L","regDate":"2016-07-06"}],"itemName":"血红蛋白","itemNormalMax":160,"itemNormalMin":110,"itemNormalValue":"110 -- 160","itemUnit":"g/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":320,"checkUnit":"g/L","regDate":"2016-07-06"}],"itemName":"平均红细胞血红蛋白浓度","itemNormalMax":370,"itemNormalMin":310,"itemNormalValue":"310 -- 370","itemUnit":"g/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":1,"checkUnit":"10^9/L","regDate":"2016-07-06"}],"itemName":"淋巴细胞绝对值","itemNormalMax":4,"itemNormalMin":0.8,"itemNormalValue":"0.8 -- 4.0","itemUnit":"10^9/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":40,"checkUnit":"fL","regDate":"2016-07-06"}],"itemName":"红细胞分布宽度-标准差","itemNormalMax":53.9,"itemNormalMin":30,"itemNormalValue":"30 -- 53.9","itemUnit":"fL","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":50,"checkUnit":"L/L","regDate":"2016-07-06"}],"itemName":"红细胞压积","itemNormalMax":50,"itemNormalMin":40,"itemNormalValue":"40 -- 50","itemUnit":"L/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":11,"checkUnit":"fL","regDate":"2016-07-06"}],"itemName":"血小板分布宽度","itemNormalMax":18.1,"itemNormalMin":10.5,"itemNormalValue":"10.5 -- 18.1","itemUnit":"fL","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":5,"checkUnit":"10^12/L","regDate":"2016-07-06"}],"itemName":"红细胞计数","itemNormalMax":5.5,"itemNormalMin":4,"itemNormalValue":"4.0 -- 5.5","itemUnit":"10^12/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":90,"checkUnit":"fL","regDate":"2016-07-06"}],"itemName":"平均红细胞体积","itemNormalMax":95,"itemNormalMin":81,"itemNormalValue":"81 -- 95","itemUnit":"fL","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":15,"checkUnit":"%","regDate":"2016-07-06"}],"itemName":"血小板压积","itemNormalMax":43,"itemNormalMin":13,"itemNormalValue":"13 -- 43","itemUnit":"%","ordinateMax":0,"ordinateMin":0,"showValueType":2}]},{"className":"实验室检查","itemDateDetail":[{"abscissaNum":0,"coordinateValues":[{"checkResult":6,"checkUnit":"U/L","regDate":"2016-07-12"},{"checkResult":6,"checkUnit":"U/L","regDate":"2016-07-06"}],"itemName":"天门冬氨酸氨基转移酶","itemNormalMax":40,"itemNormalMin":5,"itemNormalValue":"5 -- 40","itemUnit":"U/L","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":0,"coordinateValues":[{"checkResult":11,"checkUnit":"U/L","regDate":"2016-07-11"},{"checkResult":6,"checkUnit":"U/L","regDate":"2016-07-12"},{"checkResult":6,"checkUnit":"U/L","regDate":"2016-07-06"}],"itemName":"丙氨酸氨基转移酶","itemNormalMax":40,"itemNormalMin":5,"itemNormalValue":"5 -- 40","itemUnit":"U/L","ordinateMax":0,"ordinateMin":0,"showValueType":2}]},{"className":"超声检查室","itemDateDetail":[{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"胰","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"心脏","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"胆","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"双肾","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"肝","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3},{"abscissaNum":0,"coordinateValues":[{"checkResult":-1,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"脾","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":3}]}]]
     */

    private int code;
    private String errors;
    private String message;
    private List<List<ResultsBean>> results;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<List<ResultsBean>> getResults() {
        return results;
    }

    public void setResults(List<List<ResultsBean>> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * className : 一般项目检查
         * itemDateDetail : [{"abscissaNum":0,"coordinateValues":[{"checkResult":1,"checkUnit":"Kg","regDate":"2016-07-11"},{"checkResult":70,"checkUnit":"Kg","regDate":"2016-07-12"},{"checkResult":48,"checkUnit":"Kg","regDate":"2016-07-06"}],"itemName":"体重","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"Kg","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":4,"coordinateValues":[{"checkResult":1,"checkUnit":"mmHg","regDate":"2016-07-11"},{"checkResult":80,"checkUnit":"mmHg","regDate":"2016-07-12"},{"checkResult":80,"checkUnit":"mmHg","regDate":"2016-07-06"}],"itemName":"收缩压","itemNormalMax":139,"itemNormalMin":90,"itemNormalValue":"90 -- 139","itemUnit":"mmHg","ordinateMax":0,"ordinateMin":0,"showValueType":1},{"abscissaNum":4,"coordinateValues":[{"checkResult":1,"checkUnit":"mmHg","regDate":"2016-07-11"},{"checkResult":90,"checkUnit":"mmHg","regDate":"2016-07-12"},{"checkResult":90,"checkUnit":"mmHg","regDate":"2016-07-06"}],"itemName":"舒张压","itemNormalMax":89,"itemNormalMin":60,"itemNormalValue":"60 -- 89","itemUnit":"mmHg","ordinateMax":0,"ordinateMin":0,"showValueType":1},{"abscissaNum":0,"coordinateValues":[{"checkResult":1,"checkUnit":"cm","regDate":"2016-07-11"},{"checkResult":178,"checkUnit":"cm","regDate":"2016-07-12"},{"checkResult":165,"checkUnit":"cm","regDate":"2016-07-06"}],"itemName":"身高","itemNormalMax":0,"itemNormalMin":0,"itemNormalValue":"","itemUnit":"cm","ordinateMax":0,"ordinateMin":0,"showValueType":2},{"abscissaNum":4,"coordinateValues":[{"checkResult":1,"checkUnit":"","regDate":"2016-07-11"},{"checkResult":26,"checkUnit":"","regDate":"2016-07-12"},{"checkResult":23,"checkUnit":"","regDate":"2016-07-06"}],"itemName":"体重指数","itemNormalMax":23.99,"itemNormalMin":18.5,"itemNormalValue":"18.5 -- 23.99","itemUnit":"","ordinateMax":0,"ordinateMin":0,"showValueType":1}]
         */

        private String className;
        private List<ItemDateDetailBean> itemDateDetail;

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public List<ItemDateDetailBean> getItemDateDetail() {
            return itemDateDetail;
        }

        public void setItemDateDetail(List<ItemDateDetailBean> itemDateDetail) {
            this.itemDateDetail = itemDateDetail;
        }

        public static class ItemDateDetailBean {
            /**
             * abscissaNum : 0
             * coordinateValues : [{"checkResult":1,"checkUnit":"Kg","regDate":"2016-07-11"},{"checkResult":70,"checkUnit":"Kg","regDate":"2016-07-12"},{"checkResult":48,"checkUnit":"Kg","regDate":"2016-07-06"}]
             * itemName : 体重
             * itemNormalMax : 0
             * itemNormalMin : 0
             * itemNormalValue :
             * itemUnit : Kg
             * ordinateMax : 0
             * ordinateMin : 0
             * showValueType : 2
             */

            private int abscissaNum;
            private String itemName;
            private int itemNormalMax;
            private int itemNormalMin;
            private String itemNormalValue;
            private String itemUnit;
            private int ordinateMax;
            private int ordinateMin;
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

            public int getItemNormalMax() {
                return itemNormalMax;
            }

            public void setItemNormalMax(int itemNormalMax) {
                this.itemNormalMax = itemNormalMax;
            }

            public int getItemNormalMin() {
                return itemNormalMin;
            }

            public void setItemNormalMin(int itemNormalMin) {
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

            public int getOrdinateMax() {
                return ordinateMax;
            }

            public void setOrdinateMax(int ordinateMax) {
                this.ordinateMax = ordinateMax;
            }

            public int getOrdinateMin() {
                return ordinateMin;
            }

            public void setOrdinateMin(int ordinateMin) {
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

            public void setCoordinateValues(List<CoordinateValuesBean> coordinateValues) {
                this.coordinateValues = coordinateValues;
            }

            public static class CoordinateValuesBean {
                /**
                 * checkResult : 1
                 * checkUnit : Kg
                 * regDate : 2016-07-11
                 */

                private int checkResult;
                private String checkUnit;
                private String regDate;

                public int getCheckResult() {
                    return checkResult;
                }

                public void setCheckResult(int checkResult) {
                    this.checkResult = checkResult;
                }

                public String getCheckUnit() {
                    return checkUnit;
                }

                public void setCheckUnit(String checkUnit) {
                    this.checkUnit = checkUnit;
                }

                public String getRegDate() {
                    return regDate;
                }

                public void setRegDate(String regDate) {
                    this.regDate = regDate;
                }
            }
        }
    }
}
