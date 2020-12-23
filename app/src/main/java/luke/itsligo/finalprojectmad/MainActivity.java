package luke.itsligo.finalprojectmad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
  private final int RED = 1;
  private final int YELLOW = 2;
  private final int GREEN = 3;
  private final int BLUE = 4;

  Button bRed, bBlue, bYellow, bGreen, fb;
  int sequenceCount = 4, n = 0, round, score, count;
  int[] gameSequence = new int[120];
  int arrayIndex = 0;

  // experimental values for hi and lo magnitude limits
  private final double NORTH_MOVE_FORWARD = 9;     // upper mag limit
  private final double NORTH_MOVE_BACKWARD = 6;      // lower mag limit

  private final double SOUTH_MOVE_FORWARD = 2;     // upper mag limit
  private final double SOUTH_MOVE_BACKWARD = 5;      // lower mag limit

  private final double EAST_MOVE_FORWARD = 0.3;     // upper mag limit
  private final double EAST_MOVE_BACKWARD = 0;      // lower mag limit

  private final double WEST_MOVE_FORWARD = -0.3;     // upper mag limit
  private final double WEST_MOVE_BACKWARD = 0;      // lower mag limit

  boolean highLimitNorth = false;      // detect high limit
  boolean highLimitSouth = false;      // detect high limit
  boolean highLimitEast = false;      // detect high limit
  boolean highLimitWest = false;      // detect high limit

  int counterNorth = 0;
  int counterSouth = 0;
  int counterEast = 0;
  int counterWest = 0;

  TextView tvRound, tvScore;
  private SensorManager mSensorManager;
  private Sensor mSensor;

  private final int NORTH = 1;
  private final int WEST = 2;
  private final int SOUTH = 3;
  private final int EAST = 4;

  CountDownTimer ct = new CountDownTimer(6000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct2 = new CountDownTimer(9000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct3 = new CountDownTimer(12000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct4 = new CountDownTimer(15000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct5 = new CountDownTimer(18000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct6 = new CountDownTimer(21000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct7 = new CountDownTimer(24000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct8 = new CountDownTimer(27000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };
  CountDownTimer ct9 = new CountDownTimer(30000,  1500) {

    public void onTick(long millis) {
      //mTextField.setText("seconds remaining: " + millisUntilFinished / 1500);
      oneButton();
      //here you can have your logic to set text to edittext
    }
    public void onFinish() {
      //mTextField.setText("done!");
      // we now have the game sequence

      for (int i = 0; i< arrayIndex; i++)
        Log.d("game sequence", String.valueOf(gameSequence[i]));
      // start next activity

      // put the sequence into the next activity
      // stack overglow https://stackoverflow.com/questions/3848148/sending-arrays-with-intent-putextra
      Intent i = new Intent(MainActivity.this, GameActivity.class);
      i.putExtra("sequence", gameSequence);
      i.putExtra("round", round);
      i.putExtra("score", score);
      i.putExtra("count", count);
      startActivity(i);

      // start the next activity
      // int[] arrayB = extras.getIntArray("numbers");
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bRed = findViewById(R.id.btnRed);
    bBlue = findViewById(R.id.btnBlue);
    bYellow = findViewById(R.id.btnYellow);
    bGreen = findViewById(R.id.btnGreen);

    score = getIntent().getIntExtra("score", 0);
    round = getIntent().getIntExtra("round", 1);
    count = getIntent().getIntExtra("count", 2);

    tvRound = findViewById(R.id.tvRound);
    tvScore = findViewById(R.id.tvScore);

    tvScore.setText(String.valueOf(score));
    tvRound.setText(String.valueOf(round));

    // we are going to use the sensor service
    mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
  }

  protected void onResume() {
    super.onResume();
    // turn on the sensor
    mSensorManager.registerListener(this, mSensor,
      SensorManager.SENSOR_DELAY_NORMAL);
  }
  protected void onPause() {
    super.onPause();
    mSensorManager.unregisterListener(this);    // turn off listener to save power
  }
  @Override
  public void onSensorChanged(SensorEvent event) {

    float x = event.values[0];
    float y = event.values[1];
    float z = event.values[2];

    // North Movement
    if ((x > NORTH_MOVE_FORWARD && z > 0) && (highLimitNorth == false)) {
      highLimitNorth = true;
    }
    if ((x < NORTH_MOVE_BACKWARD && z > 0) && (highLimitNorth == true)) {
      // we have a tilt to the NORTH
      counterNorth++;
      highLimitNorth = false;
      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          bRed.setPressed(true);
          bRed.invalidate();
          bRed.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              bRed.setPressed(false);
              bRed.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        } // end runnable
      };
      handler.postDelayed(r, 600);
    }

    // South Movement
    if ((x < SOUTH_MOVE_FORWARD && z < 0) && (highLimitSouth == false)) {
      highLimitSouth = true;
    }
    if ((x > SOUTH_MOVE_BACKWARD && z < 0) && (highLimitSouth == true)) {
      // we have a tilt to the SOUTH
      counterSouth++;
      highLimitSouth = false;
      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          bBlue.setPressed(true);
          bBlue.invalidate();
          bBlue.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              bBlue.setPressed(false);
              bBlue.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        } // end runnable
      };
      handler.postDelayed(r, 600);
    }

    // East Movement
    if (y > EAST_MOVE_FORWARD && highLimitEast == false) {
      highLimitEast = true;
    }
    if (y < EAST_MOVE_BACKWARD && highLimitEast == true) {
      // we have a tilt to the EAST
      counterEast++;
      highLimitEast = false;
      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          bGreen.setPressed(true);
          bGreen.invalidate();
          bGreen.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              bGreen.setPressed(false);
              bGreen.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        } // end runnable
      };
      handler.postDelayed(r, 600);
    }

    // West Movement
    if (y < WEST_MOVE_FORWARD && highLimitWest == false) {
      highLimitWest = true;
    }
    if (y > WEST_MOVE_BACKWARD && highLimitWest == true) {
      // we have a tilt to the WEST
      counterWest++;
      highLimitWest = false;
      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          bYellow.setPressed(true);
          bYellow.invalidate();
          bYellow.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              bYellow.setPressed(false);
              bYellow.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        } // end runnable
      };
      handler.postDelayed(r, 600);
    }

  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {
    // not used
  }

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }



  public void doPlay(View view) {
    switch (round)
    {
      case(1):
        ct.start();
        break;
      case(2):
        ct2.start();
        break;
      case(3):
        ct3.start();
        break;
      case(4):
        ct4.start();
        break;
      case(5):
        ct5.start();
        break;
      case(6):
        ct6.start();
        break;
      case(7):
        ct7.start();
        break;
      case(8):
        ct8.start();
        break;
      case(9):
        ct9.start();
        break;
    }
  }

  public void doDB(View view){
    Intent i = new Intent(view.getContext(), HiScores.class);

    startActivity(i);
  }

  private void oneButton() {
    n = getRandom(sequenceCount);


    switch (n) {
      case 1:
        flashButton(bRed);
        gameSequence[arrayIndex++] = RED;
        break;
      case 2:
        flashButton(bYellow);
        gameSequence[arrayIndex++] = YELLOW;
        break;
      case 3:
        flashButton(bGreen);
        gameSequence[arrayIndex++] = GREEN;
        break;
      case 4:
        flashButton(bBlue);
        gameSequence[arrayIndex++] = BLUE;
        break;
      default:
        break;
    }   // end switch
  }

  //
  // return a number between 1 and maxValue
  private int getRandom(int maxValue) {
    return ((int) ((Math.random() * maxValue) + 1));
  }

  private void flashButton(Button button) {
    fb = button;
    Handler handler = new Handler();
    Runnable r = new Runnable() {
      public void run() {

        fb.setPressed(true);
        fb.invalidate();
        fb.performClick();
        Handler handler1 = new Handler();
        Runnable r1 = new Runnable() {
          public void run() {
            fb.setPressed(false);
            fb.invalidate();
          }
        };
        handler1.postDelayed(r1, 600);

      } // end runnable
    };
    handler.postDelayed(r, 600);
  }

  public void doTest(View view) {
    for (int i = 0; i < sequenceCount; i++) {
      int x = getRandom(sequenceCount);

      Toast.makeText(this, "Number = " + x, Toast.LENGTH_SHORT).show();

      if (x == 1)
        flashButton(bRed);
      else if (x == 2)
        flashButton(bYellow);
      else if (x == 3)
        flashButton(bGreen);
      else if (x == 4)
        flashButton(bBlue);
    }

  }
}
