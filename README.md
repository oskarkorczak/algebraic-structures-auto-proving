# Algebraic Structures Automated Proving (ASAP)
[Abstract algebra][abstract-algebra] is the study of [algebraic structures][algebraic-structure]. Algebraic structures include groups, rings, fields, lattices etc. 

In simple terms an *algebraic structure* consists of non-empty set and a collection of operations on this set of finite arity (typically binary operations). Often times it is a pair (set, operation) fulfilling or not certain axioms. 

ASAP attempts to prove necessary mathematical axioms for a given structure by utilising [ScalaCheck][scalacheck] property based testing approach. 

## Axioms
In order to see whether a particular pair (set, operation) belongs to any algebraic structure, it needs to have some useful properties. These properties are expressed as axioms, which algebraic structure may fulfil or not. 

Below are the most useful axioms. 


### Totality (equivalent to Closed)
For all ***a***, ***b*** in ***A***, the result of the operation ***a &sdot; b*** is also in ***A***.


### Associativity
For all ***a***, ***b***, and ***c*** in ***A***, the equation ***(a &sdot; b) &sdot; c = a &sdot; (b &sdot; c)*** holds.

### Identity Element
There exists an element ***e*** in ***A***, such that for all elements ***a*** in ***A***, the equation ***e &sdot;  a = a &sdot; e = a*** holds.

### Invertibility Element
For each ***a*** in ***A*** there exists an element ***b*** in ***A*** such that ***a &sdot; b = b &sdot; a = e***, where ***e*** is the identity element.

### Commutativity
For all ***a***, ***b*** in ***A***, ***a &sdot; b = b &sdot; a***.



## Algebraic Structures
Most prominent algebraic structures are listed below and have their proofs in the code, as per examples in each section. 


### [Grupoid (aka Magma)][magma]
Grupoid/Magma consists of a set equipped with a single binary operation that must be closed (total binary operator) by definition. No other properties are imposed. 

Incidentally, naming convention is fairly inconsistent especially in this case. You may read about Magma origin [here][magma-mathoverflow-term-origin] and [here][magma-ethymology]. Also, it is interesting how French preserved [various magma term meanings][magma-fr-dict], which did not happen in many other languages. 


###### Examples

* (RoShamBo, throw) aka (RockPaperScissors, throw)



### [Quasigroup][quasigroup]
Quasigroup consists of a set equipped with a single binary operation that must be close and operation is invertible. 

###### Examples
* (integer, −)


### [Semigroup][semigroup]
A semigroup is a set together with a binary operation that is total and satisfies the associative property.

More succinctly, a semigroup is an associative magma.

###### Examples

* (integer, min)
* (integer, max)
* (integer, first)
* (integer, last)


### [Monoid][monoid]
In abstract algebra, a branch of mathematics, a monoid is a set equipped with an associative binary operation and an identity element.

###### Examples

* (sequence, concat)
* (integer, &sdot;) - commutative monoid



### [Abelian Group][abelian-group]
To qualify as an Abelian Group, the set and operation, (A, &sdot;), must satisfy five requirements known as the Abelian group axioms i.e. closure, associativity, identity element, inverse element, commutativity. 

###### Examples

* (integer, +)



### [Ring][ring]
A ring is a set ***R*** equipped with two binary operations ***+*** and ***&sdot;*** satisfying the following three sets of axioms, called the ring axioms:

1. ***R*** is an abelian group under addition, meaning that:
	* ***+*** is associative
	* ***+*** is commutative
	* ***0*** is the additive identity
	* ***−a*** is the additive inverse of a
2. R is a monoid under multiplication, meaning that:
	* ***&sdot;*** is associative
	* ***1*** is the multiplicative identity
3. Multiplication is distributive with respect to addition, meaning that:
	* ***a ⋅ (b + c) = (a · b) + (a · c) for all a, b, c in R*** (left distributivity)
	* ***(b + c) · a = (b · a) + (c · a) for all a, b, c in R*** (right distributivity)
	

###### Examples
 
* (integer, +, &sdot;)






[abstract-algebra]: https://en.wikipedia.org/wiki/Abstract_algebra
[algebraic-structure]: https://en.wikipedia.org/wiki/Algebraic_structure
[scalacheck]: http://www.scalacheck.org/
[ring]: https://en.wikipedia.org/wiki/Ring_(mathematics)
[abelian-group]: https://en.wikipedia.org/wiki/Abelian_group
[magma]: https://en.wikipedia.org/wiki/Magma_(algebra)
[semigroup]: https://en.wikipedia.org/wiki/Semigroup
[monoid]: https://en.wikipedia.org/wiki/Monoid
[quasigroup]: https://en.wikipedia.org/wiki/Quasigroup
[magma-ethymology]: https://english.stackexchange.com/questions/63210/etymology-of-magma-in-abstract-algebra
[magma-mathoverflow-term-origin]: https://mathoverflow.net/questions/103128/what-is-the-origin-of-the-term-magma
[magma-fr-dict]: https://www.larousse.fr/dictionnaires/francais/magma/48543