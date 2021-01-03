tomcat starts the server and calls servlet class. (only one object will be created)
servlet class provides doPost,doGet...
Programers needs to synchronize the servlet resource if need.

session: easy but not that safe, need sticky session in load balance env.
in load balance env, need session database, or sticky session.
session stickiness: use hash code or cookie to distribute the server loading

ORM is a concept
class table
field colum
object row

JPA is a specification
A Hibernate is a Java framework which implement ORM and JPA
Hibernate Fetch Type: lazy(load when use),Eager(pre load)
Cascade Type: can choose which operations cascade to related entities.
ex: A->B (A deleted->B deleted)
The referenced record can't be deleted.
In this case we can't delete B without delete A

Javac complie-> .class
A Java class file is a file containing Java bytecode that can be executed on the Java Virtual Machine (JVM).
Java run .class in JVM



