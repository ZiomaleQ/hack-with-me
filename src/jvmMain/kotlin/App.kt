import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import managers.ViewerManager

class App {
  private val viewersManager = ViewerManager()

  @Composable
  fun createView() {
    Row {
      viewersManager.createView()

      Box(Modifier.weight(1f, fill = true)) {
        viewersManager.active?.toView()
      }
    }
  }
}