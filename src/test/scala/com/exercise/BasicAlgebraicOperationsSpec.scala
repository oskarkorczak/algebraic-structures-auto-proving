package com.exercise

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object BasicAlgebraicOperationsSpec extends Properties("Basic algebraic operations") {

  property("add") = forAll { (a: Int, b: Int) =>
    BasicAlgebraicOperations.add(a, b) == a + b
  }
  
}
