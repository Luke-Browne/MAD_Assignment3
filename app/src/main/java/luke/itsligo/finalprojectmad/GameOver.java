package luke.itsligo.finalprojectmad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GameOver extends Activity {

  int score, round;
  TextView tvScore, tvRound;
  public EditText name;
  public DatabaseHandler dataSource;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game_over);

    tvScore = findViewById(R.id.tvScore);
    tvRound = findViewById(R.id.tvRound);

    score = getIntent().getIntExtra("score", 0);
    round = getIntent().getIntExtra("round", 1);

    tvScore.setText(String.valueOf(score));
    tvRound.setText(String.valueOf(round));

    name = findViewById(R.id.etName);

    dataSource = new DatabaseHandler(this);

    dataSource.emptyHiScores();     // empty table if required
    InsertingData();

    // Reading all scores
    Log.i("Reading: ", "Reading all scores..");
    List<HiScore> hiScores = dataSource.getAllHiScores();


    for (HiScore hs : hiScores) {
      String log =
        "Id: " + hs.getScore_id() +
          ", Date: " + hs.getGame_date() +
          " , Player: " + hs.getPlayer_name() +
          " , Score: " + hs.getScore();

      // Writing HiScore to log
      Log.i("Score: ", log);
    }

    Log.i("divider", "====================");

    HiScore singleScore = dataSource.getHiScore(5);
    Log.i("High Score 5 is by ", singleScore.getPlayer_name() + " with a score of " + singleScore.getScore());

    Log.i("divider", "====================");

    // Calling SQL statement
    List<HiScore> top5HiScores = dataSource.getTopFiveScores();
    for (HiScore hs : top5HiScores) {
      String log =
        "Id: " + hs.getScore_id() +
          ", Date: " + hs.getGame_date() +
          " , Player: " + hs.getPlayer_name() +
          " , Score: " + hs.getScore();
      // Writing HiScore to log
      Log.i("Score: ", log);
    }

    HiScore lastScore = top5HiScores.get(top5HiScores.size() - 1);
    if (score > lastScore.score) {
      Toast.makeText(this,"Enter your name...", Toast.LENGTH_LONG).show();
    }
  }

  public void doHighScores(View view) {
    Intent hiScoresActivity = new Intent(view.getContext(), HiScores.class);

    startActivity(hiScoresActivity);
    finish();
  }

  public void doPlayAgain(View view) {
    Intent mainActivity = new Intent(view.getContext(), MainActivity.class);

    startActivity(mainActivity);

    finish();
  }

  public void doSubmit(View view) {
    List<HiScore> top5HiScores = dataSource.getTopFiveScores();
    HiScore lastScore = top5HiScores.get(top5HiScores.size() - 1);

    if(score > lastScore.score && name.getText().toString() != ""){

      String userName = name.getText().toString();

      String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

      dataSource.addHiScore(new HiScore(date, userName, score));

      top5HiScores = dataSource.getTopFiveScores();

      for (HiScore hs : top5HiScores) {
        String log =
          "Id: " + hs.getScore_id() +
            " , Player: " + hs.getPlayer_name() +
            " , Score: " + hs.getScore();

        // Writing HiScore to log
        Log.i("Score: ", log);
      }
    }
    else{
      Toast.makeText(this,"Score not high enough",Toast.LENGTH_SHORT).show();
    }

    doHighScores(view);
  }

  public void InsertingData(){
    // Inserting hi scores
    Log.i("Insert: ", "Inserting Scores...");
    dataSource.addHiScore(new HiScore("02/06/2019", "Dominic", 10));
    dataSource.addHiScore(new HiScore("19/09/2019", "Mark", 9));
    dataSource.addHiScore(new HiScore("20/02/2018", "Thomas", 4));
    dataSource.addHiScore(new HiScore("12/03/2020", "Ella", 5));
    dataSource.addHiScore(new HiScore("14/11/2020", "Elise", 2));
    dataSource.addHiScore(new HiScore("03/08/2020", "Mike", 3));
    dataSource.addHiScore(new HiScore("28/05/2020", "Megan", 6));
    dataSource.addHiScore(new HiScore("18/02/2020", "Seamus", 8));
  }

  public void doReplay(View view)
  {
    Intent replayGame = new Intent(view.getContext(), MainActivity.class);

    startActivity(replayGame);
    finish();
  }
}
