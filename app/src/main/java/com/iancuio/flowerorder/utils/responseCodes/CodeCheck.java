package com.iancuio.flowerorder.utils.responseCodes;

/**
 * Created by vlad.iancu on 4/8/2016.
 */
    public interface CodeCheck {
        void on200(); //OK
        void on401(); //UNAUTHORIZED
        void on404(); //NOT FOUND
        void on500(); //INTERNAL SERVER ERROR
        void onOther(); //UNKNOWN
}
