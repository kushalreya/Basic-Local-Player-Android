@file:OptIn(ExperimentalMaterial3Api::class)

package sc.android.basiclocalplayerpractice.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title: String,
    onBackClick: () -> Unit={},
    onFavouriteClick: () -> Unit = {}
){

    val navigationIcon = @Composable{
        if(!title.contains("Local Music Player")){
            IconButton(
                onClick = {onBackClick()}
            ) {
                Icon(
                    imageVector=Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back"
                )
            }
        }
    }

    val actionIcon = @Composable{
        if(title.contains("Local Music Player")){
            IconButton(
                onClick = {onFavouriteClick()},
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    shape = CircleShape
                )
            ) {
                Icon(
                    imageVector=Icons.Default.Favorite,
                    contentDescription = "Favourite"
                )
            }
        }
    }

    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium
            )
        },
        navigationIcon=navigationIcon,
        actions = {actionIcon()},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}