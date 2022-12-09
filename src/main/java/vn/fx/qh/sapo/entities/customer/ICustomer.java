package vn.fx.qh.sapo.entities.customer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public interface ICustomer {
    Long getID();
    String getCUSTOMER_CODE();
    String getNAME();
    String getADDRESS();
    String getPHONE();
    String getGENDER();
    String getBIRTHDAY();
    String getEmail();
    String getSTATUS();
    String getCUSTOMER_GROUP();
    Instant getCREATE_AT();
    Instant getUPDATE_AT();
    BigDecimal getTOTAL_PRICE_SPENDING();
    BigDecimal getORDER_DEBT();
    int getQUANTITY_ITEMS_ORDER();
    String getEMPLOYEE_NAME();
    Instant getPRODUCT_ORDER_FINAL();
    int getQUANTITY_PRODUCT_ORDER();
    int getQUANTITY_PRODUCT_PAY();
    Instant getDAY_ORDER_LATTER();
}