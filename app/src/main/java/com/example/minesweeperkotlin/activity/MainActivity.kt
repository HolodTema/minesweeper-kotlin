package com.example.minesweeperkotlin.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.minesweeperkotlin.ui.theme.MinesweeperKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinesweeperKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(innerPadding)
                }
            }
        }
    }

    @Composable
    fun Main(paddingValues: PaddingValues) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val (buttonNewGame, buttonLoadGame) = createRefs()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green)
            )

            Button(
                onClick = {
                    startGameActivity()
                },
                modifier = Modifier
                    .constrainAs(buttonNewGame) {
                        bottom.linkTo(buttonLoadGame.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text("New game")
            }
            Button(
                onClick = {

                },
                modifier = Modifier
                    .constrainAs(buttonLoadGame) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text("Load game")
            }
        }
    }

    private fun startGameActivity() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}



