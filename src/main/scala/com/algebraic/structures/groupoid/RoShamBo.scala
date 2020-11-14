package com.algebraic.structures.groupoid


sealed trait RoShamBo

case object Rock extends RoShamBo
case object Paper extends RoShamBo
case object Scissors extends RoShamBo

object RoShamBoGame {

  def throwIter(a: RoShamBo, b: RoShamBo): RoShamBo = {
    val curr = Set(a, b)

    if (curr == Set(Rock, Paper)) Paper
    else if (curr == Set(Rock, Scissors)) Rock
    else if (curr == Set(Paper, Scissors)) Scissors
    else a
  }
}
