## Normalization

1NF multivalued in one column, identical row 

2NF if a column is dependent on the prime key, separate table 

3NF if a column is dependent on another column, separate table

BCNF table [a,b,c,d]  a,b->c,d  c,d->b  => talbe [a,c,d] pk(acd) table [b,c,d] pk(cd) c,d->b 
