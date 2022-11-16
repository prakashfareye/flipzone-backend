package com.fareye.flipzone.controller;

import com.fareye.flipzone.dto.CartItemDto;
import com.fareye.flipzone.model.*;
import com.fareye.flipzone.service.CartItemService;
import com.fareye.flipzone.service.CartItemServiceImpl;
import com.fareye.flipzone.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
    @Autowired
    CartItemServiceImpl cartItemService;

    @GetMapping
    public List<CartItem> getCartItems(){

        return cartItemService.getCartItems();

    }
    @PostMapping
    public CartItem addCartItems(@RequestBody CartItem cartitem){

        return cartItemService.addCartItem(cartitem);

    }
    @GetMapping("/u/{id}")
    public List<CartItemDto> getCartItemByUserId(@PathVariable Long id){

        return cartItemService.getCartItemByUserId(id);
    }

    @DeleteMapping("/u/{id}")
    public void DeleteCartItemByUserId(@PathVariable Long id){
        cartItemService.deleteCartItemsByUserId(id);
    }

    @GetMapping("/o/{id}")
    public List<CartItem> getCartItemByOrderId(@PathVariable Long id){

        return cartItemService.getCartItemByOrderId(id);
    }
    @DeleteMapping("/o/{id}")
    public void DeleteCartItemByOrderId(@PathVariable Long id){
         cartItemService.deleteCartItemByOrderId(id);
    }
    @GetMapping("/c/{id}")
    public List<CartItem> getCartItemByCartId(@PathVariable Long id){

        return cartItemService.getCartItemByCartId(id);
    }
    @GetMapping("/p/{uid}/{pid}")
    public List<CartItem> getCartItemByProductId(@PathVariable Long pid,@PathVariable Long uid) {

        return cartItemService.getCartItemByProductId(pid, uid);

    }
    @PutMapping("/increase/{id}")
    public CartItem IncreaseItemCount (@PathVariable Long id) {
        CartItem cartItem = cartItemService.getCartItemByCartItemtId(id);
        return cartItemService.updateCartItem(id, cartItem, 1);
    }

    @PutMapping("/decrease/{id}")
    public CartItem DecreaseItemCount (@PathVariable Long id) {
        CartItem cartItem = cartItemService.getCartItemByCartItemtId(id);
        return cartItemService.updateCartItem(id, cartItem, -1);
    }

    @DeleteMapping("/c/{id}")
    public void DeleteCartItemByCartItemId(@PathVariable Long id){
        cartItemService.deleteCartItemByCartItemId(id);
    }

}
