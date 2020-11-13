# Algebraic Structures Automated Proving (ASAP)
[Abstract algebra][abstract-algebra] is the study of [algebraic structures][algebraic-structure]. Algebraic structures include groups, rings, fields, lattices etc. 

In simple terms an *algebraic structure* consists of non-empty set and a collection of operations on this set of finite arity (typically binary operations). Often times it is a pair (set, operation) fulfilling or not certain axioms. 

ASAP attempts to prove necessary mathematical axioms by utilising [ScalaCheck][scalacheck] property based testing approach. 

## Axioms
In order to see whether a particular pair (set, operation) belongs to any algebraic structure, it needs to have some useful properties. These properties are expressed as axioms, which algebraic structure may fulfil or not. 

Below are the most useful properties (axioms). 


### Totality (equivalent to Closure)
For all ***a***, ***b*** in ***A***, the result of the operation ***a &sdot; b*** is also in ***A***.


### Associativity
For all ***a***, ***b***, and ***c*** in ***A***, the equation ***(a &sdot; b) &sdot; c = a &sdot; (b &sdot; c)*** holds.

### Identity
There exists an element ***e*** in ***A***, such that for all elements ***a*** in ***A***, the equation ***e &sdot;  a = a &sdot; e = a*** holds.

### Invertibility
For each ***a*** in ***A*** there exists an element ***b*** in ***A*** such that ***a &sdot; b = b &sdot; a = e***, where ***e*** is the identity element.

### Commutativity
For all ***a***, ***b*** in ***A***, ***a &sdot; b = b &sdot; a***.




 


[abstract-algebra]: https://en.wikipedia.org/wiki/Abstract_algebra
[algebraic-structure]: https://en.wikipedia.org/wiki/Algebraic_structure
[scalacheck]: http://www.scalacheck.org/