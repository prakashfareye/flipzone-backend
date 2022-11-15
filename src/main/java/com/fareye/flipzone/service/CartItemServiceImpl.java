package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Cart;
import com.fareye.flipzone.model.CartItem;
import com.fareye.flipzone.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl {

    @Autowired
    CartItemRepository cartItemRepository;
  //  @Override
    public CartItem addCartItem(CartItem cartitem) {

     CartItem CartitemDBsaved=(CartItem)cartItemRepository.save(cartitem);

       return CartitemDBsaved;
    }
  //  @Override
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }
  //  @Override
    public List<CartItem> getCartItemByUserId(Long id) {

        return cartItemRepository.findByUserId(id);
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
}
