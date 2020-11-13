package com.algebraic.structures.group.abelian

import IntegerAndAddition.add
import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object IntegerAndAdditionSpec extends Properties("Integer and addition") {

  private val neutralElem = 0

  private val posBigInt = Gen.choose(0, Long.MaxValue).map { n: Long => BigInt(n) }
  private val negBigInt = Gen.choose(Long.MinValue, 0).map { n: Long => BigInt(n)}

  property("is total for positive subset of integer domain") = forAll(posBigInt) { (a: BigInt) =>
      add(a, a) >= 0
  }

  property("is total for negative subset of integer domain") = forAll(negBigInt) { (a: BigInt) =>
    add(a, a) <= 0
  }

  property("is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    add(add(a, b), c) == add(a, add(b, c))
  }

  property("has neutral (identity) element") = forAll { (a: BigInt) =>
    add(a, neutralElem) == a && add(neutralElem, a) == a
  }

  property("has inverse element") = forAll { (a: BigInt) =>
    add(a, -a) == neutralElem && add(-a, a) == neutralElem
  }

  property("is commutative") = forAll { (a: BigInt, b: BigInt) =>
    add(a, b) == add(b, a)
  }
}
