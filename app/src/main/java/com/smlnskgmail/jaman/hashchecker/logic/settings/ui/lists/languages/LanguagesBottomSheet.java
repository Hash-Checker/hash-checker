package com.smlnskgmail.jaman.hashchecker.logic.settings.ui.lists.languages;

import androidx.annotation.NonNull;

import com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.BaseListBottomSheet;
import com.smlnskgmail.jaman.hashchecker.components.bottomsheets.lists.adapter.BaseListAdapter;
import com.smlnskgmail.jaman.hashchecker.logic.locale.api.Language;
import com.smlnskgmail.jaman.hashchecker.logic.settings.impl.SharedPreferencesSettingsHelper;

import java.util.Arrays;

public class LanguagesBottomSheet extends BaseListBottomSheet<Language> {

    @NonNull
    @Override
    protected BaseListAdapter<Language> getItemsAdapter() {
        return new LanguagesListAdapter(
                Arrays.asList(Language.values()),
                this,
                SharedPreferencesSettingsHelper.getLanguage(
                        getContext()
                )
        );
    }

}
