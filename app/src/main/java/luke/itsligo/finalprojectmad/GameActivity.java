package luke.itsligo.finalprojectmad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends Activity {

  int[] gameSequence = new int[120];

  int num = 0, usequence = -1, score = 0, count, round = 1;

  TextView tvScore, tvRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameSequence = getIntent().getIntArrayExtra("sequence");
        round = getIntent().getIntExtra("round", 1);
        score = getIntent().getIntExtra("score", 0);
        count = getIntent().getIntExtra("count", 4);

        tvScore = findViewById(R.id.tvScore);
        tvRound = findViewById(R.id.tvRound);

        tvRound.setText(String.valueOf(round));
        tvScore.setText(String.valueOf(score));
    }

    public void doClick(View view){

      usequence++;

      switch (view.getId())
      {
        case(R.id.btnRed2) :
          num = 1;
          break;
        case(R.id.btnYellow2) :
          num = 2;
          break;
        case(R.id.btnGreen2) :
          num = 3;
          break;
        case(R.id.btnBlue2) :
          num = 4;
          break;
      }

      for( int i : gameSequence)
      {
          if(num == gameSequence[usequence])
          {
            score++;
            tvScore.setText(String.valueOf(score));

            if(usequence > count)
            {
              count = count + 2;
              round++;

              Intent returnToMain = new Intent(GameActivity.this, MainActivity.class);
              returnToMain.putExtra("score", score);
              returnToMain.putExtra("round", round);
              returnToMain.putExtra("count", count);
              startActivity(returnToMain);
            }
            return;
          }
          else if(num != gameSequence[usequence])
          {
            Intent intent = new Intent(GameActivity.this, GameOver.class);
            intent.putExtra("score", score);
            intent.putExtra("round", round);
            startActivity(intent);
            return;
          }
      }
    }
}
