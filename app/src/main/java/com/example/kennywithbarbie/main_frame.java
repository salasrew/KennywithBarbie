package com.example.kennywithbarbie;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.CalendarView;

public class main_frame extends AppCompatActivity {

    private TextView text_days;
    private TextView text_warn;
    private EditText et_email;
    private Button btn_helper;
    private Button btn_kp;
    private Button btn_menu;
    private Button btn_other;
    private Button btn_pic_kenny;
    private Button btn_pic_barbie;
    public CalendarView calendar;


    String[] KP = {"月經小知識", "衛生棉種類介紹", "月經失調怎麼辦?","衛生棉是什麼?為什麼要用?"};
    //月經小知識
    String KP_0 = "1.女性血液或黏膜定期從子宮內膜經陰道排出體外的現象。\n" +
            "2.週期從21到35天，平均28天。\n" +
            "3.持續通常3~5天不等。\n" +
            "4.含有鈣質之食物可以舒緩疼痛。\n" +
            "5.俗稱：大姨媽、好朋友、那個。\n" +
            "6.巧克力含有咖啡因,適量可以舒緩疼痛,過量反而會加劇。\n" +
            "7.熱敷可以有效舒緩疼痛。\n" +
            "8.月經期間有腹脹,腹痛,頭痛,脹奶...因人而異。\n" +
            "9.真的頂不住，請轉往婦產科!\n";
    // https://meteor.today/article/e4DmHf

    String[] choose = {"拍照","從相簿選取"};

    //月經失調咋辦
    String KP_2 = "     月經失調是指女性月經週期、經期、出血量異常，是常見的女性疾病。\n" +
            "1.培養樂觀的態度，保持良好的心情，減輕工作壓力，尋找適當抒發情緒的方式。\n" +
            "2.生活作息規律、避免熬夜，睡眠要充足。\n" +
            "3.養成規律運動習慣，維持正常體重。\n" +
            "4.避免食用高溫燒烤、油炸的食物。\n" +
            "5.不吸煙、少喝酒。\n" +
            "6.嚴重的話，求助醫生，一樣婦產科\n";
    //https://health.udn.com/disease/sole/61699
    //月經是紅色,非廣告上的藍色,藍色是方便顯示

    // 建議食物
    String []menu = {"紅豆湯","紅肉火鍋","豬肝湯", "牛肉湯"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);

        text_days = (TextView) findViewById(R.id.text_days);
        text_warn = (TextView) findViewById(R.id.text_warn);
        btn_helper = (Button) findViewById(R.id.btn_helper);
        btn_kp = (Button) findViewById(R.id.btn_kp);
        btn_menu = (Button) findViewById(R.id.btn_menu);
        btn_other = (Button) findViewById(R.id.btn_other);
        btn_pic_kenny = findViewById(R.id.btn_pic_kenny);
        btn_pic_barbie = findViewById(R.id.btn_pic_barbie);
        calendar = findViewById( R.id.calendar);

        btn_helper.setOnClickListener(listener);
        btn_kp.setOnClickListener(listener2);
        btn_menu.setOnClickListener(listener3);

        Intent get = getIntent();
        int date = get.getIntExtra("date",0);

        text_days.setText("預計天數 : "+date);
        text_warn.setText("你暫時逃過一劫");

        btn_pic_kenny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(main_frame.this)
                        .setItems(choose, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which)
                                {
                                    case 0: // 照相
                                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        startActivityForResult(intent,0);
                                        break;
                                    case 1: //從相簿選取
                                        Intent pickphoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        startActivityForResult(pickphoto,1);
                                        Uri selectedImage = pickphoto.getData();
                                        //btn_pic_kenny.setBackgroundResource(selectedImage);

                                        break;

                                }
                            }
                        }).show();
            }
        });

        btn_pic_barbie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(main_frame.this)
                        .setItems(choose, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which)
                                {
                                    case 0: // 照相
                                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                        startActivityForResult(intent,0);
                                        break;
                                    case 1: //從相簿選取
                                        Intent pickphoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        startActivityForResult(pickphoto,0);
                                        break;

                                }
                            }
                        }).show();
            }
        });

    }

    // btn_小幫手
    private Button.OnClickListener listener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_helper) {
                // Generate Alert Dialog
                new AlertDialog.Builder(main_frame.this)
                        .setTitle("小幫手")
                        .setMessage("你今天經痛了嗎?朋友\n姨媽她可能會遲到 但她從不缺席")
                        .setPositiveButton("離開", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        }
    };
    //btn_科普知識
    private Button.OnClickListener listener2 = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_kp) {
                new AlertDialog.Builder(main_frame.this)
                        .setTitle("科普小知識")
                        .setItems(KP, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                switch (which)
                                {
                                    //月經小知識
                                    case 0:
                                        new AlertDialog.Builder(main_frame.this)
                                                .setTitle("月經小知識")
                                                .setMessage(KP_0)
                                                .setPositiveButton("我知道了", new DialogInterface.OnClickListener()
                                                {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which)
                                                    {
                                                    }
                                                })
                                                .show();
                                        return;
                                    //衛生棉種類
                                    case 1:
                                                Intent intent = new Intent();
                                                intent.setClass(main_frame.this,sanitary_napkin.class);
                                                startActivity(intent);
                                        return;
                                    //月經失調
                                    case 2:
                                        new AlertDialog.Builder(main_frame.this)
                                                .setTitle("月經失調怎麼辦?")
                                                .setMessage(KP_2)
                                                .setPositiveButton("我知道了", new DialogInterface.OnClickListener()
                                                {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which)
                                                    {
                                                    }
                                                }).show();
                                        return;

                                    case 3:
                                        new AlertDialog.Builder(main_frame.this)
                                                .setTitle("衛生棉是什麼?為什麼要用?")
                                                .setMessage("")
                                                .setPositiveButton("我知道了", new DialogInterface.OnClickListener()
                                                {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which)
                                                    {
                                                    }
                                                }).show();
                                        return;
                                }
                            }
                        }).show();
            }
        }
    };

    private Button.OnClickListener listener3 = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_menu) {
                new AlertDialog.Builder(main_frame.this)
                        .setTitle("美味食譜")
                        .setItems(menu, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                switch (which)
                                {
                                    //食譜
                                    case 0: //紅豆湯
                                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=WygY2KIUXTc&feature=youtu.be&fbclid=IwAR3p4udEvqmGkySXSsyCNurAyIKS4Guz-HnkmOvdQQC61oBzOkCUmDLL6zg")));
                                        Log.i("Video", "Video Playing....");
                                        // https://stackoverflow.com/questions/4654878/how-to-play-youtube-video-in-my-android-application
                                        return;
                                    case 1: //紅肉火鍋
                                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=uFmS-kLn3ao")));
                                        Log.i("Video", "Video Playing....");
                                        return;
                                    case 2: //麻油豬肝
                                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=0w-n8DuyGV8&feature=youtu.be&fbclid=IwAR2NbiS-71lOnD1COXQBrHNWcjeu8JJSFxLzOzyIlm7RVVcEUuIC4rQlvcI")));
                                        Log.i("Video", "Video Playing....");
                                        return;
                                }
                            }
                        }).show();
            }
        }
    };

    // 禁用返回鍵
    // https://blog.csdn.net/yiding_he/article/details/38527813
    public boolean onKeyDown(int keycode , KeyEvent event)
    {
        if(keycode == KeyEvent.KEYCODE_BACK)
        {
            return true;
        }
        return false;
    }






    // 部分內容參考
    // https://www.shs.edu.tw/works/essay/2008/10/2008103016075183.pdf
}