package code.model

import code.BaseMongoSessionWordSpec

/**
 * Created by Nataly on 05/03/2015.
 */
class ShapeCollectionSpec extends BaseMongoSessionWordSpec {

  "Shape Collection" should {
    "create, validate, save, and retrieve properly Shapes" in {
      var listShapes: List[Shape[_]] = Nil

      val square = Square.createRecord
        .name("Square")
        .side(10)

      val triangle = Triangle.createRecord
        .name("Triangle")
        .base(10)
        .height(5)

      val circle = Circle.createRecord
        .name("Circle")
        .radius(50)

      val shapeCollection = ShapeCollection.createRecord

      shapeCollection.listShapes.set(listShapes.map((s: Shape[_]) => s match {
        case a: Square =>
          val errorSquare = a.validate
          if (errorSquare.length > 1) {
            fail("Validation error: " + errorSquare.mkString(", "))
          }
          a.validate.length should equal (0)
          a.save(false)
        case b: Triangle =>
          val errorTriangle = b.validate
          if (errorTriangle.length > 1) {
            fail("Validation error: " + errorTriangle.mkString(", "))
          }
          b.validate.length should equal (0)
          b.save(false)
        case c: Circle =>
          val errorCircle = c.validate
          if (errorCircle.length > 1) {
            fail("Validation error: " + errorCircle.mkString(", "))
          }
          c.validate.length should equal (0)
          c.save(false)
      }))

      val errorShapeCollection = shapeCollection.validate
      if (errorShapeCollection.length > 1) {
        fail("Validation error: " + errorShapeCollection.mkString(", "))
      }
      shapeCollection.validate.length should equal (0)
      shapeCollection.save(false)

      shapeCollection.listShapes.value.map((shape: Shape[_]) => shape match {
        case a: Square =>
          a.side.get should equal (10)
        case b: Triangle =>
          b.base.get should equal (10)
          b.height.get should equal (5)
        case c: Circle =>
          c.radius.get should equal (50)
      })
    }
  }

}
