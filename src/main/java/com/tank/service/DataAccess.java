package com.tank.service;


import lombok.NonNull;

import java.util.List;

/**
 * @author tank198435163.com
 */
public interface DataAccess {

  List<String> queryLatestOrders(@NonNull final String customerId);
}
