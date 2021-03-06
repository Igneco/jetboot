package im.mange.jetboot.widget.inplace

import im.mange.jetpac.{Renderable, Initialisable, Identifiable}
import net.liftweb.http.js.JsExp

trait InPlaceEditor extends Renderable with Initialisable with Identifiable {
  def currentValue: JsExp
  def editorClass = id + "_editor"
}
