package vn.fx.qh.sapo.entities.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import vn.fx.qh.sapo.entities.employee.Employee;

import javax.persistence.*;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
@Accessors(chain = true)
public class Customer {

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "customer_code", nullable = false, length = 50)
    private String customerCode;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "customer_group", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerGroup customerGroup;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "birthday", nullable = false, length = 50)
    private String birthday;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerGender customerGender;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, length = 50)
    private Instant createAt;

    @Column(name = "update_at", nullable = false, length = 50)
    private Instant updateAt;

    @OneToMany(targetEntity = ShippingAddress.class, mappedBy = "customer")
    private Set<ShippingAddress> shippingAddressSet;

    public ShippingAddress getShippingAddress() {
        Optional<ShippingAddress> opt = shippingAddressSet.stream()
                .filter(ShippingAddress::isShippingAddress)
                .findFirst();
        return opt.orElse(null);
    }

    public ShippingAddress getReceiveBillAddress() {
        Optional<ShippingAddress> opt = shippingAddressSet.stream()
                .filter(ShippingAddress::isReceiveBill)
                .findFirst();
        return opt.orElse(null);
    }

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


}