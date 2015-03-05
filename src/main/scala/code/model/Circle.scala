package code.model

import code.lib.RogueMetaRecord
import net.liftweb.record.field.IntField

/**
 * Created by Nataly on 05/03/2015.
 */
class Circle extends Shape[Circle]{
  override def meta = Circle
  object radius extends IntField(this, 0)
}

object Circle extends Circle with RogueMetaRecord[Circle]