package sc.android.basiclocalplayerpractice.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import sc.android.basiclocalplayerpractice.model.MusicUIState
import sc.android.basiclocalplayerpractice.player.MusicPlayerController

class MusicViewModel(
    application: Application
): AndroidViewModel(application) {


    //creating instance of player controller
    private val playerController = MusicPlayerController(getApplication())
    private val _uiState = MutableStateFlow(MusicUIState())
    val uiState=_uiState.asStateFlow()

    init {
        //what to do when music is being played and vice versa
        playerController.onPlayingStateChanged={isPlaying->
            //copying isPlaying value from ExoPlayer into UIState
            _uiState.value=_uiState.value.copy(
                isPlaying=isPlaying
            )
        }

        //what to do when music metadata has changed
        playerController.onMetadataChanged={
            metaData->
            //copying metadata from ExoPlayer into UIState
            _uiState.value=_uiState.value.copy(
                songTitle = metaData.title?.toString()?:"",
                artistName = metaData.artist?.toString()?:"",
                albumName = metaData.albumTitle?.toString()?:""
            )
        }

        //what to do when music album art has changed
        playerController.onAlbumArtChanged={
            bitmap->
            //copying album art from player listener into UIState
            _uiState.value=_uiState.value.copy(
                albumArt=bitmap
            )
        }

        //loads the available song
        playerController.loadSong()

        //provides current position updates
        startPositionUpdates()
    }

    //updating the current from position of the music
    fun startPositionUpdates(){
        viewModelScope.launch {
            //as long as the coroutine is not canceled (canceled if viewmodel is delayed)
            while (isActive){
                //copies the current position and total duration into UIState
                _uiState.value = _uiState.value.copy(
                    currentPosition = playerController.getCurrentPosition(),
                    duration = playerController.getDuration()
                )
                //refreshes the current position of the song every 0.5s
                delay(500)
            }
        }
    }

    //accessed methods from player controller
    fun togglePlayPause(){
        playerController.togglePlayPause()
    }

    fun seekTo(
        position: Long
    ){
        playerController.seekTo(position)
    }


}