package com.example.storybookapp.Classes

import java.io.Serializable

data class StoryData(
    val authorId:String="",
    val storynName:String="",
    val storyDesc:String=""
):Serializable