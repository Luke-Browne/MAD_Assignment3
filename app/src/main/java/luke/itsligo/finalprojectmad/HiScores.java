package luke.itsligo.finalprojectmad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HiScores extends Activity {

  ListView listView;
  private DatabaseHandler data;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hi_scores);

    listView = findViewById(R.id.lv);

    data = new DatabaseHandler(this);

    //DatabaseHandler db = new DatabaseHandler(this);

   // db.emptyHiScores();     // empty table if required

    // Inserting hi scores
    Log.i("Insert: ", "Inserting ..");
    //db.addHiScore(new HiScore("20 OCT 2020", "Frodo", 5));
   // db.addHiScore(new HiScore("28 OCT 2020", "Dobby", 2));
   // db.addHiScore(new HiScore("20 NOV 2020", "DarthV", 6));
    //db.addHiScore(new HiScore("20 NOV 2020", "Bob", 7));
   // db.addHiScore(new HiScore("22 NOV 2020", "Gemma", 8));
   // db.addHiScore(new HiScore("30 NOV 2020", "Joe", 5));
    //db.addHiScore(new HiScore("01 DEC 2020", "DarthV", 3));
   // db.addHiScore(new HiScore("02 DEC 2020", "Gandalf", 4));


    // Reading all scores
    Log.i("Reading: ", "Reading all scores..");
    List<HiScore> hiScores = data.getTopFiveScores();


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

    Log.i("divider", "====================");

    // Calling SQL statement
    List<HiScore> top5HiScores = data.getTopFiveScores();
    for (HiScore hs : top5HiScores) {
      String log =
        "Id: " + hs.getScore_id() +
          ", Date: " + hs.getGame_date() +
          " , Player: " + hs.getPlayer_name() +
          " , Score: " + hs.getScore();

      // Writing HiScore to log
      Log.i("Score: ", log);
    }
    Log.i("divider", "====================");

    HiScore hiScore = top5HiScores.get(top5HiScores.size() - 1);
    // hiScore contains the 5th highest score
    Log.i("fifth Highest score: ", String.valueOf(hiScore.getScore()) );

    // simple test to add a hi score
    int myCurrentScore = 40;
    // if 5th highest score < myCurrentScore, then insert new score
    if (hiScore.getScore() < myCurrentScore) {
      data.addHiScore(new HiScore("08 DEC 2020", "Elrond", 24));
    }

    Log.i("divider", "====================");

    // Calling SQL statement
    top5HiScores = data.getTopFiveScores();
    List<String> scoresStr;
    scoresStr = new ArrayList<>();

    int x = 1;

    for (HiScore hs : top5HiScores) {
      String log =
        "Id: " + hs.getScore_id() +
          ", Date: " + hs.getGame_date() +
          " , Player: " + hs.getPlayer_name() +
          " , Score: " + hs.getScore();

      // store score in string array
      scoresStr.add(x++ + "  :  " +
        hs.getPlayer_name() + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" +
        hs.getScore());

      // Writing HiScore to log
      Log.i("Score: ", log);
      Log.i("divider", "Scores in list <>");
      for (String ss : scoresStr){
        Log.i("Score", ss);
      }
      ArrayAdapter<String> itemsAdapter =
        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, scoresStr);
      listView.setAdapter(itemsAdapter);
    }
  }
  public void doReplay(View view)
  {
    Intent replayGame = new Intent(view.getContext(), MainActivity.class);

    startActivity(replayGame);
    finish();
  }
}