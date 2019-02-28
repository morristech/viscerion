/*
 * Copyright © 2017-2018 WireGuard LLC.
 * Copyright © 2019 Harsh Shandilya <msfjarvis@gmail.com>. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
package com.wireguard.android.util

import androidx.core.content.edit
import com.wireguard.android.Application

object ApplicationPreferences {
    const val appThemeKey = "dark_theme"
    const val globalExclusionsKey = "global_exclusions"
    const val forceUserspaceBackendkey = "force_userspace_backend"
    const val whitelistAppsKey = "whitelist_exclusions"
    const val taskerIntegrationSecretKey = "intent_integration_secret"
    private const val allowTaskerIntegrationKey = "allow_tasker_integration"

    var exclusions: String
        get() = Application.sharedPreferences.getString(globalExclusionsKey, "") ?: ""
        set(value) {
            Application.sharedPreferences.edit {
                putString(globalExclusionsKey, value)
            }
        }
    val exclusionsArray: ArrayList<String>
        get() = exclusions.toArrayList()

    val useDarkTheme: Boolean
        get() = Application.sharedPreferences.getBoolean(appThemeKey, false)

    val forceUserspaceBackend: Boolean
        get() = Application.sharedPreferences.getBoolean(forceUserspaceBackendkey, false)

    val whitelistApps: Boolean
        get() = Application.sharedPreferences.getBoolean(whitelistAppsKey, false)

    val allowTaskerIntegration: Boolean
        get() = Application.sharedPreferences.getBoolean(allowTaskerIntegrationKey, false)

    val taskerIntegrationSecret: String
        get() = Application.sharedPreferences.getString(taskerIntegrationSecretKey, "") ?: ""
}
