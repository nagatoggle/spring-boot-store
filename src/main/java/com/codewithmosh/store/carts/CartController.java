package com.codewithmosh.store.carts;

import com.codewithmosh.store.common.ErrorDto;
import com.codewithmosh.store.products.ProductNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@AllArgsConstructor
@Tag(name = "Carts")
@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder
    ) {
        var cartDto = cartService.createCart();
        var uri = uriBuilder.path("/carts/{id}")
                        .buildAndExpand(cartDto.id())
                        .toUri();

        return ResponseEntity.created(uri).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    @Operation(summary = "Add a product to the cart.")
    public ResponseEntity<CartItemDto> addToCart(
            @Parameter(description = "The ID of the cart.")
            @PathVariable UUID cartId,
            @RequestBody addItemToCartRequest request
    ) {
        var cartItemDto = cartService.addToCart(cartId, request.productId());
        // 通常はcreated()でURIを返すが､ここではURIを送るのを省略した
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    @GetMapping("/{cartId}")
    public CartDto getCart(@PathVariable UUID cartId) {
        return cartService.getCart(cartId);
    }

    @PutMapping("/{cartId}/items/{productId}")
    public CartItemDto updateItem(
            @PathVariable UUID cartId,
            @PathVariable Long productId,
            @Valid @RequestBody UpdateCartItemRequest request
    ) {
        return cartService.updateItem(cartId, productId, request.quantity());
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public ResponseEntity<?> removeItem(
            @PathVariable UUID cartId,
            @PathVariable Long productId
    ) {
        cartService.removeItem(cartId,productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cartId}/items")
    public ResponseEntity<Void> clearCart(@PathVariable UUID cartId) {
        cartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ErrorDto> handleCartNotFound() {
        // URLから来たデータが見つからない､無効なURLの場合､Not Foundを返す
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorDto("Cart not found")
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFound() {
        // Requestから来たデータが見つからなかった場合､Bad Requestを返す
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDto("Product not found in the cart")
        );
    }
}
