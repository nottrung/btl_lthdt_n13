package controller;

import model.Order;
import model.Room;
import model.User;
import java.util.ArrayList;

public class Hotel {
    ArrayList<User> userlist = new ArrayList<>();
    ArrayList<Room> roomlist = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    public Hotel(ArrayList<User> userlist, ArrayList<Room> roomlist) {
        this.userlist = userlist;
        this.roomlist = roomlist;
    }

    public ArrayList<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(ArrayList<User> userlist) {
        this.userlist = userlist;
    }

    public ArrayList<Room> getRoomlist() {
        return roomlist;
    }

    public void setRoomlist(ArrayList<Room> roomlist) {
        this.roomlist = roomlist;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    // them phong
    public void addroom(Room room) {
        roomlist.add(room);
    }

    public void removeroom(Room rooms)
    {
        roomlist.remove(rooms);
    }

    //tinh tong so tien
    public long tongdoanhthu()
    {
        long total = 0;
        for(Order od : orders)
        {
            total += od.tinhtien();
        }
        return total;
    }
}
