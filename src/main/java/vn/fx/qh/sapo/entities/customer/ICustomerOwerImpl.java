package vn.fx.qh.sapo.entities.customer;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ICustomerOwerImpl {
    private String order_code;

    private String employee_name;

    private Instant create_at;

    private BigDecimal transaction;


    private  BigDecimal total_transaction;

    private  String description;


    public void setFromICustomerOwer(ICustomerOwer iCustomerOwer) {
        this.order_code = iCustomerOwer.getORDER_CODE();
        this.employee_name = iCustomerOwer.getEMPLOYEE_NAME();
        this.create_at = iCustomerOwer.getCREATEAT();
        this.transaction = iCustomerOwer.getTRANSACTION();
        this.total_transaction = iCustomerOwer.getTOTALTRANSACTION();
        this.description = iCustomerOwer.getDescription();
    }


}

