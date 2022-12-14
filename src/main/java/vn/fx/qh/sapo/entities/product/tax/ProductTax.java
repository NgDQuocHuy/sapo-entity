package vn.fx.qh.sapo.entities.product.tax;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Accessors(chain = true)
@Table(name = "product_tax")
public class ProductTax {
    @EmbeddedId
    private ProductTaxId id;
    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;
    @Column(name = "tax_id", insertable = false, updatable = false)
    private Integer taxId;
    @Enumerated(EnumType.STRING)
    @Column(name = "tax_type")
    private TaxType taxType;

    public Tax getTax() {
        return id.getTax();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductTax)) return false;
        ProductTax that = (ProductTax) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
