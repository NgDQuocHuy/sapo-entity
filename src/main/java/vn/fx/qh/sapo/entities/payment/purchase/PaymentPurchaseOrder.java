package vn.fx.qh.sapo.entities.payment.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.employee.Employee;
import vn.fx.qh.sapo.entities.order.purchase.PurchaseOrder;
import vn.fx.qh.sapo.entities.payment.PaymentMethod;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "payment_purchase_order")
public class PaymentPurchaseOrder {

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
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @Column(name = "purchase_order_id", insertable = false, updatable = false)
    private Integer purchaseOrderId;

    public PaymentPurchaseOrder(Integer id) {
        this.id = id;
    }

    public PaymentPurchaseOrder setEmployeeId(Integer employeeId) {
        this.employee = new Employee(this.employeeId = employeeId);
        return this;
    }

    public PaymentPurchaseOrder setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethod = new PaymentMethod(this.paymentMethodId = paymentMethodId);
        return this;
    }

    public PaymentPurchaseOrder setPurchaseOrderId(Integer paymentMethodId) {
        this.purchaseOrder = new PurchaseOrder(this.purchaseOrderId = paymentMethodId);
        return this;
    }

    public PaymentPurchaseOrder(Integer employeeId, Integer paymentMethodId, Integer purchaseOrderId) {
        setEmployeeId(employeeId);
        setPaymentMethodId(paymentMethodId);
        setPurchaseOrderId(paymentMethodId);
    }
}