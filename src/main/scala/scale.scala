package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale:
  def apply(factor: Double)(s: Shape): Shape = s match
    case Rectangle(w, h) =>
      Rectangle((w * factor).toInt, (h * factor).toInt)

    case Ellipse(rx, ry) =>
      Ellipse((rx * factor).toInt, (ry * factor).toInt)

    case Location(x, y, shape) =>
      Location((x * factor).toInt, (y * factor).toInt, apply(factor)(shape))

    case Group(shapes*) =>
      Group(shapes.map(apply(factor))*)

end scale
