-- Normalization (1st / 2nd / 3rd)

-- 1st
-- id,   name              id,  first_name,  last_name
-- 1 ,  Alice, Z    ->    
-- 2 ,  K,  F

-- 2nd(1st)

-- (book_id,  author_id),  book_name,  author_name
--   A1        100        JAVA         Li
--   A1        101        JAVA         ALEX
--   A2        100        C#           ALICE
 
--  book_id -> book_name
--  book_id X-> author_name
--  author_id -> author_name
--  author_id X-> book_name
 
-- 3rd(2nd, 1st)
 
--  id,  first_name, last_name,  address_id, street, zipcode
 
--  id -> address_id -> street / zipcode
 
 
-- Table design
-- 1 - 1 / 1 - m / m - m / entity - attribute
-- 1 - 1
-- user            userdetail
-- id(PK)                id(PK)
--                  user_id(FK)
-- 1 - m
-- user (id, ..)
-- order_detail(id,  user_id(FK))

-- m - m
-- book  m - m  author
-- book(book_id)      
-- book_author(id, book_id(fk), author_id(fk))
-- author(author_id)

-- entity attribute

-- id,   doc_id,   key,   key_type,  value
--  1,    A1   ,  name,   string  ,   Tom
--  1,    A1   ,  phone,   number ,   123456
--  2,    A2   ,  ...


-- Assume we are working on a university system that tracks students in the university.
-- For each student, we want to store basic information (ID, first & last name, current GPA).
-- And, for each student we also want to store each class the student has taken.
-- For each class taken, we want to track the class number (e.g. MATH101),
-- semester taken (e.g. FALL2018)
-- and grade received (A, A-, B etc.).
                 
-- student(id, fn, ln, GPA)
-- stu_class(id, stu_id, class_num, semester, grade)
-- class(number)

-- student(id, fn, ln, GPA)
-- stu_class(id, stu_id, class_id, grade)
-- class(id, number, semester)



select
    aggregation
    subquery
    group by / having
    union..
    join
transaction (ACID)
    mysql(RU, RC, RR, S)
    oracle(RC, S, RO)
index
    B+ tree / bitmap
    index organized table
normalization
    1st / 2nd / 3rd
    1 - 1 / 1 - m / m - m
   
   
   
id, address_id,  zipcode
id -> addiress_id -> zipcode
