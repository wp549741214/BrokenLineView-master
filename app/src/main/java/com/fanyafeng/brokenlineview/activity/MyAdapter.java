package com.fanyafeng.brokenlineview.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.fanyafeng.brokenlineview.R;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/24.
 * email:peng.wangjt@ikang.com
 * explain:
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    String TAG="recycle";
    private List<Integer> list;
    private Context mContext;

    public MyAdapter(List<Integer> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContext);
        switch (viewType){
            case 0:
                MyHolder holder=new MyHolder(inflater.inflate(R.layout.item_webview,null));
                return holder;
            case 1:

                MyHolder2 holder2=new MyHolder2(inflater.inflate(R.layout.item_text,null));
                return holder2;
            default:
                MyHolder holder3=new MyHolder(inflater.inflate(R.layout.item_webview,null));
                return holder3;

        }

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case 0:
                MyHolder holder1= (MyHolder) holder;
                holder1.webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        super.onPageStarted(view, url, favicon);
                        Log.d(TAG, "onPageStarted() called with: view = [" + view + "], url = [" + url + "], favicon = [" + favicon + "]");
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        Log.d(TAG, "onPageFinished() called with: view = [" + view + "], url = [" + url + "]");
                    }

                    @Override
                    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                        super.onReceivedSslError(view, handler, error);
                    }
                });
                holder1.webView.setWebChromeClient(new WebChromeClient(){
                    @Override
                    public void onProgressChanged(WebView view, int newProgress) {
                        super.onProgressChanged(view, newProgress);
                         Log.d(TAG, "onProgressChanged() called with: view = [" + view + "], newProgress = [" + newProgress + "]");
                    }

                });
                holder1.webView.loadUrl("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&ch=3&tn=98012088_2_dg&wd=recycleview%20layoutmanager&oq=No%2520layout%2520manager%2520attached%253B%2520skipping%2520layout&rsv_pq=baea54c20001cdd0&rsv_t=5e08tgC08F64rkk8Uf7YfY2rfLIE8YE%2BypTD09gaEc45d7luKBpEcbdoBooZ5Ey1jUb3Ng&rqlang=cn&rsv_enter=1&inputT=116311&rsv_sug3=67&rsv_sug1=44&rsv_sug7=100&rsv_sug2=0&rsv_sug4=116311");
                break;
            case 1:
            default:
                MyHolder2 holder2= (MyHolder2) holder;
                holder2.textView.setText("aaaaaaaaa");
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position);
    }

    public class MyHolder extends RecyclerView.ViewHolder{
            WebView webView;
            public MyHolder(View itemView) {
                super(itemView);
                webView= (WebView) itemView.findViewById(R.id.web);
            }
        }

    public class MyHolder2 extends RecyclerView.ViewHolder{
        TextView textView;
        public MyHolder2(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
