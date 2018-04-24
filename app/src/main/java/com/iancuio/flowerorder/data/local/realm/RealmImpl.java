package com.iancuio.flowerorder.data.local.realm;

import com.iancuio.flowerorder.ui.orders.Order;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

/**
 * Created by vlad.iancu on 3/1/2016.
 */
public class RealmImpl {
//    private static boolean checkIfObjectExistsInDb(Realm realm, Object Object) {
//        return realm.where(Object.class).equalTo("id", match.getId()).findFirst() == null;
//    }

    public static void clearRealmDb(Realm realm, Realm.Transaction.OnSuccess onSuccess, Realm.Transaction.OnError onError) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        }, onSuccess, onError);
    }

    public static void modifyRealmObject(Realm realm, final TransactionBody transactionBody) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                transactionBody.execute();
            }
        });
    }

    public static void saveOrderList(Realm realm, final List<Order> orderList, Realm.Transaction.OnSuccess onSuccess, Realm.Transaction.OnError onError) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (Order order : orderList) {
                    if (getOrderById(realm, order.getId()) != null) {
                        order.setNotNew(true);
                    }
                }
                realm.copyToRealmOrUpdate(orderList);
            }
        }, onSuccess, onError);
    }

    public static List<Order> getOrderList(Realm realm, boolean filterOnlyNew) {
        if (filterOnlyNew) {
            return realm.where(Order.class).equalTo("isNotNew", !filterOnlyNew).findAll().sort("dateMillis", Sort.DESCENDING);
        }

        return realm.where(Order.class).findAll().sort("dateMillis", Sort.DESCENDING);
    }

    public static Order getOrderById(Realm realm, long orderId) {
        return realm.where(Order.class).equalTo("id", orderId).findFirst();
    }

    public static List<Order> getOrderByIdList(Realm realm, List<Long> orderIdList) {
        if (orderIdList.size() != 0) {
            return realm.where(Order.class).in("id", orderIdList.toArray(new Long[]{})).findAll().sort("dateMillis", Sort.DESCENDING);
        }

        return new ArrayList<>();
    }
}