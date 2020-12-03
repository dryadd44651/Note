what is transaction

https://medium.com/@chester.yw.chu/%E8%A4%87%E7%BF%92%E8%B3%87%E6%96%99%E5%BA%AB%E7%9A%84-isolation-level-%E8%88%87%E5%B8%B8%E8%A6%8B%E7%9A%84%E4%BA%94%E5%80%8B-race-conditions-%E5%9C%96%E8%A7%A3-16e8d472a25c

ACID
atomicity    
consistency  
isolation level
durability  

Oracle (RC, S, Read only)
MYSQL
isolation level
                    Dirty Read       Non-Repeatable Read      Phantom Read
Read Uncommitted       X                    X                       X
Read Committed                              X                       X
Repeatable Read                                                     X
Serializable
   
Read Uncommitted
User1       tx          select(10)                   select(20)
timeline ------------------------------------------------------
User2           tx                   insert(10)                     rollback


Read Committed
User1       tx          select(10)        ==          select(10)
timeline ------------------------------------------------------
User2           tx                   insert(10)                     rollback


Read Committed (Non-RR)
User1       tx      select(10)           !=               select
timeline ------------------------------------------------------
User2           tx        update/delete(10)   commit


Read Committed (Phantom)
User1       tx      select(10)           !=               select(20)
timeline ------------------------------------------------------
User2           tx              insert(10)   commit


Repeatable Read
User1       tx      select(10)           ==               select(10)
timeline ------------------------------------------------------
User2           tx        update/delete(10)   commit


Repeatable Read (Phantom Read)
User1       tx      select(10)           !=               select(20)
timeline ------------------------------------------------------
User2           tx              insert(10)   commit



Serializable
User1       tx      select(10)           ==             select
timeline ------------------------------------------------------
User2           tx              u/d/insert   commit
-- employee earning more than manager

-- select emp.employee_id, emp.first_name, emp.last_name, emp.salary, manager.employee_id, manager.salary
-- from hr.employees emp join hr.employees manager on emp.manager_id = manager.employee_id
-- where emp.salary > manager.salary

-- departments top 3 salary,  display emp fn, ln, salary, dept info

--1.create rank with partition
-- select e.*,dense_rank() over (partition by e.department_id order by e.salary desc) as rank 
-- from hr.employees e
--2. join department
-- select d.department_name, e.first_name, e.last_name, e.salary,
--     dense_rank() over (partition by e.department_id order by e.salary desc) as rank 
--     from hr.employees e join hr.departments d on e.department_id = d.department_id
--3. where the condition
-- select *
-- from  (select d.department_name, e.first_name, e.last_name, e.salary,
--       dense_rank() over (partition by e.department_id order by salary desc) as rank
--       from hr.employees e join hr.departments d on e.department_id = d.department_id)
-- where rank <= 3



-- departments total salary larger than 20k, dept_id, dept_name
--1.goup by and get the sum
-- select e.DEPARTMENT_ID,sum(e.SALARY)
--       from hr.employees e group by e.DEPARTMENT_ID

--2.join and get the dept name
-- must put all columns of the SELECT in the GROUP BY
-- select d.department_id, d.department_name, sum(salary) as sum
--       from hr.employees e join hr.departments d on e

--3. having get the sum>20000
-- select d.department_id, d.department_name, sum(salary) as sum
-- from hr.employees e join hr.departments d on e.department_id = d.department_id
-- group by d.department_id, d.department_name
-- having sum(salary) > 20000


-- display department name and number of employees, dept_name, count


-- select d.department_name as dept_name, count(salary) as count
-- from hr.employees e right join hr.departments d on e.department_id = d.department_id
-- group by d.department_id, d.department_name



-- hr.employees
-- hr.departments

-- A join B on A.b_id = B.id join C on ..
-- where salary > 5000 or  

-- from A, B, C, D
-- where A.b_id = B.id and b.c_id = c.id and c.d_id = d.id
--       and (salary > 5000 or  )

-- join, inner join / cross join / outer join
-- execution plan
-- select
-- from A, B, C, D, E
-- where (A.b_id = B.id..) and

-- cross join
-- A   B
-- 1   4
-- 2   5
-- 3

-- A, B
-- 1, 4
-- 1, 5
-- 2, 4
-- 2, 5
-- 3, 4
-- 3, 5
-- A join B on A.b_id = B.id

-- select count(*)
-- from (select e1.first_name, e1.last_name, d1.department_name
-- from hr.employees e1 left join hr.departments d1 on e1.department_id = d1.department_id)

-- select e1.first_name, e1.last_name, d1.department_name
-- from hr.employees e1 left join hr.departments d1 on e1.department_id = d1.department_id
-- where department_name is null
