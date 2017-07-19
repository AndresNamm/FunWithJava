# Heap

+ [Interesting Problem](http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/)
+ [Heap Overall Has multiple Subcategorys. We are talking about Binary Heap](https://en.wikipedia.org/wiki/Heap_(data_structure)
+ [Binary Heap Theory](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html)


## Some Characteristics 
 

1 **Heap Is in the form of a binary tree**

2 **N-th level in heap has $2^{n-1} elements$**

3 **N-th level in heap has the one more element than all previous levels summed up _Binary Number Characteristic_ **  <-    $2^{n}=\sum_{i=0}^{n-1}{2^{i}}+1$ 

_Proof by induction_

+ This is correct when n=3 

+ Lets Perform the induction step with n+1



Left side: $2^{n+1} = 2^{n} + 2^{n}$

Right side $=\sum_{i=0}^{n}{2^{i}}+1 =  2^{n} + \sum_{i=0}^{n-1}{2^{i}}+1$

$2^{n} + 2^{n} = 2^{n} + \sum_{i=0}^{n-1}{2^{i}}+1$ <- Left Side = Right Side


4 **N-th levels last element in heap is the $2^{n}-1$ -th element** 
5 **j-th element in heap is in the floor(log(j))+1 level**