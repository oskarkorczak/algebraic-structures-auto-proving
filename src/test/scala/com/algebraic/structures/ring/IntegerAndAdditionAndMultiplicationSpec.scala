package com.algebraic.structures.ring

import com.algebraic.structures.ring.IntegerAndAdditionAndMultiplication.{add, mul}
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object IntegerAndAdditionAndMultiplicationSpec extends Properties("Integer and addition and multiplication") {

  // addition over integers forms Abelian group
  // (see: com.algebraic.structures.group.abelian.IntegerAndAdditionSpec)

  // multiplication over integers forms commutative monoid
  // (see: com.algebraic.structures.monoid.commutative.IntegerAndMultiplicationSpec)

  property("is distributive") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>
    val leftDistributivity = mul(a, add(b, c)) == add(mul(a, b), mul(a, c))
    val rightDistributivity = mul(add(b, c), a) == add(mul(b, a), mul(c, a))

    leftDistributivity && rightDistributivity
  }
}
