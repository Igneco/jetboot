package im.mange.jetboot.input

import im.mange.jetboot.widget.form.FormInput
import net.liftweb.http.SHtml

case class CheckBox(field: Field, default: Boolean) extends FormInput {
  var value = default

  //TODO: we need to remove the wrapping span - but we can't because EventHandling needs an Elem and we have a NodeSeq ... arrrrggghhh
  //TODO: as a result EventHandling isn't going to work on CheckBox .... because the event handles wont be attached to the input
  override def baseElement = <span>{SHtml.checkbox(default, onSubmit _, "id" → id, "style" → styles.render, "class" → classes.render)}</span>

  //TODO: there should probably be a default on FormInput which should be rarely overriden (like here only so far)
  private def onSubmit(value: Boolean) { this.value = value }
}