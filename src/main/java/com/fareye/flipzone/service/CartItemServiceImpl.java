package com.fareye.flipzone.service;

import com.fareye.flipzone.dto.CartItemDto;
import com.fareye.flipzone.model.CartItem;
import com.fareye.flipzone.model.Product;
import com.fareye.flipzone.repository.CartItemRepository;
import com.fareye.flipzone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;
  //  @Override
    public CartItem addCartItem(CartItem cartitem) {

        return  cartItemRepository.save(cartitem);


    }
  //  @Override
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }
  //  @Override
    public List<CartItemDto> getCartItemByUserId(Long id) {

        List<CartItem>cartItems=cartItemRepository.findByUserId(id);
        List<CartItemDto>cartItemDtos=new ArrayList<>();
        for(CartItem c:cartItems) {
            Product p=productRepository.findById(c.getProductId()).orElseThrow(()->new FileSystemNotFoundException("Product Not Found"));
            cartItemDtos.add(new CartItemDto(c.getCartItemId(),c.getUserId(),c.getCartId(),c.getOrderId(),c.getProductId(),c.getCartItemQuantity(),c.getCartItemPrice(),p));
        }
        return cartItemDtos;
    }
  //  @Override
    public void deleteCartItemByUserId(Long id) {


    }

  //  @Override
    public void deleteCartItemByOrderId(Long id) {

    }

   // @Override
    public List<CartItem> getCartItemByOrderId(Long id) {
        return cartItemRepository.findByOrderId(id);
    }

    public List<CartItem> getCartItemByCartId(Long id) {
        return cartItemRepository.findByCartId(id);
    }

    public List<CartItem> getCartItemByProductId(Long uid,Long pid) {

      return  cartItemRepository.findByProductIdAndUserId(uid,pid);

    }

//    public List<CartItem> getCartItemByProductId(Long id) {
//    }
}
