package dev.tunmie.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
	var currentStep by remember { mutableStateOf(1) }

	var squeezeCount by remember { mutableStateOf(0) }
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		when (currentStep) {
			1 -> {
				LemonTextAndImage(
					textLabelResourceId = R.string.step1,
					drawableResourceId = R.drawable.lemon_tree,
					contentDescriptionResourceId = R.string.title1,
					onImageClick = {
						currentStep = 2
						squeezeCount = (2..4).random()
					}
				)
			}
			2 -> {
				LemonTextAndImage(
					textLabelResourceId = R.string.step2,
					drawableResourceId = R.drawable.lemon_drink,
					contentDescriptionResourceId = R.string.title2,
					onImageClick = {
						squeezeCount --
						if (squeezeCount == 0) {
							currentStep = 3
						}
					}
				)
			}
			3 -> {
				LemonTextAndImage(
					textLabelResourceId = R.string.step3,
					drawableResourceId = R.drawable.lemon_squeeze,
					contentDescriptionResourceId = R.string.title3,
					onImageClick = {
						currentStep = 4
					}
				)
			}
			4 -> {
				LemonTextAndImage(
					textLabelResourceId = R.string.step2,
					drawableResourceId = R.drawable.lemon_drink,
					contentDescriptionResourceId = R.string.title2,
					onImageClick = {
						currentStep = 1
					}
				)
			}
		}
	}
}


@Composable
fun LemonTextAndImage(
	textLabelResourceId: Int,
	drawableResourceId: Int,
	contentDescriptionResourceId: Int,
	onImageClick: () -> Unit,
	modifier: Modifier = Modifier
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
		modifier = modifier.fillMaxSize()
	) {
		Text(text = stringResource(textLabelResourceId), fontSize = 18.sp)
		Spacer(modifier = Modifier.height(16.dp))
		Image(
			painter = painterResource(drawableResourceId),
			contentDescription = stringResource(contentDescriptionResourceId),
			modifier = Modifier
				.wrapContentSize()
				.clickable(
					onClick = onImageClick
				)
				.border(
					BorderStroke(2.dp, Color(105, 205, 216)),
					shape = RoundedCornerShape(4.dp)
				)
				.padding(16.dp)
		)
	}
}
