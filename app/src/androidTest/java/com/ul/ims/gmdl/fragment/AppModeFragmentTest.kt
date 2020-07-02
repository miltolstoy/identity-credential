/*
 * Copyright (C) 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package com.ul.ims.gmdl.fragment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.ul.ims.gmdl.R
import com.ul.ims.gmdl.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppModeFragmentTest {

    // Grant Camera Permission
    @Rule @JvmField
    val grantPermissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(android.Manifest.permission.CAMERA)

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testUi() {
        onView(withId(R.id.btn_holder)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_select_function_label)).check(matches(isDisplayed()))
    }

    @Test
    fun onHolderSelectedTest() {
        onView(withId(R.id.btn_holder)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_holder)).perform(click())

        // Check if we moved to the next fragment
        onView(withText(R.string.credentials_list)).check(matches(isDisplayed()))
    }

}