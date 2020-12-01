### Subquery
```
select * from 
    (select t.*,dense_rank() over (order by salary desc) as rank
    from hr.employees t) e
    where e.rank =2
    order by employee_id desc, first_name, last_name desc
```
