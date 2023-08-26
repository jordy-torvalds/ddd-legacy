package kitchenpos.fixture;

import kitchenpos.domain.Product;

import java.math.BigDecimal;

public class ProductFixture {

    private static final String DEFAULT_NAME = "기본 상품 이름";

    private ProductFixture() {
    }

    public static Product create(BigDecimal price) {
        return create(DEFAULT_NAME, price);
    }

    public static Product create(String name, BigDecimal price) {
        Product result = new Product();
        result.setName(name);
        result.setPrice(price);
        return result;
    }

}
