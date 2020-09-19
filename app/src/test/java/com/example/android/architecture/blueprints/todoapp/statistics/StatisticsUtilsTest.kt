package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_oneCompletedNoActive_returnsZeroHundred() {
        val tasks = listOf<Task> (
            Task("title", "description", isCompleted = true)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnsZeroHundred() {
        val tasks = listOf<Task> (
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_emptyOrNull_returnsZero() {
        val emptyTaskList = listOf<Task> ()

        val result1 = getActiveAndCompletedStats(emptyTaskList)

        assertThat(result1.completedTasksPercent, `is`(0f))
        assertThat(result1.activeTasksPercent, `is`(0f))

        val nullTaskList = null

        val result2 = getActiveAndCompletedStats(nullTaskList)

        assertThat(result2.completedTasksPercent, `is`(0f))
        assertThat(result2.activeTasksPercent, `is`(0f))
    }
}