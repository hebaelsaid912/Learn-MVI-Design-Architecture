package com.example.android.learnmvidesignarchitecture



// نوايا المستخدم
// بنضيف هنا كل ال actions اللي ممكن ال user
// يعملها لما يستخدم ال activity  الخاصه بالكلاس دا

// ليه sealed ؟
// عشان اجبر ال user انه مدام استخدم الكلاس دا
// يبقا لازم يستخدم حاجه من اللي فيه تشبه ال enum
sealed class MainIntent {

    object addNumber:MainIntent()
}