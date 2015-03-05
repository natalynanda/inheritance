package code.model

import code.lib.RogueMetaRecord
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.field.{MongoListField, ObjectIdPk}

/**
 * Created by Nataly on 05/03/2015.
 */
class ShapeCollection private() extends MongoRecord[ShapeCollection] with ObjectIdPk[ShapeCollection]{

  override def meta = ShapeCollection

  object listShapes extends MongoListField[ShapeCollection, Shape[_]](this)
}

object ShapeCollection extends ShapeCollection with RogueMetaRecord[ShapeCollection]
