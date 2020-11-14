package com.algebraic.structures.quasigroup

import com.algebraic.structures.quasigroup.IntegerAndSubtraction.sub
import org.scalacheck.Prop.{ exists, forAll }
import org.scalacheck.{ Gen, Properties }

object IntegerAndSubtractionSpec extends Properties("Integer and subtraction") {

  private val neutralElem = 0

  private val posBigInt =
    Gen.choose(0, Long.MaxValue).map { n: Long => BigInt(n) }
  private val negBigInt =
    Gen.choose(Long.MinValue, 0).map { n: Long => BigInt(n) }

  property("is total yielding positive result") = forAll(posBigInt, negBigInt) {
    (a: BigInt, b: BigInt) =>
      val res = sub(a, b)
      res > 0 && res > a && res > b
  }

  property("is total yielding negative result") = forAll(negBigInt, posBigInt) {
    (a: BigInt, b: BigInt) =>
      val res = sub(a, b)
      res < 0 && res < a && res < b
  }

  property("is not associative (counterexample)") = exists { a: BigInt =>
    sub(sub(a, 5), 8) != sub(a, sub(5, 8))
  }

  property("has not identity element (counterexample)") = exists { a: BigInt =>
    sub(neutralElem, a) != sub(a, neutralElem)
  }

  property("has inverse element") = forAll { a: BigInt =>
    sub(a, a) == neutralElem
  }

  property("is not commutative (counterexample)") = exists { a: BigInt =>
    sub(a, 5) != sub(5, a)
  }
}
