package com.example.farmersmarketplace


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.example.farmersmarketplace.ui.theme.*
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isSplashScreen = mutableStateOf(true)
        lifecycleScope.launch(Dispatchers.Default){
           delay(3000)
            isSplashScreen.value = false
        }
        installSplashScreen().apply {
                    setKeepOnScreenCondition{
                        isSplashScreen.value
                }
                }
        setContent {
           MainLayout()
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainLayout() {
   val primaryColor = Color(76, 175, 80, 255)
    FarmersMarketplaceTheme() {
        Surface(
            color = MaterialTheme.colors.background
        ){
          Column(
              modifier = Modifier
                  .background(color = primaryColor)
                  .fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.SpaceAround)
          {
               Column(verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.Start,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp)) {
                   Text(text = "Welcome to Farmers MarketPlace",
                   textAlign = TextAlign.Start,
                       fontFamily = sfProBold,
                   fontSize = 33.sp,
                   color = Color.White,
                 

                   )
                   Spacer(modifier = Modifier.padding(bottom = 10.dp)
                   )

                   Text(text = "Number One Place For Buying And Selling Products",
                       textAlign = TextAlign.Start,
                       fontFamily = sfProLight,
                       fontSize = 18.sp,
                       color = Color.White
                   )

               }
              Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceEvenly,
                  modifier = Modifier.fillMaxWidth().padding(bottom = 100.dp)
              ){
                  Button(onClick = {


                  },
                  modifier = Modifier
                      .width(150.dp)
                      .height(50.dp)
                      .border(
                          width = 1.dp,
                          color = Color.White,
                          shape = RoundedCornerShape(5.dp)),

                      colors = ButtonDefaults.buttonColors(
                          backgroundColor = primaryColor
                      )
                  ) {
                      Text(text = "Login", color = Color.White)
                  }




                  Button(onClick = {},
                      modifier = Modifier
                          .width(150.dp)
                          .height(50.dp)
                          .border(
                              width = 1.dp,
                              color = primaryColor,
                              shape = RoundedCornerShape(5.dp)
                          ),
                  colors = ButtonDefaults.buttonColors(
                      backgroundColor = Color.White
                  )
                      )
                  {
                      Text(text = "Join Now", color =Color.Black)
                  }
              }
              }
          }
        }
    }


