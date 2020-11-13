[1;33mdiff --git a/src/main/scala/com/exercise/BasicAlgebraicOperations.scala b/src/main/scala/com/exercise/BasicAlgebraicOperations.scala[m
[1;33mindex a8fe06f..94d3740 100644[m
[1;33m--- a/src/main/scala/com/exercise/BasicAlgebraicOperations.scala[m
[1;33m+++ b/src/main/scala/com/exercise/BasicAlgebraicOperations.scala[m
[1;35m@@ -2,7 +2,7 @@[m [mpackage com.exercise[m
 [m
 object BasicAlgebraicOperations {[m
 [m
[1;31m-  def add(a: Int, b: Int): Int = {[m
[1;32m+[m[1;32m  def add(a: BigInt, b: BigInt): BigInt = {[m
     a + b[m
   }[m
 }[m
\ No newline at end of file[m
[1;33mdiff --git a/src/test/scala/com/exercise/BasicAlgebraicOperationsSpec.scala b/src/test/scala/com/exercise/BasicAlgebraicOperationsSpec.scala[m
[1;33mindex 815a36c..3f4c99e 100644[m
[1;33m--- a/src/test/scala/com/exercise/BasicAlgebraicOperationsSpec.scala[m
[1;33m+++ b/src/test/scala/com/exercise/BasicAlgebraicOperationsSpec.scala[m
[1;35m@@ -2,29 +2,35 @@[m [mpackage com.exercise[m
 [m
 import com.exercise.BasicAlgebraicOperations.add[m
 import org.scalacheck.Prop.forAll[m
[1;31m-import org.scalacheck.Properties[m
[1;32m+[m[1;32mimport org.scalacheck.{Gen, Properties}[m
 [m
 object BasicAlgebraicOperationsSpec extends Properties("Basic algebraic operations") {[m
 [m
[1;31m-  val addNeutralElem = 0[m
[1;32m+[m[1;32m  private val addNeutralElem = 0[m
[1;32m+[m[1;32m  private val posBigInt = Gen.choose(0, Long.MaxValue).map { n: Long => BigInt(n) }[m
[1;32m+[m[1;32m  private val negBigInt = Gen.choose(Long.MinValue, 0).map { n: Long => BigInt(n)}[m
 [m
[1;31m-  property("add generates correct result") = forAll { (a: Int, b: Int) =>[m
[1;31m-    add(a, b) == a + b[m
[1;32m+[m[1;32m  property("add is total for positive portion of domain") = forAll(posBigInt) { (a: BigInt) =>[m
[1;32m+[m[1;32m      add(a, a) >= 0[m
   }[m
 [m
[1;31m-  property("add is associative") = forAll { (a: Int, b: Int, c: Int) =>[m
[1;32m+[m[1;32m  property("add is total for negative portion of domain") = forAll(negBigInt) { (a: BigInt) =>[m
[1;32m+[m[1;32m    add(a, a) <= 0[m
[1;32m+[m[1;32m  }[m
[1;32m+[m
[1;32m+[m[1;32m  property("add is associative") = forAll { (a: BigInt, b: BigInt, c: BigInt) =>[m
     add(add(a, b), c) == add(a, add(b, c))[m
   }[m
 [m
[1;31m-  property("add has neutral (aka identity) element") = forAll { (a: Int) =>[m
[1;32m+[m[1;32m  property("add has neutral (aka identity) element") = forAll { (a: BigInt) =>[m
     add(a, addNeutralElem) == a && add(addNeutralElem, a) == a[m
   }[m
 [m
[1;31m-  property("add has inverse element") = forAll { (a: Int) =>[m
[1;32m+[m[1;32m  property("add has inverse element") = forAll { (a: BigInt) =>[m
     add(a, -a) == addNeutralElem && add(-a, a) == addNeutralElem[m
   }[m
 [m
[1;31m-  property("add is commutative") = forAll { (a: Int, b: Int) =>[m
[1;32m+[m[1;32m  property("add is commutative") = forAll { (a: BigInt, b: BigInt) =>[m
     add(a, b) == add(b, a)[m
   }[m
 }[m
