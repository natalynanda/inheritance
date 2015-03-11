package code.model

import code.lib.RogueMetaRecord
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.field.ObjectIdPk
import net.liftweb.record.field.StringField

/**
 * Created by Nataly on 11/03/2015.
 */

class ShapeType private() extends MongoRecord[ShapeType] with ObjectIdPk[ShapeType]{

  override def meta = ShapeType

  object nameType extends StringField(this, 100)
}

object ShapeType extends ShapeType with RogueMetaRecord[ShapeType]