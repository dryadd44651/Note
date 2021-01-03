


import java.io.Serializable;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
 
@Entity(name = "ReaderEntity")
@Table(name = "READER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL") })
 
public class ReaderEntity 
{
 
    @Id
	@GenericGenerator(strategy="increment",name="inc")
	@GeneratedValue(generator="inc")
    @Column(name = "ID", unique = true, nullable = false)
    Integer readerId;
 
    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    String email;
 
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    String firstName;
 
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    String lastName;
 
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="READER_SUBSCRIPTIONS", joinColumns={@JoinColumn(referencedColumnName="ID")}
                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="ID")})  
    Set<SubscriptionEntity> subscriptions;
 
    //Getters and setters
}