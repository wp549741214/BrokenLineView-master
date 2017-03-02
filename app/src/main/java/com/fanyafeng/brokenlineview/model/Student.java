package com.fanyafeng.brokenlineview.model;

import java.util.List;

/**
 * Created by wangpeng on 2017/3/1.
 * email:peng.wangjt@ikang.com
 * explain:
 */

public class Student {
    String name;
    List<Course> list;

    public Student(String name, List<Course> list) {
        this.name = name;
        this.list = list;
    }

    public Student() {
    }

    public List<Course> getList() {
        return list;
    }

    public void setList(List<Course> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  static class  Course{
        String classname;

        public Course(String classname) {
            this.classname = classname;
        }

        public String getClassname() {
            return classname;
        }
    }
}
