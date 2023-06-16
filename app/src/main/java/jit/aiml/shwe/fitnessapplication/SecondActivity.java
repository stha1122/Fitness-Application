package jit.aiml.shwe.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        newArray=new int[]{
              R.id.pose1,R.id.pose2,R.id.pose3,R.id.pose4,R.id.pose5,R.id.pose6,R.id.pose7,R.id.pose8,R.id.pose9,R.id.pose10,R.id.pose11,R.id.pose12,R.id.pose13,R.id.pose14,R.id.pose15,


        };
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.privacy){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freeprivacypolicy.com/live/9a238a29-f7e5-4bfb-b88a-d0f04ec4fe28"));
            startActivity(intent);
            return true;
        }
        if(id == R.id.term){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.termsfeed.com/public/uploads/2021/12/sample-terms-conditions-agreement-screenshot-2.jpg"));
            startActivity(intent);
            return true;
        }
        if(id == R.id.rate){
            try {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName()));
                startActivity(intent);
            }
            catch (Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+ getPackageName())));
            }

            return true;
        }
        if(id == R.id.share){
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String sharebody="This is best app for exercise\n It is a free app download now. \n"+"https://play.google.com/store/apps/details?id=jit.aiml.shwe.fitnessapplication&hl=en";
            String shareHub="Fit15";
            intent.putExtra(Intent.EXTRA_SUBJECT,shareHub);
            intent.putExtra(Intent.EXTRA_SUBJECT,sharebody);
            startActivity(Intent.createChooser(intent,"share using"));
            return true;
        }
        if(id == R.id.more){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=fitness+apps&c=apps"));
            startActivity(intent);
            return true;
        }
        return true;
    }


    public void Imagebuttonclicked(View view) {
        for(int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}