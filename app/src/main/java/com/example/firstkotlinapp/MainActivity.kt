package com.example.firstkotlinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.firstkotlinapp.ui.theme.FirstKotlinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstKotlinAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                MyApp()

                }
            }
        }
    }
}

@Composable
fun MyApp() {

    // create an array pf jokes
    val jokes = arrayListOf<JokeModel>(
        JokeModel(
            id = 1,
            question = "What time is it when an elephant sits on your fence",
            answer = "Time to get a new fence",
            answerIsVisible = true
        ),

        JokeModel(
            id = 1,
            question = "What is red and smells like blue paint?",
            answer = "Red paint",
            answerIsVisible = true
        ),

        JokeModel(
            id = 3,
            question = "What is the difference between a snowman and snowwoman?",
            answer = "Snowballs",
            answerIsVisible = true
        ),

        JokeModel(
            id = 4,
            question = "What do you call a cow with no legs?",
            answer = "Ground beef",
            answerIsVisible = true
        ),

        JokeModel(
            id = 5,
            question = "What did the mother bufallo say to her child when she left him at kindegarten?",
            answer = "Bison",
            answerIsVisible = true
        )
    )

    LazyColumn() {
        items(jokes.size) {index ->
            Joke1(jokeModel = jokes[index])
        }

    } // end of column

}


@Composable
fun Joke1(jokeModel: JokeModel) {

    Column {

        Text(text = jokeModel.id.toString())
        Text(
            text = jokeModel.question,
            modifier = Modifier.padding(16.dp),
            color = Color.Blue,
            fontSize = 8.em,
            fontWeight = FontWeight.Bold,
            lineHeight = 1.em,
            textAlign = TextAlign.Center
        )

        if(jokeModel.answerIsVisible) {
            Text(text = jokeModel.answer)
        }

    } // end of a column
}

data class JokeModel(val id: Int,
                     val question: String,
                     val answer: String,
                     val answerIsVisible: Boolean) {

}
