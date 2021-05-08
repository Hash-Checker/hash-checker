package com.smlnskgmail.jaman.hashchecker.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.annotation.NonNull;

import com.smlnskgmail.jaman.hashchecker.R;
import com.smlnskgmail.jaman.hashchecker.components.dialogs.system.AppSnackbar;
import com.smlnskgmail.jaman.hashchecker.logic.settings.api.SettingsHelper;
import com.smlnskgmail.jaman.hashchecker.logic.themes.api.ThemeHelper;

public class WebUtils {

    private WebUtils() {

    }

    public static void openGooglePlay(
            @NonNull Context context,
            @NonNull View view,
            @NonNull SettingsHelper settingsHelper,
            @NonNull ThemeHelper themeHelper
    ) {
        final String appPackageName = context.getPackageName();
        Uri link;
        try {
            link = Uri.parse("market://details?id=" + appPackageName);
            context.startActivity(
                    new Intent(
                            Intent.ACTION_VIEW,
                            link
                    )
            );
        } catch (ActivityNotFoundException e) {
            try {
                link = Uri.parse(
                        "https://play.google.com/store/apps/details?id=" + appPackageName
                );
                context.startActivity(
                        new Intent(
                                Intent.ACTION_VIEW,
                                link
                        )
                );
            } catch (ActivityNotFoundException e2) {
                LogUtils.e(e2);
                new AppSnackbar(
                        context,
                        view,
                        R.string.message_error_start_google_play,
                        settingsHelper,
                        themeHelper
                ).show();
            }
        }
    }

    public static void openWebLink(
            @NonNull Context context,
            @NonNull String link
    ) {
        try {
            context.startActivity(
                    new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(link)
                    )
            );
        } catch (ActivityNotFoundException e) {
            LogUtils.e(e);
        }
    }

}
