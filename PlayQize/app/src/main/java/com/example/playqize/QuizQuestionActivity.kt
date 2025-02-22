package com.example.playqize

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswers :Int = 0

    //initialized attributes
    private var progressBar: ProgressBar? = null
    private var txtProgress: TextView? = null
    private var txtQuestion: TextView? = null
    private var imgView: ImageView? = null
    private var txtOptionOne:TextView? = null
    private var txtOptionTwo:TextView? = null
    private var txtOptionThree:TextView? = null
    private var txtOptionFore:TextView? = null
    private var btnSubmit:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constance.USER_NAME)

        //Finding id of the attributes
        progressBar = findViewById(R.id.progressBar)
        txtProgress = findViewById(R.id.txtProgress)
        txtQuestion = findViewById(R.id.txtQuestion)
        imgView = findViewById(R.id.imgView)
        txtOptionOne = findViewById(R.id.txtOptionOne)
        txtOptionTwo = findViewById(R.id.txtOptionTwo)
        txtOptionThree = findViewById(R.id.txtOptionThree)
        txtOptionFore = findViewById(R.id.txtOptionFore)
        btnSubmit = findViewById(R.id.btnSubmit)

        txtOptionOne?.setOnClickListener(this)
        txtOptionTwo?.setOnClickListener(this)
        txtOptionThree?.setOnClickListener(this)
        txtOptionFore?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constance.getQuestions()
        setQuestion()
        defaultOptionView()
    }

    private fun setQuestion() {
        defaultOptionView()
        //Initialized the question set
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        txtProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        txtQuestion?.text = question.question
        txtOptionOne?.text = question.optionOne
        txtOptionTwo?.text = question.optionTwo
        txtOptionThree?.text = question.optionThree
        txtOptionFore?.text = question.optionFore
        imgView?.setImageResource(question.image)
        if (mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        txtOptionOne?.let {
            options.add(0,it)
        }
        txtOptionTwo?.let {
            options.add(1,it)
        }
        txtOptionThree?.let {
            options.add(2,it)
        }
        txtOptionFore?.let {
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition =selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.txtOptionOne ->{
                txtOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.txtOptionTwo ->{
                txtOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.txtOptionThree ->{
                txtOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.txtOptionFore ->{
                txtOptionFore?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btnSubmit ->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }else->{
                            //Toast.makeText(this,"Good Job",Toast.LENGTH_LONG).show()
                            val intent = Intent(this,resultActivity::class.java)
                            intent.putExtra(Constance.USER_NAME,mUserName)
                            intent.putExtra(Constance.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constance.TOTAL_QUESTION,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.currect_option_border_bg)
                    if (mCurrentPosition==mQuestionList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "Next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer: Int,drawable:Int){
        when(answer){
            1->{
                txtOptionOne?.background = ContextCompat.getDrawable(this,drawable)
            }
            2->{
                txtOptionTwo?.background = ContextCompat.getDrawable(this@QuizQuestionActivity,drawable)
            }
            3->{
                txtOptionThree?.background = ContextCompat.getDrawable(this@QuizQuestionActivity,drawable)
            }
            4->{
                txtOptionFore?.background = ContextCompat.getDrawable(this@QuizQuestionActivity,drawable)
            }

        }
    }
}