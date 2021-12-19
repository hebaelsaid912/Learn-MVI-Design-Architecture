package com.example.android.learnmvidesignarchitecture


// في الكلاس دا بيعبر عن ال state الخاصه بال views
// او
// بال activity اللي بيتعامل معاها
sealed class MainViewState {

    // idle
        object Idle: MainViewState()
    //result
        //هنا هحتاج داتا تدخل لل فانكشن يبقا هعمله data class
        data class numResult(var num: Int ) : MainViewState()

    // error
        data class Error(var result: String ) : MainViewState()

    // loading في حاله اني مستني داتا مثلا او بتعامل مع api

}