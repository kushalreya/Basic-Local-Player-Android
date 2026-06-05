package sc.android.basiclocalplayerpractice.model

import sc.android.basiclocalplayerpractice.utils.RepeatModes
import kotlin.time.Duration

data class MusicUIState(
    //music info
    val isPlaying: Boolean=false,
    val currentPosition: Long= 0L,
    val duration: Long=0L,

    //music metadata
    val songTitle: String="",
    val artistName: String="",
    val albumName: String="",

    //playback modes
    val repeatModes: RepeatModes = RepeatModes.OFF,
    val shuffleMode: Boolean=false,
)
