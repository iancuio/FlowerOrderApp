package com.iancuio.starterapp.utils.permissions;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad.iancu on 03.07.2017.
 */

public class PermissionUtils {
    private static void requestPermissions(Activity activity, String[] permissionList, int requestCode) {
        ActivityCompat.requestPermissions(activity, permissionList, requestCode);
    }

    private static void requestPermissions(Fragment fragment, String[] permissionList, int requestCode) {
        fragment.requestPermissions(permissionList, requestCode);
    }

    public static boolean checkAndRequestPredefinedPermissions(Activity activity, int requestCode) {
        List<String> notGrantedPermissionsList = new ArrayList<>();

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.READ_PHONE_STATE);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.CAMERA);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (notGrantedPermissionsList.size() == 0) {
            return true;
        } else {
            requestPermissions(activity, notGrantedPermissionsList.toArray(new String[notGrantedPermissionsList.size()]), requestCode);
        }

        return notGrantedPermissionsList.size() == 0;
    }

    public static boolean checkAndRequestPredefinedPermissions(Fragment fragment, int requestCode) {
        List<String> notGrantedPermissionsList = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.READ_PHONE_STATE);
        }

        if (ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.CAMERA);
        }

        if (ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (ContextCompat.checkSelfPermission(fragment.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            notGrantedPermissionsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (notGrantedPermissionsList.size() == 0) {
            return true;
        } else {
            requestPermissions(fragment, notGrantedPermissionsList.toArray(new String[notGrantedPermissionsList.size()]), requestCode);
        }

        return notGrantedPermissionsList.size() == 0;
    }

    public static boolean checkAndRequestPermissions(Activity activity, String[] permissionList, int requestCode) {
        List<String> notGrantedPermissionsList = new ArrayList<>();

        for (String permission : permissionList) {
            if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                notGrantedPermissionsList.add(permission);
            }
        }

        if (notGrantedPermissionsList.size() == 0) {
            return true;
        } else {
            requestPermissions(activity, notGrantedPermissionsList.toArray(new String[notGrantedPermissionsList.size()]), requestCode);
        }

        return notGrantedPermissionsList.size() == 0;
    }

    public static boolean checkAndRequestPermissions(Fragment fragment, String[] permissionList, int requestCode) {
        List<String> notGrantedPermissionsList = new ArrayList<>();

        for (String permission : permissionList) {
            if (ContextCompat.checkSelfPermission(fragment.getContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                notGrantedPermissionsList.add(permission);
            }
        }

        if (notGrantedPermissionsList.size() == 0) {
            return true;
        } else {
            requestPermissions(fragment, notGrantedPermissionsList.toArray(new String[notGrantedPermissionsList.size()]), requestCode);
        }

        return notGrantedPermissionsList.size() == 0;
    }

    public static boolean checkIfAllPermissionsGranted(int[] permissionList) {
        for (int permissionStatus : permissionList) {
            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
}
