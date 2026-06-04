package sc.android.basiclocalplayerpractice.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.RepeatOne
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sc.android.basiclocalplayerpractice.model.MusicUIState
import sc.android.basiclocalplayerpractice.player.MusicPlayerController
import sc.android.basiclocalplayerpractice.utils.RepeatModes

@Composable
fun PlaybackControlsSection(
    uiState: MusicUIState,
    onPlayPauseClick: () -> Unit
){

    //extracting play-pause button
    val playPauseIcon =
        if(uiState.isPlaying) Icons.Default.Pause
        else Icons.Default.PlayArrow

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //repeat
            IconButton(
                onClick = {
                    //todo repeat
                }
            ) {
                Icon(
                    imageVector =
                        when (uiState.repeatModes) {
                            RepeatModes.OFF -> Icons.Default.Repeat
                            RepeatModes.ONE -> Icons.Default.RepeatOne
                            RepeatModes.ALL -> Icons.Default.Repeat
                        },
                    "repeat mode",
                    tint =
                        when (uiState.repeatModes) {
                            RepeatModes.OFF -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                            RepeatModes.ONE -> MaterialTheme.colorScheme.onSurface
                            RepeatModes.ALL -> MaterialTheme.colorScheme.primary
                        },
                    modifier = Modifier.size(35.dp)
                )
            }

            //previous track button
            IconButton(
                onClick = {}
            ){
                Icon(
                    Icons.Default.SkipPrevious,
                    "previous",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(50.dp)
                )
            }

            //play pause
            IconButton(
                onClick = {
                    onPlayPauseClick()
                }
            ){
                Icon(
                    imageVector = playPauseIcon,
                    contentDescription = "play pause",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(50.dp)
                )
            }

            //next track
            IconButton(
                onClick = {
                    //todo
                }
            ){
                Icon(
                    Icons.Default.SkipNext,
                    "next",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(50.dp)
                )
            }

            //shuffle mode
            IconButton(
                onClick = {
                    //todo
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Shuffle,
                    contentDescription = "shuffle mode",
                    tint =
                        if (!uiState.shuffleMode) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                        else MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(35.dp)
                )
            }
        }

    }
}