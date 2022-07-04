package hello.core.order;

public interface OrderService {
    // 1. 주문 생성 시 회원id, 상품명, 상품 가격을 넘깁니다.
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
