package com.d121211010.NBA.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.d121211010.NBA.data.models.Nba
import com.d121211010.NBA.ui.theme.TugasFinalTheme

class DetailActivity : ComponentActivity() {

    private var selectedNba: Nba? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedNba = intent.getParcelableExtra("NBA")
        setContent {
            TugasFinalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen(selectedNba = selectedNba)
                }
            }
        }
    }

    @Composable
    fun DetailScreen(selectedNba: Nba?) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            // Details
            Spacer(modifier = Modifier.height(16.dp))
            selectedNba?.name?.let { Text(text = it, style = MaterialTheme.typography.displayMedium, fontWeight = FontWeight.Bold) }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = selectedNba?.id.toString(), style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Rating: ${selectedNba?.division}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))
            selectedNba?.city?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }
        }
    }
}