# Second Highest Salary


SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
;


# Combine Two Tables


select FirstName, LastName, City, State
    from Person left join Address
    on Person.PersonId = Address.PersonId;


# Employees Earning More Than Their Managers


# from a,b = a join b
# use where as if
SELECT
    a.Name AS 'Employee'
FROM
    Employee AS a,
    Employee AS b
WHERE
    a.ManagerId = b.Id
        AND a.Salary > b.Salary
;




# use join on as if
SELECT
     a.NAME AS Employee
FROM Employee AS a JOIN Employee AS b
     ON a.ManagerId = b.Id
     AND a.Salary > b.Salary
;


# Reformat Department Table


Department table:
+------+---------+-------+
| id   | revenue | month |
+------+---------+-------+
| 1    | 8000    | Jan   |
| 2    | 9000    | Jan   |
| 3    | 10000   | Feb   |
| 1    | 7000    | Feb   |
| 1    | 6000    | Mar   |
+------+---------+-------+

Result table:
+------+-------------+-------------+-------------+-----+-------------+
| id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
+------+-------------+-------------+-------------+-----+-------------+
| 1    | 8000        | 7000        | 6000        | ... | null        |
| 2    | 9000        | null        | null        | ... | null        |
| 3    | null        | 10000       | null        | ... | null        |
+------+-------------+-------------+-------------+-----+-------------+




# use group by with sum()
select id, 
	sum(case when month = 'jan' then revenue else null end) as Jan_Revenue,
	sum(case when month = 'feb' then revenue else null end) as Feb_Revenue,
	sum(case when month = 'mar' then revenue else null end) as Mar_Revenue,
	sum(case when month = 'apr' then revenue else null end) as Apr_Revenue,
	sum(case when month = 'may' then revenue else null end) as May_Revenue,
	sum(case when month = 'jun' then revenue else null end) as Jun_Revenue,
	sum(case when month = 'jul' then revenue else null end) as Jul_Revenue,
	sum(case when month = 'aug' then revenue else null end) as Aug_Revenue,
	sum(case when month = 'sep' then revenue else null end) as Sep_Revenue,
	sum(case when month = 'oct' then revenue else null end) as Oct_Revenue,
	sum(case when month = 'nov' then revenue else null end) as Nov_Revenue,
	sum(case when month = 'dec' then revenue else null end) as Dec_Revenue
from department
group by id
order by id


# Customers Who Never Order


Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+




# Customers Who Order
select Name from Customers join Orders on Orders.CustomerId = Customers.Id 
//Customers Who Never Order
select customers.name as 'Customers'
from customers
where customers.id not in
(
    select customerid from orders
);


# Duplicate Emails


//use group by having count() (having = if)
select Email
from Person
group by Email
having count(Email) > 1;


# Delete Duplicate Emails


# full join p1,p2 select by condition
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id


# Rising Temperature


#Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
#The DATEDIFF() function returns a value of integer indicating the difference between the start_date and end_date 
SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.RecordDate, w.RecordDate) = 1
    AND weather.Temperature > w.Temperature
;


# Consecutive Available Seats


select distinct a.seat_id
from cinema a join cinema b
  on abs(a.seat_id - b.seat_id) = 1
  and a.free = true and b.free = true
order by a.seat_id
;


# Friend Requests I: Overall Acceptance Rate


#distinct(sender_id | send_to_id) and distinct(requester_id | accepter_id ) 
#request_accepted/friend_request
select
round(
    ifnull(
    (select count(*) from (select distinct requester_id, accepter_id from request_accepted) as A)
    /
    (select count(*) from (select distinct sender_id, send_to_id from friend_request) as B),
    0)
, 2) as accept_rate;


# Students With Invalid Departments


# find id not in table Departments
select s.id,s.name from Students s
    where department_id  not in 
    (select id from Departments )
;


# Triangle Judgement


| x  | y  | z  |
|----|----|----|
| 13 | 15 | 30 |
| 10 | 20 | 15 |
For the sample data above, your query should return the follow result:
| x  | y  | z  | triangle |
|----|----|----|----------|
| 13 | 15 | 30 | No       |
| 10 | 20 | 15 | Yes      |

SELECT 
    x,
    y,
    z,
    CASE
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No'
    END AS 'triangle'
