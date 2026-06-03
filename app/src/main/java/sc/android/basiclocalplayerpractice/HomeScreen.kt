@file:OptIn(ExperimentalMaterial3Api::class)

package sc.android.basiclocalplayerpractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier
){

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        sheetContent = {
            //todo music player
            Column(
                modifier = Modifier.fillMaxSize(0.86f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Music Player Screen",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.rotate(-45f),
                    textAlign = TextAlign.Center
                )
            }
        },
        scaffoldState=scaffoldState,
        sheetPeekHeight = 120.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContainerColor = MaterialTheme.colorScheme.primaryContainer,
        sheetContentColor = MaterialTheme.colorScheme.onSurface,
        sheetShadowElevation = 12.dp,
        sheetSwipeEnabled = true,
        topBar = {
            TopBar(
                "Local Music Player",
                {
                    //todo
                },
                {
                    //todo
                }
            )
        },
        contentColor = MaterialTheme.colorScheme.onSurface,
//        content = {
//
//        }
    ) {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Home Screen",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.rotate(-45f),
                textAlign = TextAlign.Center
            )
        }
    }
}