package com.fanyafeng.brokenlineview.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.fanyafeng.brokenlineview.R;
import com.fanyafeng.brokenlineview.BaseActivity;
import com.fanyafeng.brokenlineview.model.CoordinateValuesBean;
import com.fanyafeng.brokenlineview.model.HealthData;
import com.fanyafeng.brokenlineview.model.NormalBean;
import com.fanyafeng.brokenlineview.model.Student;
import com.fanyafeng.brokenlineview.model.Weight;
import com.fanyafeng.brokenlineview.view.BrokenLinePointBean;
import com.fanyafeng.brokenlineview.view.BrokenLineView;
import com.fanyafeng.brokenlineview.view.CoordinateValue;
import com.fanyafeng.brokenlineview.view.LineChartActivity;
import com.fanyafeng.brokenlineview.view.LineChartPositionManager;
import com.fanyafeng.brokenlineview.view.LineChartView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class MainActivity extends BaseActivity {
    private final static String TAG = "main";
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
//        String[] strs = new String[]{"1", "2", "3"};
//        Observable.from(strs).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.e(TAG, "call: " + s);
//            }
//        });

//

//        Observable.just(1, 2, 3, 4)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
////                        Log.d(TAG, "number:" + integer);
////                        Log.d(TAG, "call: " + Thread.currentThread().getName());
//                    }
//                });
        Observable.just("images/logo.png")
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.length();
                    }
                }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.e(TAG, "call: "+integer);
            }
        });

        List<Student> list=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Student student=new Student();
            student.setName("王"+i);
            List<Student.Course> courses=new ArrayList<>();
            for (int i1 = 0; i1 < 3; i1++) {
                Student.Course course=new Student.Course(i1+"");
                courses.add(course);
            }
            student.setList(courses);
            list.add(student);
        }

        Observable.from(list)
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.getName();
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e(TAG, "call: "+s);
            }
        });

        Observable.from(list).flatMap(new Func1<Student, Observable<Student.Course>>() {
            @Override
            public Observable<Student.Course> call(Student student) {
                return Observable.from(student.getList());
            }
        }).subscribe(new Action1<Student.Course>() {
            @Override
            public void call(Student.Course course) {
                Log.e(TAG, "call: "+course.getClassname() );
            }
        });
    }


}
