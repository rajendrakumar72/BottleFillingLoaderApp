package com.mrkumar.bottlefillingloaderapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrkumar.bottlefillingloaderapp.ui.theme.BottleFillingLoaderAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottleFillingLoaderAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {

                    var usedAmount by remember {
                        mutableStateOf(400)
                    }
                     val totalAmountOfWater by remember {
                         mutableStateOf(2400)
                     }
                    Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {

                        WaterBottleCompose(totalWaterAmount = totalAmountOfWater,
                            unit = "Filling", usedWaterAmount = usedAmount, modifier = Modifier.width(300.dp))

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(text = "Bottle Capacity $totalAmountOfWater l")

                         Spacer(modifier = Modifier.height(20.dp))

                        Text(text = "Filled amount $usedAmount l")

                                  Spacer(modifier = Modifier.height(20.dp))
                        Button(onClick = {
                            if (usedAmount!=totalAmountOfWater){
                                 usedAmount+=200
                            } else  {
                                Toast.makeText(this@MainActivity, "Water bottle is Filled",Toast.LENGTH_SHORT).show()

                            }

                        }, colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xff279eff))) {
                            Text(text = "Drink")

                        }
                    }
                }
            }
        }
    }
}

