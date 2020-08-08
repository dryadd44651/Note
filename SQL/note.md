# Second Highest Salary
```
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
;
```
# Combine Two Tables
```
select FirstName, LastName, City, State
    from Person left join Address
    on Person.PersonId = Address.PersonId;
```
#
```

```
#
```

```
#
```

```
#
```

```
#
```

```
#
```

```
