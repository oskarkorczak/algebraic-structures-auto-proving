package com.algebraic.structures.semigroup

import com.algebraic.structures.semigroup.IntegerAndFirst.first
import org.scalacheck.Prop.{exists, forAll, propBoolean}
import org.scalacheck.Properties

object IntegerAndFirstSpec extends Properties("Integer and first") {

  property("is total") = forAll { (a: BigInt, b: BigInt) =>
    first(a, b) == a
  }

  property("is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    first(first(a, b), c) == first(a, first(b, c))
  }

  // Identity element and inverse element does not exist 

  property("is not commutative (counterexample)") = exists { a: BigInt =>
    (a != 8) ==> {
      first(a, 8) != first(8, a)
    }
  }
}