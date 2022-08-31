import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

val instance = App()

fun main() = application {
  Window(onCloseRequest = ::exitApplication) {
    instance.createView()
  }
}