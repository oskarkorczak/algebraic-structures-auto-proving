package com.algebraic.structures.semigroup

object IntegerAndLast {

  def last(a: BigInt, b: BigInt): BigInt = {
    Vector(a, b).reverse.head
  }

}
