package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

/**
 * @author 구본욱(bnoo1333@gmail.com)
 */
class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { /* TODO */ },
                currentScreen = RallyScreen.Accounts
            )
        }
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent { 
            RallyTopAppBar(allScreens = allScreens, onTabSelected = {}, currentScreen = RallyScreen.Accounts)
        }
        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.uppercase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }

    @Test
    fun rallyTopAppBarTest_changeSelection() {
        composeTestRule.setContent {
            RallyApp()
        }
        composeTestRule
            .onNode(
                hasContentDescription(RallyScreen.Overview.name)
            )
            .performClick()
        composeTestRule
            .onNode(
                hasContentDescription(RallyScreen.Accounts.name)
            )
            .assertExists()
            .assertIsNotSelected()
            .performClick()
            .assertIsSelected()
        composeTestRule
            .onNode(
                hasContentDescription(RallyScreen.Bills.name)
            )
            .assertExists()
            .assertIsNotSelected()
            .performClick()
            .assertIsSelected()
        composeTestRule
            .onNode(
                hasContentDescription(RallyScreen.Overview.name)
            )
            .assertExists()
            .assertIsNotSelected()
            .performClick()
            .assertIsSelected()
    }
}