package com.francivaldo.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    TextView textView;
    Button bt_more_options,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt_play;
    boolean iscliked = false;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        bt_more_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_more_optionsAction();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blink_anim();
                bt_more_optionsAction();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bounce();
                bt_more_optionsAction();

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fade_in();
                bt_more_optionsAction();

            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fade_out();
                bt_more_optionsAction();

            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                let_to_right();
                bt_more_optionsAction();

            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mixed_anim();
                bt_more_optionsAction();
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right_to_left();
                bt_more_optionsAction();
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotation();
                bt_more_optionsAction();
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sample_anim();
                bt_more_optionsAction();
            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoom_in();
                bt_more_optionsAction();
            }
        });
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoom_out();
                bt_more_optionsAction();
            }
        });
        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(animation == null)
                    Toast.makeText(MainActivity.this,"selecione um tipo de animacao no menu au lado!",Toast.LENGTH_SHORT).show();
                else
                    textView.startAnimation(animation);
            }
        });
    }

    private void bt_more_optionsAction() {
        Animation animationLayout;
        if(!iscliked){
            animationLayout = AnimationUtils.loadAnimation(MainActivity.this,R.anim.lefttoright);
            layout.startAnimation(animationLayout);
            Utils.delay(720, new Utils.DelayCallback() {
                @Override
                public void afterDelay() {
                    layout.animate().translationX(0);
                    layout.animate().start();
                    iscliked = true;
                }
            });


        }
        else {
            animationLayout = AnimationUtils.loadAnimation(MainActivity.this,R.anim.righttoleft);
            layout.startAnimation(animationLayout);
            Utils.delay(720, new Utils.DelayCallback() {
                @Override
                public void afterDelay() {
                    layout.animate().translationX(-layout.getWidth());
                    layout.animate().start();
                    iscliked = false;
                }
            });
        }
    }

    private void initComponents(){

        layout = findViewById(R.id.layout_options);
        bt_more_options = findViewById(R.id.btn_more_options);
        bt1 = findViewById(R.id.blink_anim);
        bt2 = findViewById(R.id.bounce);
        bt3 = findViewById(R.id.fade_in);
        bt4 = findViewById(R.id.fade_out);
        bt5 = findViewById(R.id.let_to_right);
        bt6 = findViewById(R.id.mixed_anim);
        bt7 = findViewById(R.id.right_to_left);
        bt8 = findViewById(R.id.rotation);
        bt9 = findViewById(R.id.sample_anim);
        bt10 = findViewById(R.id.zoom_in);
        bt11 = findViewById(R.id.zoom_out);
        textView = findViewById(R.id.txt_hello_world);
        bt_play = findViewById(R.id.btn_play);
    }

    public void blink_anim() {
        animation = AnimationUtils.loadAnimation(this,R.anim.blink_anime);
    }

    public void bounce() {
        animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
    }

    public void fade_in() {
        animation = AnimationUtils.loadAnimation(this,R.anim.fadein);
    }

    public void fade_out() {
        animation = AnimationUtils.loadAnimation(this,R.anim.fadeout);
    }

    public void let_to_right() {
        animation = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
    }

    public void mixed_anim() {
        animation = AnimationUtils.loadAnimation(this,R.anim.mixed_anime);
    }

    public void right_to_left() {
        animation = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
    }

    public void rotation() {
        animation = AnimationUtils.loadAnimation(this,R.anim.rotation);
    }

    public void sample_anim() {
        animation = AnimationUtils.loadAnimation(this,R.anim.sample_anim);
    }

    public void zoom_in() {
        animation = AnimationUtils.loadAnimation(this,R.anim.zoomin);
    }

    public void zoom_out() {
        animation = AnimationUtils.loadAnimation(this,R.anim.zoomout);
    }
}
