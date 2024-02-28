package com.example.botcontrol

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.botcontrol.ui.theme.BotControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
*/
        setContent {
            BotControlTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyContent()
                }
            }
        }
    }
}

@Composable
fun MyContent() {
    ControlPanel()
}

@Composable
fun ControlPanel() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DiagonalButton(-90f, R.drawable.baseline_arrow_outward_24) {
                // Add code for the forward left action of the robot
            }
            ControlButton(0f, R.drawable.baseline_arrow_upward_24) {
                // Add code for the forward action of the robot
            }
            DiagonalButton(0f, R.drawable.baseline_arrow_outward_24) {
                // Add code for the forward right action of the robot
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ControlButton(-90f, R.drawable.baseline_arrow_upward_24) {
                // Add code for the left action of the robot
            }
            ControlButton(90f, R.drawable.baseline_arrow_upward_24) {
                // Add code for the right action of the robot
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DiagonalButton(180f, R.drawable.baseline_arrow_outward_24) {
                // Add code for the backward left action of the robot
            }
            ControlButton(180f, R.drawable.baseline_arrow_upward_24) {
                // Add code for the backward action of the robot
            }
            DiagonalButton(90f, R.drawable.baseline_arrow_outward_24) {
                // Add code for the backward right action of the robot
            }
        }
    }
}


@Composable
fun ControlButton(degrees: Float, @DrawableRes icon: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp),
        shape = RectangleShape
    ) {
        Icon(painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.rotate(degrees)
            .scale(2.5f)
            )

    }
}

@Composable
fun DiagonalButton(degrees: Float, @DrawableRes icon: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp),

    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.rotate(degrees)
                .scale(2.0f),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ControlPanelPreview() {
    BotControlTheme {
        ControlPanel()
    }
}