package im.mange.jetboot.widget

import im.mange.jetboot.{Disableable, Hideable, Renderable, Styleable}
import net.liftweb.http.SHtml

//TODO: this should probably extend Input
trait TextArea extends Renderable with Styleable with Disableable with Hideable {
  val placeholder: String
  def render = SHtml.textarea("", onSubmit(_), "id" → id, "class" → classes.render, "placeholder" → placeholder)
  def updateValue(value: String) = element.setValue(value)
  def onSubmit(value: String): Unit
}