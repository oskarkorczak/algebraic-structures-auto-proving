package com.exercise

import com.exercise.BasicAlgebraicOperations.add
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object BasicAlgebraicOperationsSpec extends Properties("Basic algebraic operations") {

  val addNeutralElem = 0

  property("add generates correct result") = forAll { (a: Int, b: Int) =>
    add(a, b) == a + b
  }

  property("add is associative") = forAll { (a: Int, b: Int, c: Int) =>
    add(add(a, b), c) == add(a, add(b, c))
  }

  property("add has neutral (aka identity) element") = forAll { (a: Int) =>
    add(a, addNeutralElem) == a && add(addNeutralElem, a) == a
  }

  property("add has inverse element") = forAll { (a: Int) =>
    add(a, -a) == addNeutralElem && add(-a, a) == addNeutralElem
  }

}
