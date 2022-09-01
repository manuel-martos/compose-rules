// Copyright 2022 Twitter, Inc.
// SPDX-License-Identifier: Apache-2.0
package com.twitter.compose.rules.ktlint

import com.twitter.compose.rules.ComposeRememberMissing
import com.twitter.rules.core.ComposeKtVisitor
import com.twitter.rules.core.ktlint.TwitterKtlintRule

class ComposeRememberMissingCheck :
    TwitterKtlintRule("twitter-compose:remember-missing-check"),
    ComposeKtVisitor by ComposeRememberMissing()
