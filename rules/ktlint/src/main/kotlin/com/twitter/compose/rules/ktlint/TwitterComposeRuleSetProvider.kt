// Copyright 2022 Twitter, Inc.
// SPDX-License-Identifier: Apache-2.0
@file:Suppress("DEPRECATION")

package com.twitter.compose.rules.ktlint

import com.pinterest.ktlint.core.RuleProvider
import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider
import com.pinterest.ktlint.core.RuleSetProviderV2

class TwitterComposeRuleSetProvider :
    RuleSetProviderV2(
        CustomRuleSetId,
        RuleSetAbout
    ),
    RuleSetProvider {

    // Pre-0.47.0 ruleset (will go away in 0.48.0)
    @Suppress("OVERRIDE_DEPRECATION")
    override fun get(): RuleSet = RuleSet(
        CustomRuleSetId,
        ComposeCompositionLocalAllowlistCheck(),
        ComposeCompositionLocalNamingCheck(),
        ComposeContentEmitterReturningValuesCheck(),
        ComposeModifierComposableCheck(),
        ComposeModifierMissingCheck(),
        ComposeModifierReusedCheck(),
        ComposeModifierWithoutDefaultCheck(),
        ComposeMultipleContentEmittersCheck(),
        ComposeMutableParametersCheck(),
        ComposeNamingCheck(),
        ComposeParameterOrderCheck(),
        ComposePreviewNamingCheck(),
        ComposePreviewPublicCheck(),
        ComposeRememberMissingCheck(),
        ComposeViewModelForwardingCheck(),
        ComposeViewModelInjectionCheck()
    )

    // 0.47.0+ ruleset
    override fun getRuleProviders(): Set<RuleProvider> = setOf(
        RuleProvider { ComposeCompositionLocalAllowlistCheck() },
        RuleProvider { ComposeCompositionLocalNamingCheck() },
        RuleProvider { ComposeContentEmitterReturningValuesCheck() },
        RuleProvider { ComposeModifierComposableCheck() },
        RuleProvider { ComposeModifierMissingCheck() },
        RuleProvider { ComposeModifierReusedCheck() },
        RuleProvider { ComposeModifierWithoutDefaultCheck() },
        RuleProvider { ComposeMultipleContentEmittersCheck() },
        RuleProvider { ComposeMutableParametersCheck() },
        RuleProvider { ComposeNamingCheck() },
        RuleProvider { ComposeParameterOrderCheck() },
        RuleProvider { ComposePreviewNamingCheck() },
        RuleProvider { ComposePreviewPublicCheck() },
        RuleProvider { ComposeRememberMissingCheck() },
        RuleProvider { ComposeViewModelForwardingCheck() },
        RuleProvider { ComposeViewModelInjectionCheck() }
    )

    private companion object {
        private val RuleSetAbout = About(
            maintainer = "Twitter, Inc",
            description = "Static checks to aid with a healthy adoption of Jetpack Compose",
            license = "Apache License, Version 2.0",
            repositoryUrl = "https://github.com/twitter/compose-rules/",
            issueTrackerUrl = "https://github.com/twitter/compose-rules/issues"
        )
        const val CustomRuleSetId = "twitter-compose"
    }
}
