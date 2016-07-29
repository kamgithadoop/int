package algorithm;

import java.util.Scanner;

public class Solution {

    private static class Order{
        public int orderTime;
        public int processingTime;
        public int deliveryTime;
    }
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
            int numOrders = sc.nextInt();
            Order[] orders = new Order[numOrders];
            int x=0;
            while(sc.hasNextInt()){
                Order order = new Order();
                order.orderTime = sc.nextInt();
                order.processingTime = sc.nextInt();
                order.deliveryTime = order.orderTime + order.processingTime;
                orders[x++] = order;
            }
        
            
        for(int i = 0; i <= orders.length -1  ; i++){
            System.out.println(orders[i].orderTime + " " +  orders[i].processingTime);
        }
    }
    
    private void sort(Order[] orders){
        for(int i=0; i<orders.length -1; i++){
            for(int j = 0; j <(orders.length -2 -i) ; j++ ){
                if(orders[j].deliveryTime >orders[j +1].deliveryTime){
                    Order temp = orders[j +1];
                    orders[j +1] = orders[j];
                    orders[j]= temp;
                }
            }
        }
    }
}