# Bucketing numbers 0..n into k buckets

**Definition**

Is dividing a list of numbers from 0..n into  k<n groups. For example, we might have an array with numbers 0..n, which we want to divide into k buckets. How can we do that?


1. $\frac{i}{n}$ or  $\frac{i}{n+1}$=> max result = 1 or close to 1 if we divide by n+1
2. multiply the result with k => max result = k or close to k if we divide by n+1

Alltogether this procedure is: $\frac{i}{n}* k$ or $\frac{i}{n+1}* k$


**How to apply this Result in reality?**

There are actually multiple ways to perform such a mapping.
The end result differs from mathematical ideal, because:

1. If we want to have k buckets in an array we need to map each number from 0..n to 0..k-1
.That means the maximum position in our new array has to be k-1 and minimum position has to be 0. **Max position k-1. To do that, I divide by n+1**
2. With array mapping the distribution of numbers among k buckets has to be hard (for each number we can choose only 1 index in the resulting array.) This however leads to having to make a decision between rounding the numbers up or down. **Rounding numbers down**
3. The difference between sequential numbers is constant $\frac{i+1}{n+1}k=\frac{i}{n+1}k+\frac{1}{n+1}k$ ; **The number added $\frac{1}{n}k=c$ stays the same**
4. The division: n/k is not always an exact result. This is because the mapping output grows constantly (mentioned in the previous point). As the step size might not divide exactly by 1, we might have an offset. This leads to having an unequal distribution because we use hard grouping to buckets based on floor(i) function(rounding down always). **EX: With n=22, divisor=23,K=5, the bucket histogram looks like this: 5,5,4,5,4 - Randomly, unequally distributed**
5.  _ASSUMPTION: We start the input range from 0. Else this condition does not work and 1 buckets has $floor(\frac{n}{k} elements)$_ . In the first bucket the result offset starts from 0. This means $\frac{i}{n+1}k>=1, i>=\frac{n+1}{k}$. where $\frac{n+1}{k}=$ average amount of elements in 1 bucket. **The number of elements in 0 indexed bucket is always maximum number a bucket can have**
6. There are no buckets which have less elements than floor($\frac{n+1}{k}$) **proof** If there are buckets which have  ceil($\frac{n+1}{k}$) elements, then the range for every else bucket can only be d<$\frac{1}{n+1}k$ step smaller which means there is still plenty of room for floor($\frac{n}{k}$) buckets.   **Question , Is it possible that there are some buckets which have less numbers than
floor($\frac{n}{k}$)? NO**
