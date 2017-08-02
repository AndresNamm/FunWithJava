# Heap

+ [Interesting Problem](http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/)
+ [Heap Overall Has multiple Subcategorys. We are talking about Binary Heap](https://en.wikipedia.org/wiki/Heap_data_structure)
+ [Binary Heap Theory](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html)


## Some Characteristics 
 

1 **Heap Is in the form of a binary tree**

2 **N-th level in heap has $2^{n-1} elements$**

3 **N-th level in heap has one more element than all previous level elements summed up _Binary Number Characteristic_ **  <-    $2^{n}=\sum_{i=0}^{n-1}{2^{i}}+1$ 

_Proof by induction_

+ This is correct when n=3 

+ Lets Perform the induction step with n+1


Left side: $2^{n+1} = 2^{n} + 2^{n}$

Right side $=\sum_{i=0}^{n}{2^{i}}+1 =  2^{n} + \sum_{i=0}^{n-1}{2^{i}}+1$

$2^{n} + 2^{n} = 2^{n} + \sum_{i=0}^{n-1}{2^{i}}+1$ <- Left Side = Right Side


4 **N-th levels last element in heap is the $2^{n}-1$ -th element** 
5 **j-th element in heap is in the floor(log(j)+1) level**.  $2^{n}-1$ -th element is at n-th 
6 **left child of j-th member is 2 * j-th position ins heap, right is 2*j+1**

**PROOF**
Last element in N-th level is $2^{n}-1$th element. In level N+1, it is $2^{n+1}-1$th element.
That means, when we go to from N-th level last element to

+ right child  $2*2^{n}-1+1=2^{n+1}-1$ <- Last element in N+1 level
+ left child $2^{n}-1=2^{n+1}-2$  <- Second to last element in N+1 level


First element in N-th level is $2^{n-1}$th element. In level N+1, it is $2^{n}$th element.

+ right $2*2^{n-1}+1=2^{n}+1$ <-Second to First element in n+1 level
+ left $2*2^{n-1}=2^{n}$ <- First element in n+1 level


If we go to second to last element in N-th level, it childs

+ right child  $2*2^{n}-2 +1=2^{n+1}-3$ <- 3. from last element in N+1 level
+ left child $2^{n}-2=2^{n+1}-4$  <- 4. from last to last element in N+1 level




