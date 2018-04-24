package com.iancuio.starterapp.data.local.realm;

import io.realm.Realm;

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
}