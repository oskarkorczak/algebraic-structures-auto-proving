package com.algebraic.structures.monoid

import com.algebraic.structures.monoid.SequencesAndConcatenation.concat
import org.scalacheck.Prop.{exists, forAll, propBoolean}
import org.scalacheck.Properties

object SequencesAndConcatenationSpec extends Properties("Integer and concatenation") {

  property("is total") = forAll { (a: Seq[Int], b: Seq[Int]) =>
    val res = concat(a, b)
    res.size == a.size + b.size
  }

  property("is associative") = forAll { (a: Seq[Int], b: Seq[Int], c: Seq[Int]) =>
    concat(concat(a, b), c) == concat(a, concat(b, c))
  }

  property("has identity element") = forAll { a: Seq[Int] =>
    val identityElem = Seq()

    val left = concat(identityElem, a) == a
    val right = concat(a, identityElem) == a

    left == right
  }

  // has no inverse element

  property("is not commutative (counterexample)") = exists { a: Seq[Int] =>
    (a != Seq(1, 2, 3)) ==> {
      concat(a, Seq(1, 2, 3)) == concat(Seq(1, 2, 3), a)
    }
  }
}
