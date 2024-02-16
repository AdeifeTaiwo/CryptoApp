package com.example.cryptoapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoapp.model.CryptoCurrencyInfo
import com.example.cryptoapp.model.CurrentCryptoBackgroundInfo
import com.example.cryptoapp.reusables.drawCurvyLines
import com.example.cryptoapp.ui.theme.ButtonBlue
import com.example.cryptoapp.ui.theme.CryptoAppTheme
import com.example.cryptoapp.ui.theme.CryptoOrange
import com.example.cryptoapp.ui.theme.CryptoOrange2
import com.example.cryptoapp.ui.theme.CryptoOrange3

import androidx.compose.material3.Icon
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import com.example.cryptoapp.model.Feature
import com.example.cryptoapp.reusables.standardQuadFromTo
import com.example.cryptoapp.ui.theme.Beige1
import com.example.cryptoapp.ui.theme.Beige2
import com.example.cryptoapp.ui.theme.Beige3
import com.example.cryptoapp.ui.theme.BlueViolet1
import com.example.cryptoapp.ui.theme.BlueViolet2
import com.example.cryptoapp.ui.theme.BlueViolet3
import com.example.cryptoapp.ui.theme.LightGreen1
import com.example.cryptoapp.ui.theme.LightGreen2
import com.example.cryptoapp.ui.theme.LightGreen3
import com.example.cryptoapp.ui.theme.OrangeYellow1
import com.example.cryptoapp.ui.theme.OrangeYellow2
import com.example.cryptoapp.ui.theme.OrangeYellow3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CTAMyCryptoCapHeader()
                    CTAMyCryptoCap()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CyptoCapPreview() {
    CryptoAppTheme {
        CTAMyCryptoCap()
    }
}

private val mockBgData = listOf(
    CurrentCryptoBackgroundInfo("Jan", CryptoOrange),
    CurrentCryptoBackgroundInfo("Feb", ButtonBlue),
    CurrentCryptoBackgroundInfo("Mar", CryptoOrange3)
)

private val featureList = listOf(
    Feature(
        1,
        title = "Jan",
        R.drawable.light_bulb,
        BlueViolet1,
        BlueViolet2,
        BlueViolet3
    ),
    Feature(
        2,
        title = "Feb",
        R.drawable.light_bulb,
        LightGreen1,
        LightGreen2,
        LightGreen3
    ),
    Feature(
        3,
        title = "Mar",
        R.drawable.light_bulb,
        OrangeYellow1,
        OrangeYellow2,
        OrangeYellow3
    ),
    Feature(
        4,
        title = "April",
        R.drawable.light_bulb,
        Beige1,
        Beige2,
        Beige3
    ),
    Feature(
        5,
        title = "May",
        R.drawable.light_bulb,
        Beige1,
        Beige2,
        Beige3
    ),
    Feature(
        6,
        title = "June",
        R.drawable.light_bulb,
        Beige1,
        Beige2,
        Beige3
    )
)


private val mockData = CryptoCurrencyInfo(
    39_532.84f,
    "NGN", listOf(
        Pair("Jan", 15000f),
        Pair("Feb", 20000f),
        Pair("Mar", 38000f),
        Pair("Apr", 8000f),
        Pair("May", 10000f),
        Pair("June", 12300f)
    )


)


@Preview(showBackground = true)
@Composable
fun CyptoCapHone() {
    CryptoAppTheme {
        CTAMyCryptoCapHome()
    }
}

@Composable
fun CTAMyCryptoCapHome() {
    Column(modifier = Modifier.fillMaxSize()) {
        CTAMyCryptoCapHeader()
        CTAMyCryptoCap()
        Spacer(modifier = Modifier.height(4.dp))
        CurrentCryptoItemColumn(featureList)
        Spacer(modifier = Modifier.height(10.dp))
    }
}


