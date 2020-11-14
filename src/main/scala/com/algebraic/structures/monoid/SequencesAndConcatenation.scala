package com.algebraic.structures.monoid

object SequencesAndConcatenation {

  def concat[T](a: Seq[T], b: Seq[T]): Seq[T] = {
    a ++ b
  }

}
