package com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.model.RegionModel
import com.stwcoding.datamodule.hkgov.greenminibusrealtimearrivaldata.ui.theme.GreenMinibusRealTimeArrivalTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = MutableStateFlow("")
            val scope = rememberCoroutineScope()

            GreenMinibusRealTimeArrivalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val test = GreenMinibusRealTimeArrivalClient()
                    val response by state.collectAsState()
                    var uncensoredText by remember {
                        mutableStateOf("")
                    }

                    Column {
                        Greeting(
                            name = response,
                            modifier = Modifier.padding(innerPadding)
                        )
                        TextField(
                            value = uncensoredText,
                            onValueChange = { uncensoredText = it },
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxWidth(),
                            placeholder = {
                                Text("Uncensored text")
                            }
                        )
                        Button(
                            onClick = {
                                scope.launch {
                                    state.emit(
                                        test.routeListing(RegionModel.NewTerritories).getOrNull()?.type.orEmpty()
                                    )
                                }
                            }
                        ) {
                            Text(text = "Call")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreenMinibusRealTimeArrivalTheme {
        Greeting("Android")
    }
}