package com.exercise

import com.exercise.BasicAlgebraicOperations.add
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object BasicAlgebraicOperationsSpec extends Properties("Basic algebraic operations") {

  property("add generates correct result") = forAll { (a: Int, b: Int) =>
    add(a, b) == a + b
  }

  property("add is associative") = forAll { (a: Int, b: Int, c: Int) =>
    add(add(a, b), c) == add(a, add(b, c))
  }

  property("add has neutral (aka identity) element") = forAll { (a: Int) =>
    val neutralElem = 0
    add(a, neutralElem) == a && add(neutralElem, a) == a
  }
}
