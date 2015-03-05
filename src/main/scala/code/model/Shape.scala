package code.model

import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.field.{ObjectIdRefField, ObjectIdPk}
import net.liftweb.record.field.StringField

/**
 * Created by Nataly on 05/03/2015.
 */
trait Shape [T <: MongoRecord[T]] extends MongoRecord[T] with ObjectIdPk[T] {
  this: T =>

  object name extends StringField(this.asInstanceOf[T], 500)
  object description extends StringField(this.asInstanceOf[T], 500)
}
