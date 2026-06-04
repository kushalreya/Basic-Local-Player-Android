package sc.android.basiclocalplayerpractice.model

import sc.android.basiclocalplayerpractice.utils.RepeatModes
import kotlin.time.Duration

data class MusicUIState(
    val isPlaying: Boolean=false,
    val currentPosition: Long= 0L,
    val duration: Long=0L,
    val repeatModes: RepeatModes = RepeatModes.OFF,
    val shuffleMode: Boolean=false,
)
