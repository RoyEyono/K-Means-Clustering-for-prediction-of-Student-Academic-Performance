# K-Means-Clustering-for-prediction-of-Student-Academic-Performance

Author: Roy Eyono

Inspired by Oyelade,Oladipupo and Obagbuwa's paper on the application of the k-Means Clustering algorithm for the prediction of Students’ Academic Performance, I decided to create a practical application of their paper on Java.

I approached the problem from a Software Engineering point of view and reused code previously written by unidentified coding enthusiasts(link below). These enthusiasts had written the implementation of the K-Means Clustering Algorithm, regardless of a few bugs in the code, it worked like a charm. I had to, however tailor it to solve the problem at hand. Due to the lack of data, I had to generate random data.

Basically, I setup a theoretical classroom with 100 students, with the marks coming in the form of percentiles. Each students takes a total of 5 subjects/modules, it is now up to the algorithm to group these students into five groups and rating them using this metric:

--------------------------------------
--------------------------------------
70 and above                Excellent
60-69                       Very Good
50-59                       Good
45-49                       Very Fair
40-45                       Fair
Below 45                    Poor 

--------------------------------------
--------------------------------------

The numbers represent the overall performance of each cluster, the formula to calculating the overall performance of a cluster can be found on the paper.

Link to the implementation of the K-Means Algorithm: http://www.dataonfocus.com/k-means-clustering-java-code/
Link to Oyelade,Oladipupo and Obagbuwa's paper: http://arxiv.org/ftp/arxiv/papers/1002/1002.2425.pdf

