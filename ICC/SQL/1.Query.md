-- inner join
-- outer join(left / right / full)
-- cross join

-- Trasaction ACID
-- MYSQL isolation level(RU / RC / RR / S)
-- Oracle isolation level(RC / S / RO)

-- Pessimistic lock / Optimistic lock
-- Exclusive (write lock) / Share (read lock)

-- MVCC




-- --partition by
-- -- select *
-- -- from (select t.*, dense_rank() over (partition by department_id order by salary) as rank
-- -- from hr.employees t)
-- -- where rank = 2


-- --group by

-- -- select * from hr.employees

-- -- select department_id, count(employee_id)
-- -- from hr.employees
-- -- group by department_id
-- -- having count(employee_id) > 3

-- -- emp_id , dept_id
-- --   1       100
-- --   2       100
-- --   3       200
-- --   4       300
-- --   count
-- --   group by dept_id
-- --   group 1(100)  emp_id(1, 2)  -> 2
-- --   group 2(200)  emp_id(3)     -> 1
-- --   group 3(300)  emp_id(4)     -> 1


-- --union A + B / intersect common(A, B)/ minus  A - common(A, B) / except
-- -- select count(*)
-- -- from (select first_name from hr.employees
-- --       minus
-- --      select last_name from hr.employees)

-- -- select count(distinct(first_name))
-- -- from hr.employees

-- --rank() vs dense_rank()   asc / desc
-- -- select *
-- -- from  (select t.*, dense_rank() over (order by salary desc) as rank
-- --     from hr.employees t) e
-- -- where e.rank = 2
-- -- order by employee_id desc, first_name, last_name desc


-- --subquery
-- --2nd highest salary
-- -- select max(salary)
-- -- from hr.employees e1
-- -- where e1.salary < (select max(salary) from hr.employees)

-- --aggregation function (max / min / sum / avg / count(column) / count(*))

-- -- select count(*) from hr.employees


-- -- select count(salary) as num
-- -- from hr.employees


-- -- select min(salary) as min_salary
-- -- from hr.employees


-- -- select max(salary) as max_salary
-- -- from hr.employees

-- -- select last_name as ln, first_name as fn, salary
-- -- from hr.employees

-- -- day1 : query (select, intersect / union / minus)
-- -- day2 : join, trasaction(isolation level), lock(exclusive lock, share lock)
-- -- day3 : index(cluster-index / non-cluster index / index organized table, pl/sql(stored procedure / function / trigger / package)
-- -- day4 : table design + normalization, nosql / cassandra cluster


-- -- RDBMS : Oracle / MySQL / SQL Server / Postgre / RDS / Aurora
-- -- NOSQL : MongoDB(CP) / Cassandra(AP)
-- -- Cache : Redis(hash slot) / HazelCast (hash table) / H2, Derby
-- -- Object : S3 / S3 glacier
-- -- File  : EFS
