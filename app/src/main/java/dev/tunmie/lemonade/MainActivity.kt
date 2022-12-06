package dev.tunmie.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.tunmie.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LemonadeTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					LemonApp()
				}
			}
		}
	}
}

@Composable
fun LemonApp() {
	Surface {
		LemonTextAndImage()
	}
}

@Preview(showBackground = true)
@Composable
fun LemonTextAndImage(
	modifier: Modifier = Modifier
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = modifier.fillMaxSize()
	) {
		Text(text = stringResource(id = R.string.step1), fontSize = 18.sp)
		Spacer(modifier = Modifier.height(16.dp))
		Image(
			painter = painterResource(id = R.drawable.lemon_tree), contentDescription = stringResource(
				id = R.string.title1
			)
		)
	}
}
