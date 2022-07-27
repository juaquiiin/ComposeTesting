package com.jocarur.composecredencial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocarur.composecredencial.ui.theme.ComposeCredencialTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /**
             * Here we define the theme of the activity
             */
            ComposeCredencialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateCredentials()
                }
            }
        }
    }
}

/**
 * I didn't knew but you can type comp and get a full composable function
 */
@Composable
fun comp() {
    
}

@Composable
private fun CreateCredentials() {
    /**
     * Here we're using the remember lambda to keep track of the state of our button
     */
    val showingInfo = remember {
        mutableStateOf(false)
    }

    Surface (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        Column(modifier = Modifier
            .padding(top = 16.dp)
            , verticalArrangement = Arrangement.Top
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetImagePicture(modifier = Modifier.size(150.dp))
            SetPersonalData()
            Button(onClick = { showingInfo.value = !showingInfo.value }
                , modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Portafolio")
            }

            /**
             * Looks like the code it's updating constantly like unity, i don't have to
             * create a specific method to update the code, may be the @Composable
             */
            if (showingInfo.value){
                Content()
            } else {
                Box {}
            }
        }
    }
}

@Composable
private fun SetImagePicture(modifier: Modifier = Modifier) {
    /**
     * Here we have a normal container, i don't think this one has a way to align the views inside
     */
    Surface(
        modifier = modifier
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 2.dp
    ) {
        /**
         * Here we have the classic image view
         */
        Image(
            modifier = modifier,
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile picture",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun SetPersonalData() {
    Column(modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(text = "Joaquin"
            , style = MaterialTheme.typography.bodyLarge
            , color = MaterialTheme.colorScheme.primary
        )
        Text(text = "Android Compose developer"
            , style = MaterialTheme.typography.bodyMedium
        )
        Text(text = "cardenasurbanojoaquin@outlook.com"
            , style = MaterialTheme.typography.bodyMedium
            , textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
private fun Content() {
    /**
     * A box is basically an Horizontal linear layout
     */
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(8.dp)
    ) {
        Surface(modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            , shape = RoundedCornerShape(corner = CornerSize(6.dp))
            , border = BorderStroke(1.dp , color = Color.LightGray)
        ) {
            Portafolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
private fun Portafolio(data: List<String>) {
    /**
     * Here we start a RecycleView Compose Style
     * The lazy mean that it'll reuse the columns and save processing power and Ram
     */
    LazyColumn {
        /**
         * The items mean that it catches the type of array that we need, in this case a String
         */
        items(data) { item ->
            /**
             * todo check this statement
             * As far as i can see a Row is a vertical linear layout
             */
            Row(modifier = Modifier.padding(8.dp)) {
                SetImagePicture(modifier = Modifier.size(60.dp))
                Column(modifier = Modifier
                    .padding(start = 16.dp)
                    .align(alignment = Alignment.CenterVertically)) {
                    Text(text = item)
                    Text(text = "frfr")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    /**
     * The default preview is a super method that shows what we're wonking in the live edit
     */
    ComposeCredencialTheme {
        CreateCredentials()
    }
}