package sc.android.basiclocalplayerpractice.model

import android.net.Uri

data class SongData(
    val id: Long,
    val title: String,
    val album: String,
    val artist: String,
    val uri: Uri
)
