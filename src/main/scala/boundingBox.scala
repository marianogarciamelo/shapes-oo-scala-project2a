package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h))

    case Ellipse(rx, ry) =>
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

    case Location(x, y, shape) =>
      val Location(u, v, Rectangle(w, h)) = apply(shape)
      Location(x + u, y + v, Rectangle(w, h))

    case Group(shapes*) =>
      if shapes.isEmpty then
        Location(0, 0, Rectangle(0, 0))
      else
        val boxes = shapes.map(apply).toSeq
        val leftMost = boxes.map(_.x).min
        val topMost = boxes.map(_.y).min
        val rightMost = boxes.map(loc => loc.x + loc.shape.asInstanceOf[Rectangle].width).max
        val bottomMost = boxes.map(loc => loc.y + loc.shape.asInstanceOf[Rectangle].height).max
        Location(leftMost, topMost, Rectangle(rightMost - leftMost, bottomMost - topMost))

end boundingBox
