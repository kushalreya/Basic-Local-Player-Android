package sc.android.basiclocalplayerpractice.data

import android.content.ContentUris
import android.content.Context
import android.provider.MediaStore
import androidx.compose.foundation.layout.Column
import sc.android.basiclocalplayerpractice.model.SongData

class MusicRepository(
    private val context: Context
) {
    //access all songs in local storage
    fun getAllSongs() : List<SongData>{
        //storing the list of songs
        val songs = mutableListOf<SongData>()

        //stores location of all audio files(URI)
        val audioCollection = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        //array of info we need from the metadata (projection is the attribute from the metadata
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM,
        ) //creates a table of all the columns we need

       //using query in contentResolver for getting the songs (return Cursor?)
        val cursor = context.contentResolver.query(
            audioCollection, //which table (address)
            projection,           //which columns/attributes needed
            null,      //no filtering(provided everything)
            null,  //no arguments for filter since no filtering
            null      //no sorting order
        ) //creates a cursor (like a pointer) that is positioned above the first row and knows about all the rows, and it gradually moves to the next rows for reading the values

            //reading the columns from result
        cursor?.use {
            cursor -> //use cursor if available else skip it

            //getting column indexed for the attributes taken
            //provides indexes to the columns for the cursor to read the values
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)

            val titleColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)

            val albumColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)

            val artistColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)

            while(cursor.moveToNext()){ //moves to the next row till there's a row to read

                //storing the value from reading the columns using column indexes
                val id=cursor.getLong(idColumn)
                val title=cursor.getString(titleColumn)
                val album=cursor.getString(albumColumn)
                val artist=cursor.getString(artistColumn)

                //creating uri for the song to provide ExoPlayer to play
                val uri = ContentUris.withAppendedId(
                    audioCollection, //location of songs
                    id //id of songs
                ) //combines both and creates uri of a song(uniform resource identifier)

                //creating song data
                songs.add(
                    SongData(
                        id=id,
                        title = title,
                        album=album,
                        artist=artist,
                        uri=uri
                    )
                )

            }
        }

        return songs
    }


}