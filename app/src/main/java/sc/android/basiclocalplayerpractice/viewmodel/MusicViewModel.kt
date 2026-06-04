package sc.android.basiclocalplayerpractice.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
        playerController.onPlayingStateChanged={isPlaying->
            //copying isPlaying value from ExoPlayer into UIState
            _uiState.value=_uiState.value.copy(
                isPlaying=isPlaying
            )
        }
        //loads the available song
        playerController.loadSong()
    }

    //accessed methods from player controller

    fun loadSong(){
        playerController.loadSong()
    }

    fun togglePlayPause(){
        playerController.togglePlayPause()
    }
}