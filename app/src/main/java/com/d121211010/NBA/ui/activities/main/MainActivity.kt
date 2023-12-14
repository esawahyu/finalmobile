package com.d121211010.NBA.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211010.NBA.data.models.Nba
import com.d121211010.NBA.ui.activities.detail.DetailActivity
import com.d121211010.NBA.ui.theme.TugasFinalTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CenterAlignedTopAppBar(
                            modifier = Modifier.background(Color.Blue),  // Change background color here
                            title = {
                                Text(
                                    text = "Popular",
                                    fontWeight = FontWeight.SemiBold,
                                )
                            }
                        )
                        val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                        ListNbaScreen(mainViewModel.mainUiState)
                    }

                }
            }
        }
    }

    @Composable
    private fun ListNbaScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Loading -> CenterText(text = "Loading...")
            is MainUiState.Error -> CenterText(text = "Something Error")
            is MainUiState.Success -> NbaList(mainUiState.NbaRepository)
        }
    }

    @Composable
    fun CenterText(text: String) {
        // Wrap the content with a Box to apply the centering modifiers
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Optional padding
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
            )
        }
    }

    @Composable
    fun NbaList(nbaList: List<Nba>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(nbaList.size) { nba ->
                NbaItem(nba=nbaList[nba])
            }
        }
    }

    @Composable
    fun NbaItem(nba: Nba) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp),)
                .clickable {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("NBA", nba)
                    startActivity(intent)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                //  Details
                Spacer(modifier = Modifier.height(8.dp))
                nba.name?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                nba.division?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = nba.id.toString(),
                    style = MaterialTheme.typography.bodyMedium)

                // Other details like rating, genre, etc. can be added here
            }
        }
    }
}

