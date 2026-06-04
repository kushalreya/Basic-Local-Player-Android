package sc.android.basiclocalplayerpractice.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sc.android.basiclocalplayerpractice.model.MusicUIState
import sc.android.basiclocalplayerpractice.player.MusicPlayerController
import sc.android.basiclocalplayerpractice.view.components.PlaybackControlsSection

@Composable
fun MusicPlayerScreen(
    modifier: Modifier,
    playerController: MusicPlayerController
){

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PlaybackControlsSection(
            uiState = MusicUIState(),
            playerController=playerController
        )
    }
}