package com.bverog.comparacionstateflowmutablestateof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bverog.comparacionstateflowmutablestateof.ui.viewmodel.MessageViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MessageScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MessageScreen(viewModel: MessageViewModel = viewModel()) {
    val mutableStateOfMessage by viewModel.mutableStateOfMessage
    val stateFlowMessage by viewModel.stateFlowMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp, 56.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            "Ejemplo de Comparación entre mutableStateOf y StateFlow",
            color = Color(0xFF3F51B5), fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            style =  MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height((46.dp)))
        Text("Ejemplo de mutableStateOf",
            style = MaterialTheme.typography.titleLarge)

        TextField(
            value = mutableStateOfMessage,
            onValueChange = { viewModel.updateMutableStateOfMessage(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Escribe algo...") },
        )
        Spacer(modifier = Modifier.height((16.dp)))
        Text("Mensaje Actual MutableStateOf: $mutableStateOfMessage",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF3F51B5)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text("Ejemplo de StateFlow", style = MaterialTheme.typography.titleLarge)
        TextField(
            value = stateFlowMessage,
            onValueChange = { viewModel.updateStateFlowMessage(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Escribe algo...") },
        )
        Spacer(modifier = Modifier.height((16.dp)))
        Text("Mensaje Actual State Flow: $stateFlowMessage",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF3F51B5))
    }
}

