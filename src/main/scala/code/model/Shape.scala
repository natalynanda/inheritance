package code.model

import code.lib.RogueMetaRecord
import net.liftweb.json._
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.field.{MongoCaseClassListField, ObjectIdPk}
import org.bson.types.ObjectId

/**
 * Created by Nataly on 05/03/2015.
 */
trait Shape {
  def name: String
  def description: String
  def typeShape: ObjectId
}

case class Circle(name: String, description: String, typeShape: ObjectId, radius: Int) extends Shape

case class Square(name: String, description: String, typeShape: ObjectId, side: Int) extends Shape

case class Triangle(name: String, description: String, typeShape: ObjectId, base: Int, height: Int) extends Shape

class ShapeCollection private() extends MongoRecord[ShapeCollection] with ObjectIdPk[ShapeCollection]{
  def meta = ShapeCollection
  object shapes extends MongoCaseClassListField[ShapeCollection, Shape](this) {
    override implicit lazy val formats: Formats =
      DefaultFormats.withHints(
        ShortTypeHints(List(classOf[Circle], classOf[Square], classOf[Triangle]))
      )
  }
}

object ShapeCollection extends ShapeCollection with RogueMetaRecord[ShapeCollection]