@Composable
fun CTAMyCryptoCap(modifier: Modifier = Modifier, mockUIData: CryptoCurrencyInfo = mockData) {

    val verticalOrangeGradient = Brush.verticalGradient(
        colors = listOf(
            CryptoOrange2,
            CryptoOrange3
        )
    )
    Card(
        modifier = Modifier
            .background(color = Color.White)
            .padding(10.dp)
            .fillMaxWidth()
            .height(350.dp),
        colors = CardDefaults.cardColors(
            containerColor = CryptoOrange
        ),
        shape = RoundedCornerShape(4)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(verticalOrangeGradient)
                .drawBehind {
                    this.drawCurvyLines()
                }
        ) {
            Column(modifier = Modifier.padding(top = 50.dp, start = 10.dp, end = 10.dp)) {
                Text(
                    text = "MY Crypto Cap",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.ExtraLight
                )

                Text(
                    text = "${mockUIData.value} ${mockUIData.currency}",
                    color = Color.White,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                MonthlyCapPreview(mockUIData.monthlyPreview)
            }
        }
    }
}

@Composable
fun MonthlyCapPreview(monthlyPreview: List<Pair<String, Float>>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        val maxMonthValue = monthlyPreview.maxBy { it.second }.second
        Row(
            modifier = Modifier.fillMaxHeight(.8f),
            verticalAlignment = Alignment.Bottom
        ) {
            for (pairPreview in monthlyPreview) {
                val columnHeight = pairPreview.second / maxMonthValue
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(columnHeight)
                        .padding(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = setHighlightColor(pairPreview, maxMonthValue)
                    ),
                    shape = RoundedCornerShape(30)
                ) { }
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            for (pairReview in monthlyPreview) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = pairReview.first,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = setHighlightColor(
                        pairPreview = pairReview,
                        maxMonthValue = maxMonthValue
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentCryptoItemColumnPreview() {
    CryptoAppTheme {
        CurrentCryptoItemColumn(featureList)
    }
}

@Composable
fun CurrentCryptoItemColumn(featureList: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {

        Text(
            text = "Data Insight",
            modifier = Modifier.padding(8.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Click to see more data",
            modifier = Modifier.padding(8.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(start = 7.5.dp, bottom = 50.dp, end = 7.5.dp),
            modifier = Modifier.fillMaxHeight()
        ) {

            items(featureList.size) {
                CurrentCryptoItem(featureList[it])
            }
        }
    }
}


@Composable
@Preview
fun PreviewCryptoItem() {
    CryptoAppTheme {
        AlatGradientBackground()
    }

}

@Composable
fun AlatGradientBackground() {

    BoxWithConstraints(
        modifier = Modifier
            .height(156.dp)
            .width(400.dp)
            .background(Color(0XFF6B214A))
            .clip(RoundedCornerShape(10.dp))
    ) {

        val width = constraints.maxWidth
        val height = constraints.maxHeight

        val alatCurvePoint1 = Offset(x = 0f, y = height * 0.55f)
        val alatCurvePoint2 = Offset(x = width * 0.3f, y = height * 0.35f)
        val alatCurvePoint3 = Offset(x = width * 0.6f, y = 0.0f)

        val alatCurvedPath = Path().apply {
            moveTo(alatCurvePoint1.x, alatCurvePoint1.y)
            standardQuadFromTo(alatCurvePoint1, alatCurvePoint2)
            standardQuadFromTo(alatCurvePoint2, alatCurvePoint3)
            lineTo(width * 0.6f, 0.0f)
            lineTo(0f, 0f)
            close()
        }

        val alatCurveDeepPoint1 = Offset(x = width * 0.35f, y = height * 1f)
        val alatCurveDeepPoint2 = Offset(x = width * 0.5f, y = height * 0.9f)
        val alatCurveDeepPoint3 = Offset(x = width * 1f - 30f, y = 0f)


        val alatCurvedPath2 = Path().apply {
            moveTo(alatCurveDeepPoint1.x, alatCurveDeepPoint1.y)
            standardQuadFromTo(alatCurveDeepPoint1, alatCurveDeepPoint2)
            standardQuadFromTo(alatCurveDeepPoint2, alatCurveDeepPoint3)
            lineTo(width * 1f - 30f, 0.0f)
            lineTo(width * 1f, 0.0f)
            lineTo(width * 1f, height * 1f)
            close()
        }

        val brush = Brush.linearGradient(
            0.0f to Color(0XFFB2214A),
            500.0f to Color(0XFF6B214A),
            start = Offset.Zero,
            end = Offset.Infinite
        )

        val brush2 = Brush.linearGradient(
            0.0f to Color(0XFFB2214A),
            200.0f to Color(0XFF6B214A),
            start = Offset(x = 200f, y = 0f),
            end = Offset.Infinite
        )

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
        ) {
            drawRect(brush)
            drawPath(
                path = alatCurvedPath,
                color = Color(0XFFB2214A)
            )
            drawPath(
                path = alatCurvedPath2,
                color = Color(0XFF6B214A).copy(alpha = 0.2f)
            )

        }


        Text(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterStart),
            text = "Approve Verifier",
            color = Color.White
        )

        Row(modifier = Modifier
            .padding(start = 8.dp, bottom = 16.dp)
            .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(0.dp)){

            Text(
                text = "Open",
                color = Color.White
            )
            Icon(modifier = Modifier.padding(top = 2.dp).size(16.dp),
                imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "",
                tint = Color.White
            )
        }
        Image(
            modifier = Modifier.align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.users), contentDescription = ""
        )


    }
}

@Composable
fun CurrentCryptoItem(
    feature: Feature? = null
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature!!.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.6f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() * 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()

        }

        val alatMediumColoredPoint1 = Offset(0f, height * 0.3f)
        val alatMediumColoredPoint2 = Offset(0f, height * 0.4f)


        //Light colored path
        val lightPoint1 = Offset(0f, height * 0.65f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)


            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()

        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Text(
                text = feature.title,
                style = MaterialTheme.typography.bodySmall,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier
                    .clickable { }
                    .align(Alignment.BottomStart)
            )

            val monthlyPreview = mockData.monthlyPreview
            val maxMonthValue = monthlyPreview.maxBy { it.second }.second
            val columnHeight = monthlyPreview[feature.position - 1].second / maxMonthValue


            Column(
                modifier = Modifier
                    .fillMaxHeight(columnHeight)
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(30))
                    .background(
                        setHighlightColor(
                            pairPreview = monthlyPreview[feature.position - 1],
                            maxMonthValue = maxMonthValue
                        )
                    )
                    .width(20.dp),
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxHeight(columnHeight)
                        .width(20.dp)
                        .padding(5.dp)
                        .padding(vertical = 6.dp, horizontal = 15.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = setHighlightColor(
                            monthlyPreview[feature.position - 1],
                            maxMonthValue
                        )
                    ),
                    shape = RoundedCornerShape(30)
                ) {

                }
            }
        }
    }
}

@Composable
private fun setHighlightColor( //<--- Helper function to determine colour of Text and Bar
    pairPreview: Pair<String, Float>,
    maxMonthValue: Float
) = if (pairPreview.second == maxMonthValue) Color.White else Color.White.copy(
    alpha = 0.4f
)

@Preview(showBackground = true)
@Composable
fun CyptoCapHeaderPreview() {
    CryptoAppTheme {
        CTAMyCryptoCapHeader()
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentCryptoItemPreview() {
    CryptoAppTheme {
        CurrentCryptoItem()
    }
}

@Composable
fun CTAMyCryptoCapHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Column {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(painterResource(id = R.drawable.fund_wallet_svg), contentDescription = null)

                Image(
                    painterResource(id = R.drawable.notifications_bell),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    alpha = .6f
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                Text(text = "Today's \nTrade Value", fontWeight = FontWeight.SemiBold)
                Text(
                    text = "+980.6 USD",
                    fontWeight = FontWeight.Normal,
                    color = CryptoOrange3,
                    fontSize = 30.sp
                )

            }

        }
    }
}
