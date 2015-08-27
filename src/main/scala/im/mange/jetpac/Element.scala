package im.mange.jetpac

import im.mange.jetpac.Js._

//TODO: starting to wonder if this should be a trait actually
//TODO: and maybe have a Widget class that widgets extend
//TIP: Element is like a handle for an id that you can do stuff with
//TODO: Possibly Element should be object actually or ElementCmdFactory .. then Element can be a trair .. or apply on Object
case class Element(id: String) {
  //TODO: should barf if id == Constant.ufe
  def addClass(className: String) = addElementClass(id, className)
  def disable = disableElement(id)
  def enable = enableElement(id)
  def empty = emptyElement(id)
  def emptyAndHide = emptyAndHideElement(id)
  def fill(value: Renderable) = fillElement(id, value.render)
  def fillAndShow(value: Renderable) = fillAndShowElement(id, value.render)
  def focus = focusElement(id)
  def getValue = getElementValue(id)
  def getText = getElementText(id)
  def hide = hideElement(id)
  def removeClass(className: String) = removeElementClass(id, className)
  def show = showElement(id)
  def setValue(value: String) = setElementValue(id, value)
  //  def setText(value: String) = setElementText(id, value)
  //  def setText(value: String) = setElementText(id, Text(value))
  //TODO: add setText
}

//TODO: Element could maybe selftype to Identifiable

//TODO: maybe InitialisableWidget
//TODO: InteractableWidget
