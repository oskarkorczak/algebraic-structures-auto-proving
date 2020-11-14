package com.algebraic.structures.semigroup

import com.algebraic.structures.semigroup.IntegerAndMaximum.max
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object IntegerAndMaximumSpec extends Properties("Integer and maximum") {

  property("is total") = forAll { (a: BigInt, b: BigInt) =>
    val res = max(a, b)
    Set(a, b).contains(res) && res >= a & res >= b
  }

  property("is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    max(max(a, b), c) == max(a, max(b, c))
  }

  // Identity element and inverse element does not exist 

  property("is commutative") = forAll { (a: BigInt, b: BigInt) =>
    max(a, b) == max(b, a)
  }
}