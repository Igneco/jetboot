package im.mange.jetboot.widget.form

import im.mange.jetpac.{Renderable, R, Html, Css}
import Css._
import Html._
import im.mange.jetboot.bootstrap3.Bootstrap._

case class FormHolder(columns: Int, formLayout: im.mange.jetboot.widget.form.layout.FormLayout, beforeLayout: Option[Renderable] = None, afterLayout: Option[Renderable] = None) extends Renderable {
  def render = div(beforeLayout.getOrElse(R()), formLayout, afterLayout.getOrElse(R()))
    .classes(jumbotron).styles(padding("10px"), paddingRight("0px"), margin("0px")).render
}
