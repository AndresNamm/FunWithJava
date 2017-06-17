Any form of sorting is going to be at least O(n * log n), so we need to think outside of sorting.
Now, first try to think if you were already given the minimum value MIN and maximum value MAX in the array of size N, under what circumstances would the max gap be minimum and maximum ?

Obviously, maximum gap will be maximum when all elements are either MIN or MAX making maxgap = MAX - MIN.

Maximum gap will be minimum when all the elements are equally spaced apart between MIN and MAX. Lets say the spacing between them is gap.

So, they are arranged as

MIN, MIN + gap, MIN + 2*gap, MIN + 3*gap, ... MIN + (N-1)*gap 

where

MIN + (N-1)*gap = MAX 
=> gap = (MAX - MIN) / (N - 1). 

So, we know now that our answer will lie in the range [gap, MAX - MIN].
Now, if we know the answer is more than gap, what we do is create buckets of size gap for ranges

  [MIN, MIN + gap), [Min + gap, `MIN` + 2* gap) ... and so on

There will only be (N-1) such buckets. We place the numbers in these buckets based on their value.

If you pick any 2 numbers from a single bucket, their difference will be less than gap, and hence they would never contribute to maxgap ( Remember maxgap >= gap ). We only need to store the largest number and the smallest number in each bucket, and we only look at the numbers across bucket.

Now, we just need to go through the bucket sequentially ( they are already sorted by value ), and get the difference of min_value with max_value of previous bucket with at least one value. We take maximum of all such values.
