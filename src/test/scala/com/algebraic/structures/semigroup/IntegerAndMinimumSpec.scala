package com.algebraic.structures.semigroup

import com.algebraic.structures.semigroup.IntegerAndMinimum.min
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object IntegerAndMinimumSpec extends Properties("Integer and minimum") {

  property("is total") = forAll { (a: BigInt, b: BigInt) =>
    val res = min(a, b)
    Set(a, b).contains(res) && res <= a & res <= b
  }

  property("is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    min(min(a, b), c) == min(a, min(b, c))
  }

  // Identity element and inverse element does not exist 

  property("is commutative") = forAll { (a: BigInt, b: BigInt) =>
    min(a, b) == min(b, a)
  }
}