


import java.io.Serializable;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
 
@Entity(name = "SubscriptionEntity")
@Table(name = "SUBSCRIPTION", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
 
public class SubscriptionEntity 
{
    @Id
	@GenericGenerator(strategy="increment",name="inc")
	@GeneratedValue(generator="inc")
    @Column(name = "ID", unique = true, nullable = false)
    Integer subscriptionId;
 
    @Column(name = "SUBS_NAME", unique = true, nullable = false, length = 100)
    String subscriptionName;
     
    @ManyToMany(mappedBy="subscriptions")
    Set<ReaderEntity> readers;
 
    //Getters and setters
}