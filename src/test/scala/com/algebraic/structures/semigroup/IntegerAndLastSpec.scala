package com.algebraic.structures.semigroup

import com.algebraic.structures.semigroup.IntegerAndLast.last
import org.scalacheck.Prop.{exists, forAll, propBoolean}
import org.scalacheck.Properties

object IntegerAndLastSpec extends Properties("Integer and last") {

  property("is total") = forAll { (a: BigInt, b: BigInt) =>
    last(a, b) == b
  }

  property("is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    last(last(a, b), c) == last(a, last(b, c))
  }

  // Identity element and inverse element does not exist 

  property("is not commutative (counterexample)") = exists { a: BigInt =>
    (a != 8) ==> {
      last(a, 8) != last(8, a)
    }
  }
}