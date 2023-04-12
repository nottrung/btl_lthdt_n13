package model;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

public class Order {
    private LocalDate checkindate;
    private LocalDate checkoutdate;
    private User user;
    private Room room;

    public Order() {
    }

    public Order(LocalDate checkindate, LocalDate checkoutdate, User user, Room room) {
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.user = user;
        this.room = room;
    }

    public LocalDate getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(LocalDate checkindate) {
        this.checkindate = checkindate;
        this.room.setStatus(false);
    }

    public LocalDate getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(LocalDate checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    //tinh tien
    public long tinhtien()
    {
        long tongtien;
        //so ngay
        long songay = DAYS.between(checkindate, checkoutdate);
        //gia phong
        int gia = room.getPrice();
        tongtien = songay*gia;
        return tongtien;
    }
}
