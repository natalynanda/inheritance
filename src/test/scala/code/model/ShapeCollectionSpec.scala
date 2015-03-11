package code.model

import code.BaseMongoSessionWordSpec

/**
 * Created by Nataly on 05/03/2015.
 */
class ShapeCollectionSpec extends BaseMongoSessionWordSpec {

  "Shape Collection" should {
    "create, validate, save, and retrieve properly Shapes" in {
      var listShapes: List[Shape] = Nil

      val shapeType1 = ShapeType.createRecord
        .nameType("Square")
      shapeType1.save(true)


      val shapeType2 = ShapeType.createRecord
        .nameType("Triangle")
      shapeType2.save(true)


      val shapeType3 = ShapeType.createRecord
        .nameType("Square")
      shapeType3.save(true)

      val square = Square("Square", "", shapeType1.id.get, 10)

      val triangle = Triangle("Triangle", "", shapeType2.id.get, 10, 5)

      val circle = Circle("Circle", "", shapeType3.id.get, 50)

      val shapeCollection = ShapeCollection.createRecord

      shapeCollection.shapes.set(square :: triangle :: circle :: Nil)

      val errorShapeCollection = shapeCollection.validate
      if (errorShapeCollection.length > 1) {
        fail("Validation error: " + errorShapeCollection.mkString(", "))
      }
      shapeCollection.validate.length should equal (0)
      shapeCollection.save(true)

      println(ShapeCollection.findAll.toString())


      shapeCollection.shapes.value.map((shape: Shape) => shape match {
        case a: Square =>
          a.side should equal (10)
        case b: Triangle =>
          b.base should equal (10)
          b.height should equal (5)
        case c: Circle =>
          c.radius should equal (50)
      })

    }
  }

}
