package app.controller;

import app.service.BookingService;

public class BookingConrtoller {

    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        bookingService.create();
        System.out.println(bookingService.getAll());

    }
}
