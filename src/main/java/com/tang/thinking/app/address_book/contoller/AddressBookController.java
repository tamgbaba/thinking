package com.tang.thinking.app.address_book.contoller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("app")
public class AddressBookController {

    @PostMapping
    public boolean save() {

        return true;
    }
}
