package com.souvik.brainblitz



object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_QUESTIONS : String = "correct_questions"

    fun getQuestions() : ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1, "Which country this flag belongs to?", R.drawable.armenia, "Armenia", "Andorra","Azerbaijan",
            "Colombia", 1
        )

        val que2 = Questions(
            2, "Which country this flag belongs to?", R.drawable.iceland, "Finland", "Iceland","Denmark",
            "Sweden", 2
        )

        val que3 = Questions(
            3, "Which country this flag belongs to?", R.drawable.honduras, "Honduras", "Hawaii","Honululu",
            "Haiti", 1
        )

        val que4 = Questions(
            4, "Which country this flag belongs to?", R.drawable.luxembourg, "Netherlands", "Austria","San Marino",
            "Luxembourg", 4
        )

        val que5 = Questions(
            5, "Which country this flag belongs to?", R.drawable.niger, "India", "East-India","Niger",
            "Bosnia and Herzegovina", 3
        )

        val que6 = Questions(
            6, "Which country this flag belongs to?", R.drawable.canada, "Doobta Punjab", "Kannada","Canada",
            "Paisa Barbaad BC", 3
        )

        val que7 = Questions(
            7, "Which country this flag belongs to?", R.drawable.albania, "Albatross", "Andorra","Turkey",
            "Albania", 4
        )

        val que8 = Questions(
            8, "Who is this?", R.drawable.goat, "Cristiano Ronaldo", "Virat Kohli",
            "Souvik Karmakar", "All of the Above", 3
        )

        val que9 = Questions(
            9, "What this flag belongs to?", R.drawable.pansexual, "Pansexual", "Panama","Papua New Guinea",
            "Puerto Rico", 1
        )

        val que10 = Questions(
            1, "Which country this flag belongs to?", R.drawable.cambodia, "Casanova", "Cambodia",
            "Caribbean Islands", "Botswana", 2
        )






        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)


        return questionsList
    }
}