package sc.android.basiclocalplayerpractice.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import sc.android.basiclocalplayerpractice.model.MusicUIState
import sc.android.basiclocalplayerpractice.player.MusicPlayerController
import sc.android.basiclocalplayerpractice.view.components.MusicInfoSection
import sc.android.basiclocalplayerpractice.view.components.PlaybackControlsSection
import sc.android.basiclocalplayerpractice.view.components.SeekbarSection
import sc.android.basiclocalplayerpractice.viewmodel.MusicViewModel

@Composable
fun MusicPlayerScreen(
    modifier: Modifier,
    viewModel: MusicViewModel
){

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MusicInfoSection(
            uiState = uiState
        )

        SeekbarSection(
            uiState=uiState,
            onSeek = {
                position ->
                viewModel.seekTo(position)
            }
        )

        PlaybackControlsSection(
            uiState = uiState,
            onPlayPauseClick={viewModel.togglePlayPause()}
        )
    }
}