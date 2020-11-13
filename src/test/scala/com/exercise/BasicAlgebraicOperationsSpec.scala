package com.exercise

import com.exercise.BasicAlgebraicOperations.add
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object BasicAlgebraicOperationsSpec extends Properties("Basic algebraic operations") {

  property("add generates correct result") = forAll { (a: Int, b: Int) =>
    add(a, b) == a + b
  }
}
