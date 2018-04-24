package com.iancuio.starterapp.utils.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vlad.iancu on 2/23/2016.
 */
public class FragmentUtils {
    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, String tag) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle, String tag) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity,
                                       int enter, int exit, int popEnter, int popExit) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle,
                                       int enter, int exit, int popEnter, int popExit) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, String tag,
                                       int enter, int exit, int popEnter, int popExit) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void replaceFragment(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle, String tag,
                                       int enter, int exit, int popEnter, int popExit) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, String tag) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle, String tag) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity,
                                                    int enter, int exit, int popEnter, int popExit) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, String tag,
                                                    int enter, int exit, int popEnter, int popExit) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle,
                                                    int enter, int exit, int popEnter, int popExit) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .replace(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void replaceFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle, String tag,
                                                    int enter, int exit, int popEnter, int popExit) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .replace(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, String tag) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle, String tag) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity,
                                                int enter, int exit, int popEnter, int popExit) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .add(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle,
                                                int enter, int exit, int popEnter, int popExit) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .add(container, fragment)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, String tag,
                                                int enter, int exit, int popEnter, int popExit) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .add(container, fragment, tag)
                .commitAllowingStateLoss();
    }

    public static void addFragmentWithBackstack(Fragment fragment, Integer container, AppCompatActivity appCompatActivity, Bundle bundle, String tag,
                                                int enter, int exit, int popEnter, int popExit) {
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)
                .add(container, fragment, tag)
                .commitAllowingStateLoss();
    }
}
