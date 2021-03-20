package com.ndgndg91;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerApi {

    private final SellerRepository sellerRepository;

    public SellerApi(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @PostMapping("/apis/sellers")
    public ResponseEntity<SellerResponse> create() {
        Seller seller = new Seller();
        seller.setFullName("남동길");
        seller = sellerRepository.save(seller);
        SellerResponse response = new SellerResponse(seller.getId(), seller.getFullName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/apis/sellers/{id}")
    public ResponseEntity<SellerResponse> findById(@PathVariable long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        SellerResponse response = new SellerResponse(seller.getId(), seller.getFullName());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/apis/sellers/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        sellerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
