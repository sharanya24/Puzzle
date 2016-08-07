package com.pramati.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author sharanyak
 *
 */
public class App {

  int index = 0;
  double price = 0;

  
  /**
   * @param args
   */
  public static void main(String[] args) {


    ParseCsv parseCsv = new ParseCsv();
    ArrayList<RestaurantData> list = parseCsv.readCsv(args[0]);

    Collections.sort(list, new PriceComparator());
   /* for (RestaurantData restaurantData : list) {
      System.out.println(restaurantData);
    }*/


    List<Item> itemtoSearch = new ArrayList<Item>();
    for (int i = 1; i < args.length; i++) {
      itemtoSearch.add(new Item(args[i]));
    }

    App app = new App();
    app.findRestaurant(itemtoSearch, list);
  }

  /**
   * @param itemtoSearch
   * @param list
   */
  public void findRestaurant(List<com.pramati.puzzle.Item> itemtoSearch,
      List<RestaurantData> list) {

    List<Integer> restIds = new ArrayList<Integer>();
    for (Item items : itemtoSearch) {
      for (RestaurantData data : list) {
        String restaurantItem = data.getItems();
        if (restaurantItem.equals(itemtoSearch.get(index).getItemName())) {
          restIds.add(data.getRestId());
          price += data.getPrice();
          index++;
          break;
        }
      }
    }
    if (restIds.stream().allMatch(s -> s.equals(restIds.get(0)))) {
      System.out.println("Restaurant :" + restIds.get(0) + " total price :" + price);
    } else
      System.out.println("No Restaurant found with given input. Please try again..");
  }
}
