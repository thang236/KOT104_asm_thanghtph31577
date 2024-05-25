import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_thanghtph31577.ui.compose.CartSection
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navControl: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color(0xff303030),
                ),
                title = {

                    Box(modifier = Modifier.fillMaxWidth()){
                        IconButton(onClick = { navControl.popBackStack() },
                            modifier = Modifier.align(Alignment.TopStart)
                        ) {
                            Icon(Icons.Default.ArrowBackIosNew, contentDescription ="",
                                modifier = Modifier.size(30.dp))
                        }

                        Text(text = "My cart",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 5.dp)
                        )

                    }
                }
            )
        }
    ) {innerPadding->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            CartSection(navControl)



        }


    }
}
