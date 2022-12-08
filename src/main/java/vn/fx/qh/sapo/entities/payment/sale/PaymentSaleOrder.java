package vn.fx.qh.sapo.entities.payment.sale;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.customer.Customer;
import vn.fx.qh.sapo.entities.employee.Employee;
import vn.fx.qh.sapo.entities.order.sale.SaleOrder;
import vn.fx.qh.sapo.entities.payment.PaymentMethod;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "payment_sale_order")
public class PaymentSaleOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "paid", nullable = false, precision = 10, scale = 2)
    private BigDecimal paid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "employee_id", insertable = false, updatable = false)
    private Integer employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "payment_method_id", insertable = false, updatable = false)
    private Integer paymentMethodId;

    @Column(name = "create_at", nullable = false, length = 50)
    private String createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private SaleOrder order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    public PaymentSaleOrder setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public PaymentSaleOrder setCustomerId(Integer customerId) {
        this.customer = new Customer(this.customerId = customerId);
        return this;
    }

    public PaymentSaleOrder setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethod = new PaymentMethod(this.paymentMethodId = paymentMethodId);
        return this;
    }

    public PaymentSaleOrder setOrderId(Integer orderId) {
        this.order = new SaleOrder(this.orderId = orderId);
        return this;
    }

    public PaymentSaleOrder(Integer employeeId, Integer paymentMethodId, Integer orderId, Integer customerId) {
        setEmployeeId(employeeId);
        setPaymentMethodId(paymentMethodId);
        setOrderId(paymentMethodId);
        setCustomerId(customerId);
    }
}
