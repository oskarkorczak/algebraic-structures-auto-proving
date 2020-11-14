package com.algebraic.structures.groupoid

import com.algebraic.structures.groupoid.RoShamBoGame.throwIter
import org.scalacheck.Prop.{exists, forAll}
import org.scalacheck.{Gen, Properties}

object RoShamBoGameSpec extends Properties("Rock Paper Scissors") {

  private val rps: Gen[RoShamBo] = Gen.oneOf(Rock, Paper, Scissors)

  property("is total") = forAll(rps, rps) { (a: RoShamBo, b: RoShamBo) =>
    val domain = Vector(Rock, Paper, Scissors)
    domain.contains(throwIter(a, b))
  }
  
  property("is not associative (counterexample)") = exists(rps) { a: RoShamBo =>
    throwIter(throwIter(a, Rock), Paper) != throwIter(a, throwIter(Rock, Paper))
  }
}
