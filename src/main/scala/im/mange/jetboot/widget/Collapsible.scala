package im.mange.jetboot.widget

import im.mange.jetboot._
import im.mange.jetpac._
import im.mange.jetpac.css.Classes
import net.liftweb.http.SHtml

//TIP: http://www.plugolabs.com/twitter-bootstrap-button-generator-3/
//<button class="btn btn-success btn-xs">foo <span class="glyphicon glyphicon-chevron-right"></span></button>
//TODO: ultimate make a Button and pass it in
case class Collapsible(id: String, label: String, theContent: Renderable, buttonClasses: Classes, expandedByDefault: Boolean = false) extends Renderable {
  import Html._

  private var expanded = expandedByDefault
  private val link = Element("collapsibleLink_" + id)
  private val collapsibleContent = div(Some("collapsibleContent_" + id), theContent).classes(if (expandedByDefault) "" else Css.hidden)
  private val contentHolder = div(Some("collapsibleSection_" + id), content)//.styles(marginBottom("10px"))

  def render = contentHolder.render

  private def content =
    R(
      R(<span>{displayExpander().render}</span>),
      collapsibleContent
    )

  private def displayExpander() = {
    //TODO: use Html.a()

    R(SHtml.a(() => toggle(),
      <button type="button" class={s"btn ${buttonClasses.render}" + (if (expanded) " active" else "")} data-toggle="button" style="font-weight: bold;" id={link.id}>{icon().render}</button>,
      "style" -> "text-decoration: none;"
    ))
  }

  private def toggle() = {
    if (expanded) {
      expanded = false
      collapse()
    } else {
      expanded = true
      expand()
    }
  }

  private def expand() = collapsibleContent.show & link.fill(closeIcon())
  private def collapse() = collapsibleContent.hide & link.fill(openIcon())
  private def openIcon() = R(<span><span class="glyphicon glyphicon-chevron-right"/>&nbsp;{label}</span>)
  private def closeIcon() = R(<span><span class="glyphicon glyphicon-chevron-down"/>&nbsp;{label}</span>)
  private def icon() = if (expanded) closeIcon() else openIcon()
}
