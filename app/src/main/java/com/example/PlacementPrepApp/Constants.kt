package com.example.PlacementPrepApp


object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANS : String = "correct_answers"


    fun getQuestions():ArrayList<Question>{

        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"What will be the least number when divided by 4, 6, and 9 leaves a remainder of 3 in each case? ",
            R.drawable.tandw,
            "39","42",
            "45","None", 1

        )
        questionsList.add(que1)

        val que2 = Question(
            2,"If one third of one ninth of a number is 3. Then one ninth of that number is",
            R.drawable.log,
            "3","9",
            "81","None", 2

        )
        questionsList.add(que2)

        val que3 = Question(
            3,"If 79 parts of a number are added to that number then the number becomes 48. Then find that number.",
            R.drawable.alg,
            "42","21",
            "63","None", 2

        )
        questionsList.add(que3)

        val que4 = Question(
            4,"Find Four digit smallest number which is divisible by 24, 36 and 44 gives no remainder.",
            R.drawable.geo,
            "1584","1384",
            "1784","None", 1

        )
        questionsList.add(que4)

        val que5 = Question(
            5,"Value of 0.00201×0.51 will be",
            R.drawable.proba,
            "1000","1200",
            "5000","None", 1

        )
        questionsList.add(que5)

        val que6 = Question(
            6,"Total number of factors of 72 is",
            R.drawable.profit,
            "13","14",
            "12","16", 3

        )
        questionsList.add(que6)

        val que7 = Question(
            7,"When a number is divided by 32, the quotient is 27 and remainder is 6. What will be the remainder when the same number is divided by 17?",
            R.drawable.nextnum,
            "5","2",
            "4","3", 4

        )
        questionsList.add(que7)

        val que8 = Question(
            8,"When a number is divided by 9, then the remainder is 2. What will be the remainder when the square of that number is divided by 9?",
            R.drawable.simp,
            "3","4",
            "1","cannot find", 2

        )
        questionsList.add(que8)

        val que9 = Question(
            9,"If Product of two numbers is 1750 and LCM is 350 then what will be the HCF of those two numbers?",
            R.drawable.evolution,
            "15","5",
            "24","7", 2

        )
        questionsList.add(que9)

        return questionsList
    }
}