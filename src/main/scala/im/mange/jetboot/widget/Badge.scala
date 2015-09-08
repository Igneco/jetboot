package im.mange.jetboot.widget

import im.mange.jetpac._

//TIP: it is strongly recommended to set 0 values to be "" because
//(1) it looks better - given that badges are largely for todos
//(2) its must easier to test in phantom (where easy = possible)
case class Badge(id: String, value: String) extends Renderable with Identifiable with Styleable {
  import Html._

  private val content = span(Some(id), R(value))
    .styles(styles)
    .classes(classes.add("badge", if (value.trim.isEmpty) "hidden" else ""))

  override def render = content.render

  def update(value: String) = if (value.trim().isEmpty) content.emptyAndHide else content.fillAndShow(R(value))
}
