# variance vs bias
high variance: the result is very different (Overfitting)

high bias: accuracy is low (Underfitting)

simple model: high Bias, low Variance
improve by increase iteration, more features(dimension), increasing model complexity, regularization

complex model: low Bias, high Variance
Early Stopping, more data, reduce features, reducing model complexity, regularization

# solution
Bagging to decrease the model’s variance.

Boosting to decreasing the model’s bias.

Stacking to increasing the predictive force of the classifier.
## Bagging
The models should be homogeneous
Reduce the Variance
Divid sample to M[n] (Dividing is option)
Train n models
Take the average result of n models

Random Forest = Decision Tree + Bagging

## Boosting
The models should be weak models and homogeneous.
combine weak models with weight.


## Stacking 
The models should be heterogeneous.
Combine several base models with a final layer model.
EX: KNN, DTree are base model and are first layer.
Output of KNN, DTree would be input of logical regression(final layer).

