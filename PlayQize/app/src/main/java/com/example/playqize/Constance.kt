package com.example.playqize

object Constance {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION : String = "total_question"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        // Q1
        val que1 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia",
            "Armenia","Austria",
            1
        )
        questionList.add(que1)
        //Q2
        val que2 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "India","Australia",
            "America","Rasia",
            2
        )
        questionList.add(que2)
        //Q3
        val que3 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "China","Australia",
            "France","Belgium",
            4
        )
        questionList.add(que3)
        //Q4
        val que4 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil","Canada",
            "England","Bangladesh",
            1
        )
        questionList.add(que4)
        //Q5
        val que5 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Brazil","Iceland",
            "Denmark","Nepal",
            3
        )
        questionList.add(que5)
        //Q6
        val que6 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Kuwait","Fiji",
            "India","Srilenka",
            2
        )
        questionList.add(que6)
        //Q7
        val que7 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Bhutan","Fiji",
            "New_Zealand","Germany",
            4
        )
        questionList.add(que7)
         //Q8
        val que8 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India","Japan",
            "America","Australia",
            1
        )
        questionList.add(que8)
        //Q9
        val que9 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "South Korea","Fiji",
            "kuwait","Australia",
            3
        )
        questionList.add(que9)
        //Q10
        val que10 = Question(
            1,"What country dose this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Brazil","Fiji",
            "India","NewZealand",
            4
        )
        questionList.add(que10)


        return questionList

    }
}