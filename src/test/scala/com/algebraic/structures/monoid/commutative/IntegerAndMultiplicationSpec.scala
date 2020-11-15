package com.algebraic.structures.monoid.commutative

import com.algebraic.structures.monoid.commutative.IntegerAndMultiplication.mul
import org.scalacheck.Prop.forAll
import org.scalacheck.{ Gen, Properties }

object IntegerAndMultiplicationSpec extends Properties("Integer and multiplication") {

  private val neutralElem = 1

  private val posBigInt = Gen.choose(0, Long.MaxValue).map { n: Long => BigInt(n) }
  private val negBigInt = Gen.choose(Long.MinValue, 0).map { n: Long => BigInt(n) }

  property("is total for opposite arguments") = forAll(posBigInt, negBigInt) {
    (a: BigInt, b: BigInt) =>
      mul(a, b) < 0
  }

  property("is total for positive arguments") = forAll(posBigInt, posBigInt) {
    (a: BigInt, b: BigInt) =>
      mul(a, b) >= 0
  }

  property("is total for negative arguments") = forAll(negBigInt, negBigInt) {
    (a: BigInt, b: BigInt) =>
      mul(a, b) >= 0
  }

  property("is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    mul(mul(a, b), c) == mul(a, mul(b, c))
  }

  property("has neutral (identity) element") = forAll { a: BigInt =>
    val left = mul(neutralElem, a) == a
    val right = mul(a, neutralElem) == a

    left == right
  }

  // inverse property does not exist as e.g. 2 has it's inverse element 1/2,
  // which clearly is not an integer, therefore (integer, *) is not a group

  property("is commutative") = forAll { (a: BigInt, b: BigInt) =>
    mul(a, b) == mul(b, a)
  }
}
