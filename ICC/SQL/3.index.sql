normalization 1st / 2nd / 3rd
table design 1 - 1 / 1 - m / m - m


--use explain to find out how SQL retrieve data
explain plan for
--(select /*+ full(e d) */ *)
select /*+ use_nl(e d) */ *
from hr.employees e join hr.departments d on e.department_id = d.department_id;
select * from table(dbms_xplan.display);


-- PL/SQL (function / stored procedure / trigger)
--cursor is a pointer to get data
-- implicit cursor (can't be changed like const)
-- explicit cursor (can be changed)

--create the PLSQL function
create or replace procedure findEmp1(emp_id in number) as
    cursor emp_cursor is select first_name,last_name from hr.employees where employee_id >= emp_id;
begin
    for emp in emp_cursor loop
        dbms_output.put_line(emp.first_name || ' ' || emp.last_name);
    end loop;
end;

begin
    findEmp1(100);
end;

create or replace procedure findEmp2(emp_id in number) as
    e_first_name hr.employees.first_name%type;
    e_last_name hr.employees.last_name%type;
    cursor emp_cursor is select first_name,last_name from hr.employees where employee_id >= emp_id;
begin
    open emp_cursor;
    fetch emp_cursor into e_first_name,e_last_name;
    dbms_output.put_line(e_first_name || ' ' || e_last_name);
    while emp_cursor%found loop
        fetch emp_cursor into e_first_name,e_last_name;
        dbms_output.put_line(e_first_name || ' ' || e_last_name);
    end loop;
    close emp_cursor;
    
end;



begin
    findEmp2(100);
end;



-- View

-- create view first_v as
-- select first_name, last_name from hr.employees


-- select * from first_v

-- select * from (select * from hr.employees)



-- non-cluster index (B+ tree index, bitmap index)


-- B tree

--              [25, 45, 60]
--           /    |    \    \
--     [10, 20] [40] [50] [70, 80]
   
   
-- B + tree

--              [25, 45, 60]
--             /    |    \         \
--     [10, 20]<->[25, 40]<->[45, 50]<->[60, 70, 80]
--      r1  r2     r3      ......
--                             |
--                             |---->    table
                           
                           
-- sex
-- F
-- M
-- F
-- M
-- M
-- M

-- Bitmap index
-- emp        
-- id,  sex      rowid  M   F
-- 1     M              1   0
-- 2     F              0   1
-- 3     M              1   0
-- 4     M              1   0
-- 5     F              0   1

--where sex='M'
--get 10110 => 1 3 4

-- emp        
-- id,  STATE     rowid  NJ  NY VA
-- 1     NJ              1   0  0
-- 2     NY              0   1  0
-- 3     NJ              1   0  0
-- 4     NY              1   0  0
-- 5     VA              0   0  1

-- where state = 'NJ' or 'NY'

-- NJ  10110
-- or
-- NY  01000
-- 11110 => 1 2 3 4

-- Index organized table



--               [25, 45, 60]
--             /    |    \         \
--     [10, 20]<->[25, 40]<->[45, 50]<->[60, 70, 80]
--      r1  r2     r3      
--      id
--      phone
--      name
--      address
     
     



-- (index cluster)
-- dept   name    
-- 100     IT
--     emp    dept_id
--     A101    100
--     A102    100
-- 101     Account
--     emp     dept_id
--     A103    101
   
-- execution plan
-- hint
-- statistics
-- select /*--index_ffs*/ * from table
