package thehappyapp.ytkoff.com.thehappyapp.Activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import thehappyapp.ytkoff.com.thehappyapp.R;

public class MainActivity extends AppCompatActivity {
    TextView heading;
    TextView Q;
    TextView question;
    List<QA> qaList = new QA().getQAList();
    int currentQuestion = 0;
    Button answerButton;
    ImageView next;
    ImageView previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heading = (TextView) findViewById(R.id.heading);
        Q = (TextView) findViewById(R.id.Q);
        question = (TextView) findViewById(R.id.question);
        answerButton = (Button) findViewById(R.id.answer);
        next = (ImageView) findViewById(R.id.next);
        previous = (ImageView) findViewById(R.id.previous);
        heading.setText("The Happy App");
        Q.setText("Q.");
        setFonts();
        if (qaList != null) {
            setQuestionAnswer();

        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestion++;
                setQuestionAnswer();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestion--;
                setQuestionAnswer();

            }
        });

    }

    private void setQuestionAnswer() {
        if (currentQuestion <= 0) {
            previous.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
            currentQuestion = 0;
        } else if (currentQuestion >= qaList.size()) {
            next.setVisibility(View.INVISIBLE);
            previous.setVisibility(View.VISIBLE);
            currentQuestion = qaList.size()-1;
        } else {
            next.setVisibility(View.VISIBLE);
            previous.setVisibility(View.VISIBLE);
        }

        question.setText(currentQuestion + 1 + " . " + qaList.get(currentQuestion).question);
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerButton.getText().equals("Show Answer")) {
                    question.setText(qaList.get(currentQuestion).answer);
                    answerButton.setText("Show Question");
                } else {
                    question.setText(currentQuestion + 1 + " . " + qaList.get(currentQuestion).question);
                    answerButton.setText("Show Answer");
                }
            }
        });
    }

    private void setFonts() {
        Typeface headingFont = Typeface.createFromAsset(getAssets(), "notera.ttf");
        Typeface Qfont = Typeface.createFromAsset(getAssets(), "Charle.ttf");
        Typeface questionFont = Typeface.createFromAsset(getAssets(), "trench.ttf");
        heading.setTypeface(headingFont);
        Q.setTypeface(Qfont);
        question.setTypeface(questionFont);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class QA {
        String question;
        String answer;


        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }


        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public List<QA> getQAList() {
            List<QA> qas = new ArrayList<>();
            QA qa = new QA();
            qa.question = "Why is there no gambling in Africa?";
            qa.answer = "Too many Cheetahs!";
            qas.add(qa);
            QA qa2 = new QA();
            qa2.question = "Why did the rapper carry an umbrella?";
            qa2.answer = "Fo' drizzle.";
            qas.add(qa2);
            QA qa3 = new QA();
            qa3.question = "Why did the pirate go to the Caribbean?";
            qa3.answer = "He wanted some arr and arr.";
            qas.add(qa3);
            QA qa4 = new QA();
            qa4.question = "There’s two fish in a tank. One turns to the other and says";
            qa4.answer = "-You man the guns, I’ll drive’";
            qas.add(qa4);
            QA qa5 = new QA();
            qa5.question = "What washes up on tiny beaches?";
            qa5.answer = "MICROWAVES!!";
            qas.add(qa5);
            QA qa6 = new QA();
            qa6.question = "What did one shark say to the other while eating a clownfish?";
            qa6.answer = "This tastes funny.";
            qas.add(qa6);
            QA qa7 = new QA();
            qa7.question = "What's brown and sticky?";
            qa7.answer = "A stick.";
            qas.add(qa7);
            QA qa8 = new QA();
            qa8.question = "Where do animals go when their tails fall off?";
            qa8.answer = "A retail store";
            qas.add(qa8);
            QA qa9 = new QA();
            qa9.question = "What did one hat say to another?";
            qa9.answer = "You stay here, I'll go on a head!";
            qas.add(qa9);
            QA qa10 = new QA();
            qa10.question = "What did the fish say when he ran into the wall?";
            qa10.answer = "Dam";
            qas.add(qa10);
            return qas;
        }
    }
}