FROM
    triangle
;


# Immediate Food Delivery I


select
round(ifnull(
    (select count(*) from Delivery where order_date = customer_pref_delivery_date )/
    (select count(*) from Delivery)*100,0
),2) as immediate_percentage ;

select round(100 * sum(order_date = customer_pref_delivery_date) / count(*), 2) as immediate_percentage from Delivery;


# Sales Analysis II


select s.buyer_id FROM Sales AS s INNER JOIN Product AS p ON s.product_id = p.product_id
GROUP BY s.buyer_id
having
SUM(CASE WHEN p.product_name = 'S8' THEN 1 ELSE 0 END) > 0
and
SUM(CASE WHEN p.product_name = 'iPhone' THEN 1 ELSE 0 END) = 0


# List the Products Ordered in a Period


select p.product_name,sum(o.unit) as UNIT from Orders as o inner join Products as p 
on o.product_id = p.product_id
where month(order_date) = 2 and year(order_date) = '2020'
#where Left(order_date, 7) = '2020-02'
group by o.product_id
having sum(o.unit) >= 100


# User Activity for the Past 30 Days II


select ifnull(round(sum(x)/count(x),2),0) as average_sessions_per_user from
(select count(DISTINCT  session_id ) as x from Activity
where activity_date >= '2019-06-28' and activity_date <= '2019-07-27'
group by user_id ) as t 


# Average Selling Price

select x.product_id, round(sum(x.price*x.units)/sum(x.units),2) as average_price from
(select p.product_id,p.price,u.units from
Prices as p join UnitsSold as u on p.product_id = u.product_id
and u.purchase_date between p.start_date and p.end_date) as x
group by product_id


# Swap Salary(Sex)

UPDATE salary SET sex = CASE sex WHEN 'm' THEN 'f' ELSE 'm' END;
#update salary set sex = IF (sex = "m", "f", "m");


# Find Customer Referee
#select name from customer where referee_id <> 2 OR referee_id IS NULL
select name from customer where referee_id != 2 OR referee_id IS NULL

# Actors and Directors Who Cooperated At Least Three Times
select actor_id, director_id from ActorDirector 
group by actor_id, director_id
having count(*)>=3

# Customer Placing the Largest Number of Orders

select customer_number from orders group by customer_number 
order by count(*) desc limit 1

# Find the Team Size

select e.employee_id,x.team_size from
Employee as e join
(select team_id,count(*) as team_size from Employee group by team_id) as x 
on e.team_id = x.team_id

# Classes More Than 5 Students
select class from
(select DISTINCT * from courses) as x
group by class having count(*)>=5

# Shortest Distance in a Line
select min(abs(p1.x-p2.x)) as shortest from 
point as p1 join point as p2 on p1.x != p2.x

# Biggest Single Number (only appears once)
select max(num) as num from
(select num from my_numbers group by num having count(*)=1) as x

# Patients With a Condition
select * from Sales where sale_date between '2019-01-01' and '2019-03-31'
	       
# Replace Employee ID With The Unique Identifier
select u.unique_id,e.name from Employees as e left join EmployeeUNI as u on e.id = u.id
	       
# Group Sold Products By The Date
# group_concat => item1,item2,item3...
select sell_date, count(distinct product) as num_sold , 
group_concat(distinct product order by product asc separator ',') as products               
from activities  
group by sell_date
order by sell_date
	       
# Product Sales Analysis I
select p.product_name,s.year,s.price 
from Sales s join Product p on s.product_id = p.product_id
# Friendly Movies Streamed Last Month
select distinct title from TVProgram t join Content c 
on t.content_id=c.content_id
where Kids_content = 'Y' and (t.program_date BETWEEN '2020-06-1' AND '2020-06-30')
and c.content_type = "Movies"
	       
#  All People Report to the Given Manager (Boss)
select e1.employee_id,e1.employee_name,e1.manager_id,e2.manager_id
from Employees e1 join Employees e2 on e1.manager_id = e2.employee_id
join Employees e3 on e2.manager_id = e3.employee_id
WHERE e3.manager_id = 1 AND e1.employee_id != 1

# Nth Highest Salary (sql function)
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M=N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary as getNthHighestSalary from Employee
      ORDER BY Salary DESC
      LIMIT 1 OFFSET M
  );
