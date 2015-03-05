package code.model

import code.lib.RogueMetaRecord
import net.liftweb.record.field.IntField

/**
 * Created by Nataly on 05/03/2015.
 */
class Triangle extends Shape[Triangle]{
  override def meta = Triangle
  object base extends IntField(this, 0)
  object height extends IntField(this, 0)
}

object Triangle extends Triangle with RogueMetaRecord[Triangle]
