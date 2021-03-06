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

  property("has no identity element (counterexample)") = forAll(rps) { (identityElem: RoShamBo) =>
    val leftIdentityForRock = throwIter(identityElem, Rock) == Rock
    val rightIdentityForRock = throwIter(Rock, identityElem) == Rock

    val leftIdentityForPaper = throwIter(identityElem, Paper) == Paper
    val rightIdentityForPaper = throwIter(Paper, identityElem) == Paper

    val leftIdentityForScissors = throwIter(identityElem, Scissors) == Scissors
    val rightIdentityForScissors = throwIter(Scissors, identityElem) == Scissors

    val res = leftIdentityForRock && rightIdentityForRock && leftIdentityForPaper && rightIdentityForPaper &&
      leftIdentityForScissors && rightIdentityForScissors

    res == false
  }

  property("has no invertibility (counterexample)") = forAll(rps) { invertedElem: RoShamBo =>
    val leftInvertedForRock = throwIter(invertedElem, Rock)
    val rightInvertedForRock = throwIter(Rock, invertedElem)

    val leftInvertedForPaper = throwIter(invertedElem, Paper)
    val rightInvertedForPaper = throwIter(Paper, invertedElem)

    val leftInvertedForScissors = throwIter(invertedElem, Scissors)
    val rightInvertedForScissors = throwIter(Scissors, invertedElem)

    Set(leftInvertedForRock, rightInvertedForRock, leftInvertedForPaper, rightInvertedForPaper,
      leftInvertedForScissors, rightInvertedForScissors).size > 1
  }

  property("is commutative") = forAll(rps, rps) { (a: RoShamBo, b: RoShamBo) =>
    throwIter(a, b) == throwIter(b, a)
  }
}
