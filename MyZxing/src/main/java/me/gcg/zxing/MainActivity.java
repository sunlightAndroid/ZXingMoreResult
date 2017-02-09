package me.gcg.zxing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv_rsult;
    private EditText et_text;
    private ImageView image;

//    QRCodeMultiReader;
//    DecodeHandler

//    http://blog.csdn.net/cod0904/article/details/52779369

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_rsult = (TextView) findViewById(R.id.tv_result);
        et_text = (EditText) findViewById(R.id.et_text);
        image = (ImageView) findViewById(R.id.iv_image);

        // 这里是我们测试branch和pull request，所以加上这个注释，表示我们修改了代码

//        CaptureActivityHandler;

    }
    /**扫描二维码*/
    public void scan(View view){
        // 开启ZXing库中可以扫描的二维码的Activity
        Intent intent = new Intent(this, CaptureActivity.class);
        // 要有返回结果
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){


            ArrayList<String> result = data.getStringArrayListExtra("result");

            String s="";

            for (int i = 0; i <result.size() ; i++) {
                s+="第"+i+"个结果："+result.get(i)+"\n";
            }

            tv_rsult.setText(s);
        }
    }

}
