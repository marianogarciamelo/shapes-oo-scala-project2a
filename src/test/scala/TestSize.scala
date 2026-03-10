package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import com.typesafe.scalalogging.LazyLogging

import TestFixtures.*
import Shape.*

class TestSize extends AnyFunSuite with LazyLogging:

  def testSize(description: String, s: Shape, expected: Int): Unit =
    test(description):
      logger.debug(s"Testing size for: $description")
      val result = size(s)
      logger.debug(s"Expected: $expected, Got: $result")
      assert(expected == result)

  testSize("simple ellipse", simpleEllipse, 1)
  testSize("simple rectangle", simpleRectangle, 1)
  testSize("simple location", simpleLocation, 1)
  testSize("basic group", basicGroup, 2)
  testSize("simple group", simpleGroup, 2)
  testSize("complex group", complexGroup, 5)

end TestSize
