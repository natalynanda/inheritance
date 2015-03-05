package code.model

import code.lib.RogueMetaRecord
import net.liftweb.record.field.IntField

/**
 * Created by Nataly on 05/03/2015.
 */
class Square extends Shape[Square]{
  override def meta = Square
  object side extends IntField(this, 0)
}

object Square extends Square with RogueMetaRecord[Square]