END
# Rank Scores
SELECT
  Score,
  (select count(*) from (select distinct Score as s from Scores) tmp where Score<=s) as 'Rank'
FROM
  Scores
ORDER BY Score desc

# Department Highest Salary
select  x.Name Department,e.Name Employee,e.Salary Salary from
Employee as e,
(select d.id, Max(e.Salary) as Salary,d.Name from 
Employee as e join Department as d on e.DepartmentId = d.id
group by e.DepartmentId) as x where x.Salary = e.Salary and x.id = e.DepartmentId

# Exchange Seats (COALESCE get val until exit)
select s1.id,COALESCE(s2.student, s1.student) student
from seat as s1 left join seat as s2 on s1.id = s2.id + mod(s2.id,2)*2-1 
order by s1.id asc

# Consecutive Numbers
select distinct l1.Num ConsecutiveNums from Logs as l1 
join Logs as l2 on l1.id=l2.id+1
join Logs as l3 on l2.id=l3.id+1
where l1.Num = l2.Num and l2.Num = l3.Num

# Team Scores in Football Tournament (good)
select t.team_id, t.team_name,
sum(if(t.team_id = m.host_team and host_goals>guest_goals,3,0)+
if(t.team_id = m.host_team and host_goals=guest_goals,1,0)+
if(t.team_id = m.guest_team and guest_goals>host_goals,3,0)+
if(t.team_id = m.guest_team and guest_goals=host_goals,1,0)) num_points
from Teams t left join Matches m
on t.team_id = m.host_team or t.team_id = m.guest_team
group by t.team_id
order by num_points desc, t.team_id ASC;

# Reported Posts II (good practice)

# get the averag daily percent
select round(sum(y.daily_percent)*100/count(y.daily_percent),2) as average_daily_percent 
    from
    #get the daily percent
    (select (sum(x.c)/count(x.c)) as daily_percent 
        from
        #distinct:remove duplicate
        #get only spam
        #check is removed or not (if(a.post_id = r.post_id,1,0))
        (select distinct a.action_date,a.post_id,if(a.post_id = r.post_id,1,0) as c
            from Actions as a
            left join Removals as r
            on a.post_id = r.post_id
            where a.extra = 'spam') x
     
group by x.action_date) as y

# Unpopular Books
select b.book_id,b.name 
    from
        (select book_id,name from Books where available_from<'2019-05-23') as b
    left join
        (select book_id,sum(quantity) as quantity from Orders 
        where dispatch_date between '2018-06-23' and '2019-06-23'
        group by book_id) as o
    on b.book_id=o.book_id
    where o.quantity<10 or o.quantity is null

# Capital Gain/Loss
select stock_name,sum(if(operation='Buy',-price,price)) capital_gain_loss
from Stocks as s
group by stock_name
			 
# Average Salary: Departments VS Company
select dep.pay_month,dep.department_id,
    case 
        when dep.amount>com.average then 'higher'
        when dep.amount<com.average then 'lower'
        else 'same'
        end comparison
    from
        (select date_format(s.pay_date, '%Y-%m') pay_month,e.department_id,avg(s.amount) amount
        from salary s join employee e on s.employee_id=e.employee_id
        group by e.department_id,pay_month) dep
    left join
        (select avg(amount) average, date_format(s.pay_date, '%Y-%m') pay_month 
         from salary s group by date_format(s.pay_date, '%Y-%m')) com
    on dep.pay_month = com.pay_month

# Trips and Users
select request_at as Day,
       round(sum(case when status = 'completed' then 0 else 1 end)/count(id),2) as "Cancellation Rate"
from trips t

inner join users c
    on c.users_id = t.client_id
    and c.banned = 'No'
    and c.role = 'client'
inner join users d
    on d.users_id = t.driver_id
    and d.banned = 'No'
    and d.role = 'driver'
where (t.Request_at between '2013-10-01' and '2013-10-03')
group by t.request_at

# Department Top Three Salaries (select in where)
select d.name Department,e.name Employee,e.Salary Salary
from Employee e join Department d
	on e.DepartmentId=d.id
	where 3>
		(select count(distinct salary) from Employee e1
		where e1.salary>e.salary
		and e.DepartmentId = e1.DepartmentId)
