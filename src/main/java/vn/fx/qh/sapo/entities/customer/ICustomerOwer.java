package vn.fx.qh.sapo.entities.customer;


import java.math.BigDecimal;
import java.time.Instant;

public interface ICustomerOwer {

    String getORDER_CODE();

    String getEMPLOYEE_NAME();

    Instant getCREATEAT();

    BigDecimal getTRANSACTION();

    BigDecimal getTOTALTRANSACTION();

    String getDescription();
}
