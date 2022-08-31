package managers

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

class ViewerManager {
  private val selection = SingleSelection()

  var tabs = mutableStateListOf<Viewer>()
    private set

  val active: Viewer? get() = selection.selected as Viewer?

  @Composable
  fun createView() = Row(Modifier.width(55.dp).horizontalScroll(rememberScrollState())) {

    tabs.forEachIndexed { i, tab ->
      Surface(
        color = if (tab.isActive) Color.LightGray else Color.Transparent, modifier = Modifier.width(50.dp).height(50.dp)
      ) {
        if (tab.icon != null) {
          Image(tab.icon!!, tab.title, modifier = Modifier.width(50.dp).height(50.dp))
        } else {
          Box {
            Text(i.toString())
          }
        }
      }
    }
  }
}


open class Viewer {
  lateinit var selection: SingleSelection

  val statuses = mutableStateListOf<Status>()
  var icon: ImageVector? = null

  val isActive: Boolean
    get() = selection.selected === this

  open val title: String = ""

  @Composable
  open fun toView(): Unit = Unit
}

class SingleSelection {
  var selected: Any? by mutableStateOf(null)
}

abstract class Status {
  var onClick: (() -> Unit)? = null
}

data class IconStatus(var name: String, var icon: ImageVector) : Status()
data class TextStatus(var name: String, var text: String) : Status()