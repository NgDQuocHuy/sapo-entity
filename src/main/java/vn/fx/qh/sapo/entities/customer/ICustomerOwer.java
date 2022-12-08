package vn.fx.qh.sapo.entities.customer;


import java.math.BigDecimal;

public interface ICustomerOwer {

    String getORDER_CODE();

    String getEMPLOYEE_NAME();

    String getCREATEAT();

    BigDecimal getTRANSACTION();

    BigDecimal getTOTALTRANSACTION();

    String getDescription();
}
