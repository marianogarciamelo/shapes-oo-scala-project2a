package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import com.typesafe.scalalogging.LazyLogging

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite with LazyLogging:

  def testScale(description: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(description):
      logger.debug(s"Testing scale for: $description with factor $factor")
      val result = scale(factor)(s)
      logger.debug(s"Expected: $expected, Got: $result")
      assert(expected == result)

  testScale("simple ellipse", simpleEllipse, 2.0, Ellipse(100, 60))
  testScale("simple rectangle", simpleRectangle, 0.5, Rectangle(40, 60))
  testScale("simple location", simpleLocation, 2.0, Location(140, 60, Rectangle(160, 240)))
  testScale("basic group", basicGroup, 0.5, Group(Ellipse(25, 15), Rectangle(10, 20)))
  testScale("simple group", simpleGroup, 1.0, simpleGroup)
  testScale("complex group", complexGroup, 0.5,
    Location(25, 50,
      Group(
        Ellipse(10, 20),
        Location(75, 25,
          Group(
            Rectangle(25, 15),
            Rectangle(150, 30),
            Location(50, 100,
              Ellipse(25, 15)
            )
          )),
        Rectangle(50, 100)
      )))

end TestScale
