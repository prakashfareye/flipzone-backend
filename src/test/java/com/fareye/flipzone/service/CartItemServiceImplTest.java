package com.fareye.flipzone.service;

import com.fareye.flipzone.dto.*;
import com.fareye.flipzone.model.*;
import com.fareye.flipzone.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartItemServiceImplTest {

    @Mock
    private CartItemRepository cartItemRepository;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    CartItemServiceImpl cartItemService;
    @InjectMocks
    ProductServiceImpl productService;

    private CartItem cartItem;
    private Product product;

    final Long id = 1L;
    final Long productId = 2L;
    final Long userId = 3L;
    final Long cartId = 4L;
    final Long catId = 5L;
    final Long orderId = 6L;


    @BeforeEach
    void setUp() {
        cartItem = CartItem.builder()
                .cartItemId(id)
                .cartItemPrice(2)
                .cartItemQuantity(5)
                .productId(productId)
                .cartId(cartId)
                .userId(userId)
                .orderId(orderId)
                .build();

        product = Product.builder()
                .brand("brand")
                .productDescription("desc")
                .productImageURL("image_url")
                .categoryId(catId)
                .productPrice(10)
                .productName("name")
                .productQuantity(10)
                .productId(productId)
                .userId(userId.intValue())
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Junit For add Cart Item")
    @Test
    void addCartItem() {
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);
        assertEquals(cartItem, cartItemService.addCartItem(cartItem));
    }

    @Test
    void getCartItems() {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        when(cartItemRepository.findAll()).thenReturn(cartItems);
        assertEquals(1, cartItemService.getCartItems().size());
    }

    @Test
    void getCartItemByUserId() {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        when(productRepository.findById(productId)).thenReturn(Optional.ofNullable(product));
        when(cartItemRepository.findByUserId(userId)).thenReturn(cartItems);
        assertEquals(1, cartItemService.getCartItemByUserId(userId).size());
    }

    @Test
    void deleteCartItemByUserId() {
        cartItemService.deleteCartItemByUserId(userId);
        verify(cartItemRepository, times(1)).deleteByUserId(userId);
    }

    @Test
    void deleteCartItemByOrderId() {
    }

    @Test
    void getCartItemByOrderId() {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        when(cartItemRepository.findByOrderId(orderId)).thenReturn(cartItems);
        assertEquals(1, cartItemService.getCartItemByOrderId(orderId).size());
    }

    @Test
    void getCartItemByCartId() {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        when(cartItemRepository.findByCartId(cartId)).thenReturn(cartItems);
        assertEquals(1, cartItemService.getCartItemByCartId(cartId).size());
    }

    @Test
    void getCartItemByProductId() {
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        when(cartItemRepository.findByProductIdAndUserId(productId, userId)).thenReturn(cartItems);
        assertEquals(1, cartItemService.getCartItemByProductId(productId, userId).size());
    }

    @Test
    void getCartItemByCartItemtId() {
    }

    @Test
    void updateCartItem() {
        Integer quantity = cartItem.getCartItemQuantity();
        when(cartItemRepository.save(cartItem)).thenReturn(cartItem);
        assertEquals(quantity + 1, cartItemService.updateCartItem(id, cartItem, 1).getCartItemQuantity());
    }

    @Test
    void deleteCartItemByCartItemId() {
        when(cartItemRepository.findById(id)).thenReturn(Optional.ofNullable(cartItem));
        cartItemService.deleteCartItemByCartItemId(id);
        verify(cartItemRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteCartItemsByUserId() {
        cartItemService.deleteCartItemByUserId(userId);
        verify(cartItemRepository, times(1)).deleteByUserId(userId);
    }
}