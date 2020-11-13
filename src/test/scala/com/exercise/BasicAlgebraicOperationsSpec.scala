package com.exercise

import com.exercise.BasicAlgebraicOperations.add
import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object BasicAlgebraicOperationsSpec extends Properties("Basic algebraic operations") {

  private val addNeutralElem = 0
  private val posBigInt = Gen.choose(0, Long.MaxValue).map { n: Long => BigInt(n) }
  private val negBigInt = Gen.choose(Long.MinValue, 0).map { n: Long => BigInt(n)}

  property("add is total for positive portion of domain") = forAll(posBigInt) { (a: BigInt) =>
      add(a, a) >= 0
  }

  property("add is total for negative portion of domain") = forAll(negBigInt) { (a: BigInt) =>
    add(a, a) <= 0
  }

  property("add is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    add(add(a, b), c) == add(a, add(b, c))
  }

  property("add has neutral (aka identity) element") = forAll { (a: BigInt) =>
    add(a, addNeutralElem) == a && add(addNeutralElem, a) == a
  }

  property("add has inverse element") = forAll { (a: BigInt) =>
    add(a, -a) == addNeutralElem && add(-a, a) == addNeutralElem
  }

  property("add is commutative") = forAll { (a: BigInt, b: BigInt) =>
    add(a, b) == add(b, a)
  }
}
