package view;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Hotel;
import model.Order;
import model.Room;
import model.User;

public class Main {
    public static void main(String[] args) {
        User huy = new User("dang quang buoi", "2003", "123456789");
        User ha = new User("duong ngoc buoi", "2003", "987654321");
        ArrayList<User> users = new ArrayList<>();
        users.add(huy);
        users.add(ha);
        Room r1 = new Room("201", "xoang", 100);
        Room r2 = new Room("1001", "VIP", 10);
        Room r3 = new Room("202", "VIP", 20);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        Hotel binh = new Hotel(users, rooms);
        Order odha = new Order();
        odha.setUser(ha);
        odha.setRoom(r1);
        odha.setCheckindate(LocalDate.of(2022, 5, 20));
        odha.setCheckoutdate(LocalDate.of(2022, 5, 22)); 
        System.out.println(odha.toString()); 

        ArrayList<Order> ods = new ArrayList<>();
        ods.add(odha);
        binh.setOrders(ods);
        

        Order odhuy = new Order();
        odhuy.setUser(huy);
        odhuy.setRoom(r2);
        odhuy.setCheckindate(LocalDate.of(2023, 1, 10));
        odhuy.setCheckoutdate(LocalDate.of(2023, 1, 20));
        ods.add(odhuy);
        binh.setOrders(ods);
        
        System.out.println(binh.tongdoanhthu());
    }
}
