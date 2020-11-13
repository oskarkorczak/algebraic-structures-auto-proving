package com.algebraic.structures.group.abelian

import com.algebraic.structures.group.abelian.IntegerAndMultiplication.mul
import org.scalacheck.Prop.{forAll, propBoolean}
import org.scalacheck.{Gen, Properties}

object IntegerAndMultiplicationSpec extends Properties("Integer and multiplication") {

  private val neutralElem = BigInt(1)

  private val posBigInt = Gen.choose(0, Long.MaxValue).map { n: Long => BigInt(n) }
  private val negBigInt = Gen.choose(Long.MinValue, 0).map { n: Long => BigInt(n) }

  property("is total for opposite arguments") = forAll(posBigInt, negBigInt) { (a: BigInt, b: BigInt) =>
    mul(a, b) < 0
  }

  property("is total for positive arguments") = forAll(posBigInt, posBigInt) { (a: BigInt, b: BigInt) =>
    mul(a, b) >= 0
  }

  property("is total for negative arguments") = forAll(negBigInt, negBigInt) { (a: BigInt, b: BigInt) =>
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

  property("has inverse element") = forAll { a: BigInt =>
    (a != 0) ==> {
      val inverseElem: BigInt = BigInt(1) / a
      val left = mul(inverseElem, a) == neutralElem
      val right = mul(a, inverseElem) == neutralElem

      left == right
    }
  }

  property("is commutative") = forAll { (a: BigInt, b: BigInt) =>
    mul(a, b) == mul(b, a)
  }
}
